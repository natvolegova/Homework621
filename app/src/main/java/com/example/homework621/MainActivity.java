package com.example.homework621;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnPrev;
    private ImageButton btnNext;
    private TextView txtName;
    private ImageView img;
    private Random random = new Random();
    private TypedArray imgs;
    private TypedArray image_name;
    private static String LOG_NAME = "Lifecycle";
    private int ActivityNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //устанавливаем фон и подпись к изображению
        int value = random.nextInt(3);
        imgs = getResources().obtainTypedArray(R.array.image_src);
        img.setImageResource(imgs.getResourceId(value, -1));
        image_name = getResources().obtainTypedArray(R.array.image_name);
        txtName.setText(image_name.getText(value));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //логирование
        if (ActivityNumber == 0) {
            ActivityNumber = random.nextInt(10);
        }
        Log.d(LOG_NAME, ActivityNumber + " onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_NAME, ActivityNumber + " onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_NAME, ActivityNumber + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_NAME, ActivityNumber + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_NAME, ActivityNumber + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_NAME, ActivityNumber + " onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_NAME, ActivityNumber + " onRestart");
    }

    private void initView() {
        btnPrev = findViewById(R.id.btn_prev);
        btnNext = findViewById(R.id.btn_next);
        txtName = findViewById(R.id.txt_name);
        img = findViewById(R.id.img);
    }
}
