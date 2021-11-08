package com.cornez.shippingcalculator;


import android.app.Activity;
import android.app.AlertDialog;
//import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    //DATA MODEL FOR SHIP ITEM
    private ShipItem shipItem;

    //VIEW OBJECTS FOR LAYOUT UI REFERENCE
    private EditText knee;
    private EditText age;
    private EditText height;
    private EditText weight;
    private EditText activity;
    private TextView standard;
    private TextView range;
    private TextView cal;

    boolean gender=true;
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //横竖屏切换前调用，保存用户想要保存的数据，以下是样例
        outState.putBoolean("G",gender);
        outState.putString("",standard.getText().toString());
        outState.putString("",range.getText().toString());
        outState.putString("",cal.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Button button = (Button)findViewById(R.id.button);
        // 屏幕切换完毕后调用用户存储的数据，以下为样例：
        if(savedInstanceState != null) {
            gender = savedInstanceState.getBoolean("G");
            if (gender) {
                button.setText("男性");//按鈕文字切換
            } else {
                button.setText("女性");
            }
            standard.setText("");
            range.setText("");
            cal.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_2);//改過

        //CREATE THE DATA MODEL FOR STORING THE ITEM TO BE SHIPPED
        shipItem = new ShipItem();

        //TASK 3: ESTABLISH THE REFERENCES TO INPUT WEIGHT ELEMENT

        knee = (EditText) findViewById(R.id.editText4);
        age = (EditText) findViewById(R.id.editText5);
        height = (EditText) findViewById(R.id.editText1);
        weight = (EditText) findViewById(R.id.editText2);
        activity = (EditText) findViewById(R.id.editText3);


        //TASK 3: ESTABLISH THE REFERENCES TO OUTPUT ELEMENTS
        standard = (TextView) findViewById(R.id.textView12);
        range = (TextView) findViewById(R.id.textView13);
        cal = (TextView) findViewById(R.id.textView14);
        knee.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Button button = (Button)findViewById(R.id.button2);
                String se=button.getText().toString();
                if(se.equals("自行輸入"))
                {
                    if(!("".equals(knee.getText().toString().trim())))
                    {
                        new AlertDialog.Builder(MyActivity.this)
                                .setMessage("無法輸入！")
                                .setNeutralButton("確定",null)
                                .show();
                        knee.setText("");
                    }
                }
                else
                {
                    if (!("".equals(age.getText().toString().trim())))
                        computheight();

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Button button = (Button)findViewById(R.id.button2);
                String se=button.getText().toString();
                if(se.equals("自行輸入"))
                {
                    if(!("".equals(age.getText().toString().trim())))
                    {
                        new AlertDialog.Builder(MyActivity.this)
                                .setMessage("無法輸入！")
                                .setNeutralButton("確定",null)
                                .show();
                        age.setText("");
                    }
                }
                else {
                    if (!("".equals(knee.getText().toString().trim())))
                        computheight();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Button button = (Button)findViewById(R.id.button2);
                String se=button.getText().toString();
                if(se.equals("自行輸入"))
                {
                    compute();
                }
                else
                {
                    if(h1==0&&!("".equals(height.getText().toString().trim())))
                    {
                        new AlertDialog.Builder(MyActivity.this)
                                .setMessage("無法輸入！")
                                .setNeutralButton("確定",null)
                                .show();
                        height.setText("");
                    }
                    h1=0;

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Button button = (Button)findViewById(R.id.button2);
                String se=button.getText().toString();
                if(se.equals("自行輸入"))
                    compute();
                else
                    computheight();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        activity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Button button = (Button)findViewById(R.id.button2);
                String se=button.getText().toString();
                if(se.equals("自行輸入"))
                        compute();
                else
                        computheight();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //TASK 4: REGISTER THE LISTENER EVENT FOR WEIGHT INPUT
        //weightET.addTextChangedListener(weightTextWatcher);

    }

    public void input(View view){
        Button button = (Button)findViewById(R.id.button2);
        String se=button.getText().toString();

        if(se.equals("自行輸入"))
        {
            button.setText("估算身高");
        }
        else
        {
            button.setText("自行輸入");
        }
    }
    int h1=0;
    public void computheight()
    {
        String k;
        String ag;
        String w;
        String act;
        int z=0;
        double y=0;
        double x=0;
        int a=0;

        if(!("".equals(knee.getText().toString().trim())))
        {
            k =knee.getText().toString();
            y=Double.parseDouble(k);
        }

        if(!("".equals(age.getText().toString().trim())))
        {
            ag =age.getText().toString();
            z=Integer.parseInt(ag);
        }

        if(!("".equals(weight.getText().toString().trim())))
        {
            w =weight.getText().toString();
            x=Double.parseDouble(w);
        }


        if(!("".equals(activity.getText().toString().trim())))
        {
            act =activity.getText().toString();
            a=Integer.parseInt(act);
        }


        Button button = (Button)findViewById(R.id.button);
        String s=button.getText().toString();
        shipItem.compheight(y,z,s);
        String Height=shipItem.getheight().toString();

        h1=1;
        height.setText(Height);
        shipItem.comp(x,shipItem.getheight(),s,a);
        standard.setText(shipItem.getweight().toString()+"公斤");
        range.setText(shipItem.getstandadr1weight()+"~"+ shipItem.getstandadr2weight());
        cal.setText(shipItem.getcal()+"大卡");
    }

    public void compute() {

        //if(!("".equals(height.getText().toString().trim())) &&!("".equals(weight.getText().toString().trim())))
        String h;
        String w;
        String act;
        double y=0;
        double x=0;
        int a=0;
        if(!("".equals(height.getText().toString().trim())))
        {
            h =height.getText().toString();
            y=Double.parseDouble(h);
        }

        if(!("".equals(weight.getText().toString().trim())))
        {
            w =weight.getText().toString();
            x=Double.parseDouble(w);
        }

        if(!("".equals(activity.getText().toString().trim())))
        {
            act =activity.getText().toString();
            a=Integer.parseInt(act);
        }



        Button button = (Button)findViewById(R.id.button);
        String s=button.getText().toString();

        shipItem.comp(x,y,s,a);
        String Weight=shipItem.getweight().toString();
        standard.setText(Weight+"公斤");
        range.setText(shipItem.getstandadr1weight()+"~"+ shipItem.getstandadr2weight());
        cal.setText(shipItem.getcal()+"大卡");

    }
    public void sex(View view) {
        Button button = (Button)findViewById(R.id.button);
        String se=button.getText().toString();
        Button button2 = (Button)findViewById(R.id.button2);
        String sr=button2.getText().toString();
        if(se.equals("男性"))
            button.setText("女性");
        else
            button.setText("男性");
        if(sr.equals("自行輸入"))
            compute();
        else
        {
            compute();
            computheight();
        }
    }
    public void reset(View view) {
        knee.setText("");
        age.setText("");
        weight.setText("");
        activity.setText("");
        standard.setText("");
        range.setText("");
        cal.setText("");
        if(!("".equals(height.getText().toString().trim())))
        {
            height.setText("");
        }
        if(!("".equals(standard.getText().toString().trim())))
        {
            standard.setText("");
        }
        if(!("".equals(range.getText().toString().trim())))
        {
            range.setText("");
        }
        if(!("".equals(cal.getText().toString().trim())))
        {
            cal.setText("");
        }
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
