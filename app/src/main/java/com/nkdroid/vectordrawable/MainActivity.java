package com.nkdroid.vectordrawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


    private Button btnDemo;
    private boolean isPink = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_demo_activity);

        btnDemo = (Button) findViewById(R.id.btnDemo);
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPink = !isPink;
                int resId = isPink ? R.drawable.btn_unpressed : R.drawable.btn_pressed;
                btnDemo.setBackgroundResource(resId);
                btnDemo.setText(isPink ? "PINK" : "BLUE");
            }
        });
    }
}