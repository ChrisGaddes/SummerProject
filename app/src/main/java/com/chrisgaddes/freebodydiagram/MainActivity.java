package com.chrisgaddes.freebodydiagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_initiate_popup;
    private PopupWindow popupWindow;
    private RelativeLayout relativeLayoutMainActivity;

    // layoutInflator allows loading a new layout inside our popped window
    private LayoutInflater layoutInflater;

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
    public void init() {
        btn_load_main_screen = (Button) findViewById(R.id.btn_load_main_screen);
        btn_load_main_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(toy);
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // starts init
        init();

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


        btn_initiate_popup = (Button) findViewById(R.id.btn_initiate_popup);
        relativeLayoutMainActivity = (RelativeLayout) findViewById(R.id.relative_layout_activity_main);

        // listens for touch on button btn_initiate_popup

        btn_initiate_popup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                // gets center coordinates of button and matches it to center of popup
                int width_popup = 500; // width of popup
                int height_popup = 500; // height of popup
                int pos[] = new int[2];
                btn_initiate_popup.getLocationOnScreen(pos); // get location of pressed button
                int x1 = pos[0], y1 = pos[1];
                int loc_popup_x = x1 + btn_initiate_popup.getWidth() / 2 - width_popup / 2;
                int loc_popup_y = y1 + btn_initiate_popup.getHeight() / 2 - height_popup / 2;

                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.activity_popup_buttons, null);

                popupWindow = new PopupWindow(container, width_popup, height_popup, true);
                popupWindow.showAtLocation(relativeLayoutMainActivity, Gravity.NO_GRAVITY, loc_popup_x, loc_popup_y);

                popupWindow.setFocusable(false);
                popupWindow.setOutsideTouchable(true);

                // setBackgroundDrawable(Drawable background)
                // Specifies the background drawable for this popup window.


                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        popupWindow.dismiss();
                        return true;
                    }
                });
                return false;
            }
        });


    }


    @Override
    public void onClick(View v) {
        // define the button that invoked the listener by id

        switch (v.getId()) {
            case R.id.btn_1:
                //arrow_west.setText("OK button was clicked");
                int resId1 = isBtnArrowEastClicked ? R.drawable.btn_unpressed : R.drawable.btn_pressed_east;
                arrow_east.setBackgroundResource(resId1); // sets background
                isBtnArrowEastClicked = !isBtnArrowEastClicked; // cycles arrow and box
                break;
            case R.id.btn_2:
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