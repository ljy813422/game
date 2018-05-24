package com.xiaobai.game.mygame.activity;

import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.xiaobai.game.mygame.R;
import com.xiaobai.game.mygame.test.TestActivity;
import com.xiaobai.game.mygame.util.DialogUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.up_container)
    LinearLayout upContainer;
    @BindView(R.id.up_scoll_container)
    ScrollView upScollContainer;
    @BindView(R.id.down_container)
    RelativeLayout downContainer;
    @BindView(R.id.down_scoll_container)
    ScrollView downScollContainer;
    @BindView(R.id.place_holder_view)
    View placeHolderView;
    @BindView(R.id.up_place_holder_view)
    View upPlaceHolderView;
    @BindView(R.id.up_rl_container)
    RelativeLayout upRlContainer;

    private AlertDialog alertDialog;
    private DisplayMetrics dm;
    //是否显示 login
    private boolean isLogin = true;
    private ValueAnimator comeAnimator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.exit).setOnClickListener(this);

        dm = getResources().getDisplayMetrics();


        Log.d("MainActivity", "" + dm.heightPixels + "-----" + dm.widthPixels);
        upContainer.getLayoutParams().height = dm.heightPixels;
        downContainer.getLayoutParams().height = dm.heightPixels;
        placeHolderView.getLayoutParams().height = dm.heightPixels / 2;
        upPlaceHolderView.getLayoutParams().height = dm.heightPixels / 2;
        upRlContainer.getLayoutParams().height = dm.heightPixels / 2;
        upScollContainer.scrollTo(0, dm.heightPixels / 2);
        upScollContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        downScollContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();

        if (isLogin) {
            comeAnimator = ValueAnimator.ofInt(0, dm.heightPixels / 2);
            comeAnimator.setDuration(1000);
            comeAnimator.setInterpolator(new AccelerateInterpolator());
            comeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {

                    int value = (int) animation.getAnimatedValue();
                    upScollContainer.scrollTo(0, dm.heightPixels / 2 - value);
                    downScollContainer.scrollTo(0, value);
                }
            });
            comeAnimator.start();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (comeAnimator != null) {
            comeAnimator.cancel();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                //
                startActivity(new Intent(this, TestActivity.class));
                finish();
                break;
            case R.id.exit:
                //exit();
                DialogUtil.exit(this);
                break;
        }

    }

    /**
     * 提出去
     */
    private void exit() {
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle(getResources().getString(R.string.exit))
                    .setMessage(getResources().getString(R.string.sure_to_exit))
                    .setNegativeButton(getResources().getString(R.string.exit), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    }).setPositiveButton(getResources().getString(R.string.cancle), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialog = builder.create();
        }
        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.light_dark_text_color));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.blue_text_color));

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
           // exit();
            DialogUtil.exit(this);
        }
        return super.onKeyDown(keyCode, event);
    }
}
