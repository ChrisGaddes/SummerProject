package com.nkdroid.vectordrawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


    private Button btn_arrow_east;
    private Button btn_arrow_west;
    private Button btn_arrow_north;
    private Button btn_arrow_south;

    private boolean isClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_arrow_east = (Button) findViewById(R.id.btn_1);

        btn_arrow_east.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked = !isClicked;
                int resId = isClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_east;
                btn_arrow_east.setBackgroundResource(resId);
                //btn_arrow_east.setText(isClicked ? "PINK" : "BLUE");
            }
        });

        btn_arrow_west = (Button) findViewById(R.id.btn_2);

        btn_arrow_west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked = !isClicked;
                int resId = isClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_west;
                btn_arrow_west.setBackgroundResource(resId);
                //btn_arrow_east.setText(isClicked ? "PINK" : "BLUE");
            }
        });


        btn_arrow_north = (Button) findViewById(R.id.btn_3);

        btn_arrow_north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked = !isClicked;
                int resId = isClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_north;
                btn_arrow_north.setBackgroundResource(resId);
                //btn_arrow_east.setText(isClicked ? "PINK" : "BLUE");
            }
        });

        btn_arrow_south = (Button) findViewById(R.id.btn_4);

        btn_arrow_south.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked = !isClicked;
                int resId = isClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_south;
                btn_arrow_south.setBackgroundResource(resId);
                //btn_arrow_east.setText(isClicked ? "PINK" : "BLUE");
            }
        });



    }
}