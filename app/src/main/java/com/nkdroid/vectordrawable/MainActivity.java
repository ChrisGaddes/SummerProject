package com.nkdroid.vectordrawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by cagad on 5/31/2016.
 */

public class MainActivity extends Activity {


    private Button btnDemo;
    private boolean isClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_demo_activity);

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