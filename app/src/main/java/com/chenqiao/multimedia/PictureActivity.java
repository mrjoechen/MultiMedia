package com.chenqiao.multimedia;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);


        ImageView imageView1 = findViewById(R.id.iv1);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.raw.iron_man);
        imageView1.setImageBitmap(bitmap);




    }

}
