package com.chrisgaddes.freebodydiagram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

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

    // started here adding new button
    public Button btn_load_main_screen;

    // create the method
    public void init(){
        btn_load_main_screen = (Button) findViewById(R.id.btn_load_main_screen);
        btn_load_main_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this,SecondActivity.class);

                startActivity(toy);
            }
        });
    }

//    public Button btn_load_second_screen;
//
//    // create the method
//    public void init2(){
//        btn_load_second_screen=(Button)findViewById(R.id.btn_load_second_screen);
//        btn_load_second_screen.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent toy=new Intent(MainActivity.this,SecondActivity.class);
//
//                startActivity(toy);
//            }
//        });
//    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // starts init
        init();
        //init2();

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
                                int resId1 = isBtnArrowEastClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_east;
                arrow_east.setBackgroundResource(resId1); // sets background
                isBtnArrowEastClicked = !isBtnArrowEastClicked; // cycles arrow and box
                break;
            case R.id.btn_2:
                Toast.makeText(MainActivity.this, "btn2", Toast.LENGTH_SHORT).show();
                int resId2 = isBtnArrowWestClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_west;
                arrow_west.setBackgroundResource(resId2); // sets background
                isBtnArrowWestClicked = !isBtnArrowWestClicked; // cycles arrow and box
                break;
            case R.id.btn_3:
                int resId3 = isBtnArrowNorthClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_north;
                arrow_north.setBackgroundResource(resId3); // sets background
                isBtnArrowNorthClicked = !isBtnArrowNorthClicked; // cycles arrow and box
                break;
            case R.id.btn_4:
                int resId4 = isBtnArrowSouthClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_south;
                arrow_south.setBackgroundResource(resId4); // sets background
                isBtnArrowSouthClicked = !isBtnArrowSouthClicked; // cycles arrow and box
                break;
        }
    }
}