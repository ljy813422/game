package com.xiaobai.game.mygame;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.exit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                break;
            case R.id.exit:
                exit();
                break;
        }

    }

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

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode ==KeyEvent.KEYCODE_BACK){
            exit();
        }
        return super.onKeyDown(keyCode, event);
    }
}
