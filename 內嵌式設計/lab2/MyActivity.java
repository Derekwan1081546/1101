package com.cornez.shippingcalculator;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity {
    //DATA MODEL FOR SHIP ITEM
    private ShipItem shipItem;

    //VIEW OBJECTS FOR LAYOUT UI REFERENCE
    private EditText height;
    private EditText weight;
    private EditText activity;
    private TextView standard;
    private TextView range;
    private TextView cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //CREATE THE DATA MODEL FOR STORING THE ITEM TO BE SHIPPED
        shipItem = new ShipItem();

        //TASK 3: ESTABLISH THE REFERENCES TO INPUT WEIGHT ELEMENT
        //final EditText height=(EditText)findViewById(R.id.editText1);
        //final EditText weight=(EditText)findViewById(R.id.editText1);
        //final EditText activity=(EditText)findViewById(R.id.editText1);
        height = (EditText) findViewById(R.id.editText1);
        weight = (EditText) findViewById(R.id.editText2);
        activity = (EditText) findViewById(R.id.editText3);


        //TASK 3: ESTABLISH THE REFERENCES TO OUTPUT ELEMENTS
        standard = (TextView) findViewById(R.id.textView12);
        range = (TextView) findViewById(R.id.textView13);
        cal = (TextView) findViewById(R.id.textView14);

        //TASK 4: REGISTER THE LISTENER EVENT FOR WEIGHT INPUT
        //weightET.addTextChangedListener(weightTextWatcher);

    }

    public void compute(View view) {
        int m=1;
        String h;
        String w;
        String act;
        double y=0;
        double x=0;
        int a=0;
        if("".equals(height.getText().toString().trim()))
            m=0;
        else
        {
            h =height.getText().toString();
            y=Double.parseDouble(h);
        }
        if("".equals(weight.getText().toString().trim()))
            m=0;
        else
        {
            w =weight.getText().toString();
            x=Double.parseDouble(w);
        }
        if("".equals(activity.getText().toString().trim()))
            m=0;
        else
        {
            act =activity.getText().toString();
            a=Integer.parseInt(act);
        }

        Button button = (Button)findViewById(R.id.button);
        String s=button.getText().toString();


        if(a<1||a>3||x>200||x<20||y>250||y<60||m==0)
        {
            new AlertDialog.Builder(this)
                    .setMessage("請完整輸入！")
                    //.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        //@Override
                        //public void onClick(DialogInterface dialogInterface, int i) {
                            //你可以在這裡加入事件
                            //reset(view);
                       // }
                    //})
                    //.setNegativeButton("沒有",null)
                    .setNeutralButton("確定",null)
                    //.setCancelable(false)
                    .show();
        }
        else
        {
            shipItem.comp(x,y,s,a);
            standard.setText(shipItem.getweight().toString()+"公斤");
            range.setText(shipItem.getstandadr1weight()+"~"+ shipItem.getstandadr2weight());
            cal.setText(shipItem.getcal()+"大卡");
        }


    }
    public void sex(View view) {
        Button button = (Button)findViewById(R.id.button);
        String se=button.getText().toString();
        if(se=="男性")
            button.setText("女性");
        else
            button.setText("男性");
    }
    public void reset(View view) {
        height.setText("");
        weight.setText("");
        activity.setText("");
        standard.setText("");
        range.setText("");
        cal.setText("");
    }


    private TextWatcher weightTextWatcher = new TextWatcher() {
        //THE INPUT ELEMENT IS ATTACHED TO AN EDITABLE,
        //THEREFORE THESE METHODS ARE CALLED WHEN THE TEXT IS CHANGED

        public void onTextChanged(CharSequence s,
                                  int start, int before, int count){
            //CATCH AN EXCEPTION WHEN THE INPUT IS NOT A NUMBER
            try {
                shipItem.setWeight((int) Double.parseDouble(s.toString()));
            }catch (NumberFormatException e){
                shipItem.setWeight(0);
            }
            displayShipping();
        }
        public void afterTextChanged(Editable s) {}
        public void beforeTextChanged(CharSequence s,
                                      int start, int count, int after){}
    };

    private void displayShipping() {
        //DISPLAY THE BASE COST, ADDED COST, AND TOTAL COST
        //baseCostTV.setText("$" + String.format("%.02f",
                //shipItem.getBaseCost()));
        //addedCostTV.setText("$" + String.format("%.02f",
                //shipItem.getAddedCost()));
        //totalCostTV.setText("$" + String.format("%.02f",
                //shipItem.getTotalCost()));
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
