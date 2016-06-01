package com.nkdroid.vectordrawable;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "CAG"; //TODO Figure out what tag is
    Toolbar mToolbar;
    Button mBtnAdd;
    boolean isClicked;

    // initializes arrow buttons
    Button arrow_west;
    Button arrow_north;
    Button arrow_east;
    Button arrow_south;

    // initializes arrow states to unclicked
    boolean isBtnArrowEastClicked = false;
    boolean isBtnArrowWestClicked = false;
    boolean isBtnArrowNorthClicked = false;
    boolean isBtnArrowSouthClicked = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find View-elements
        arrow_east = (Button) findViewById(R.id.btn_1);
        arrow_west = (Button) findViewById(R.id.btn_2);
        arrow_north = (Button) findViewById(R.id.btn_3);
        arrow_south = (Button) findViewById(R.id.btn_4);

        // assign listeners to buttons
        arrow_west.setOnClickListener(this);
        arrow_north.setOnClickListener(this);
        arrow_east.setOnClickListener(this);
        arrow_south.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        // define the button that invoked the listener by id

        switch (v.getId()) {
            case R.id.btn_1:
                //arrow_west.setText("OK button was clicked");
                Toast.makeText(MainActivity.this, "btn1", Toast.LENGTH_SHORT).show();
                isBtnArrowEastClicked = !isBtnArrowEastClicked; // cycles arrow and box
                int resId1 = isBtnArrowEastClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_east;
                arrow_east.setBackgroundResource(resId1); // sets background
                break;
            case R.id.btn_2:
                Toast.makeText(MainActivity.this, "btn2", Toast.LENGTH_SHORT).show();
                isBtnArrowWestClicked = !isBtnArrowWestClicked; // cycles arrow and box
                int resId2 = isBtnArrowWestClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_west;
                arrow_west.setBackgroundResource(resId2); // sets background
                break;
            case R.id.btn_3:
                isBtnArrowNorthClicked = !isBtnArrowNorthClicked; // cycles arrow and box
                int resId3 = isBtnArrowNorthClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_north;
                arrow_north.setBackgroundResource(resId3); // sets background
                break;
            case R.id.btn_4:
                isBtnArrowSouthClicked = !isBtnArrowSouthClicked; // cycles arrow and box
                int resId4 = isBtnArrowSouthClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_south;
                arrow_south.setBackgroundResource(resId4); // sets background
                break;
        }
    }
}