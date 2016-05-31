package com.nkdroid.vectordrawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


    private Button btnDemo;
    private boolean isClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo = (Button) findViewById(R.id.btn_1);

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked = !isClicked;
                int resId = isClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed;
                btnDemo.setBackgroundResource(resId);
                //btnDemo.setText(isClicked ? "PINK" : "BLUE");
            }
        });
    }
}