package com.chenqiao.multimedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * 绘制图片方式
     */
    public void openPictureAct(View v){
        Intent intent = new Intent(MainActivity.this, PictureActivity.class);
        startActivity(intent);
    }
}
