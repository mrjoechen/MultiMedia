package com.chenqiao.multimedia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class PictureActivity extends AppCompatActivity {

    private Bitmap mBitmap ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);


        mBitmap = BitmapFactory.decodeResource(getResources(), R.raw.iron_man);
        Matrix matrix = new Matrix();
        matrix.preScale(0.1f, 0.1f);
        mBitmap =  Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight(), matrix, false); // 获取bitmap

        //ImageView 展示图片
        ImageView imageView1 = findViewById(R.id.iv1);
        imageView1.setImageBitmap(mBitmap);

        //SurfaceView展示图片
        showSurface();

        //自定义view展示图片
//        CustomView customView = new CustomView(this);



    }
    SurfaceHolder mSurfaceHolder;

    private void showSurface(){

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

//                while (true){
                    if (mSurfaceHolder != null){
                        Paint paint = new Paint();
                        paint.setAntiAlias(true);
                        paint.setStyle(Paint.Style.STROKE);


                        Canvas canvas = mSurfaceHolder.lockCanvas();  // 先锁定当前surfaceView的画布
                        canvas.drawBitmap(mBitmap, 0, 0, paint); //执行绘制操作
                        mSurfaceHolder.unlockCanvasAndPost(canvas); // 解除锁定并显示在界面上
                    }
//                }


            }
        });
        SurfaceView surfaceView = findViewById(R.id.surface);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                mSurfaceHolder = surfaceHolder;
                thread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

    }

}
