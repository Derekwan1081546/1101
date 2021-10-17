package com.cornez.tapbuttoncounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.*;
import java.lang.*;
import java.io.*;

public class MainActivity extends Activity {

    //MODEL
    private Counter count;
    private Counter count2;
    private Counter count3;

    //VIEW
    private TextView display;
    private TextView display2;
    private TextView display3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        count = new Counter();
        count2 = new Counter();
        count3 =new Counter();
        count.CountVal(28);
        count2.CountVal(50);
        count3.CountVal(0);
        display = (TextView) findViewById(R.id.textView);
        display2 = (TextView) findViewById(R.id.textView6);
        display3 = (TextView) findViewById(R.id.textView5);
    }

    public void countPlus(View view){
        count.addCount();
        if(count.getCount()>50)
            count.CountVal(15);
        display.setText(count.getCount().toString());
    }
    public void countPlus2(View view){
        count2.addCount();
        if(count2.getCount()>90)
            count2.CountVal(40);
        display2.setText(count2.getCount().toString());
    }
    public void countMinus(View view){
        count.minusCount();
        if(count.getCount()<15)
            count.CountVal(50);
        display.setText(count.getCount().toString());
    }
    public void countMinus2(View view){
        count2.minusCount();
        if(count2.getCount()<40)
            count2.CountVal(90);
        display2.setText(count2.getCount().toString());
    }
    public void reset(View view){
        count.CountVal(28);
        count2.CountVal(50);
        display.setText(count.getCount().toString());
        display2.setText(count2.getCount().toString());
        display3.setText("");
    }
    public void comp(View view) {
        double c1=-8.78469475556,c2 = 1.61139411
                ,c3 = 2.33854883889,c4 = -0.14611605,c5 = -0.012308094
                ,c6 = -0.0164248277778,c7 = 0.002211732
                ,c8 = 0.00072546,c9 = -0.000003582;
        int t=count.getCount();
        int r=count2.getCount();
        double hi;
        hi= c1 + c2*t + c3*r + c4*t*r + c5*t*t + c6*r*r + c7*t*t*r + c8*t*r*r + c9*t*t*r*r;
        double roundDbl = Math.round(hi*10.0)/10.0;
        display3.setText(""+roundDbl);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        // this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
