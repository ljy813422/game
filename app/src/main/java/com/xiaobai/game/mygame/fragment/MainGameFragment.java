package com.xiaobai.game.mygame.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.xiaobai.game.mygame.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ljy123 on 2018/5/25.
 */

public class MainGameFragment extends BaseFragment implements SurfaceHolder.Callback, Runnable {

    @BindView(R.id.surface_view)
    SurfaceView surfaceView;
    private Unbinder unbinder;

    // 用于绘图的Canvas
    private Canvas mCanvas;
    // 子线程标志位
    private boolean mIsDrawing;
    private SurfaceHolder mHolder;

    //刷新幀
    private int refreshTime = 50;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    /**
     * 初始化
     */
    private void init() {
        mHolder = surfaceView.getHolder();
        mHolder.addCallback(this);
        surfaceView.setFocusable(true);
        surfaceView.setFocusableInTouchMode(true);
        surfaceView.setKeepScreenOn(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    @Override
    public void run() {
        while (mIsDrawing) {
            long startTime = System.currentTimeMillis();
            try {
                mCanvas = mHolder.lockCanvas();

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.forest);
                mCanvas.drawBitmap(bitmap, 0, 0, new Paint());


                // draw sth绘制过程
            } catch (Exception e) {
            } finally {
                if (mCanvas != null)
                    mHolder.unlockCanvasAndPost(mCanvas);//保证每次都将绘图的内容提交
            }
            long enTime = System.currentTimeMillis();
            while (enTime - startTime < refreshTime) {
                Thread.yield();
                enTime = System.currentTimeMillis();
            }

        }
    }
}
