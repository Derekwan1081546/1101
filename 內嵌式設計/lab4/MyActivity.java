package com.cornez.activitylifecycle;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MyActivity extends Activity {

    boolean finished = false;
    boolean continuing = false;

    private Handler handler = new Handler( );
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this,500);
            if(!finished)
                Next();
            else
                continuing = false;
        }
    };
    private TextView[][] block=new TextView[8][8];
    private TextView textView2;
    private boolean [][] passed=new boolean[8][8];
    int r = (int)(Math.random()*64);
    int m=r/8;
    int n=r%8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        textView2=(TextView) findViewById(R.id.textView2);
        block[0][0] = (TextView) findViewById(R.id.textView00);
        block[0][1] = (TextView) findViewById(R.id.textView01);
        block[0][2] = (TextView) findViewById(R.id.textView02);
        block[0][3] = (TextView) findViewById(R.id.textView03);
        block[0][4] = (TextView) findViewById(R.id.textView04);
        block[0][5] = (TextView) findViewById(R.id.textView05);
        block[0][6] = (TextView) findViewById(R.id.textView06);
        block[0][7] = (TextView) findViewById(R.id.textView07);

        block[1][0] = (TextView) findViewById(R.id.textView10);
        block[1][1] = (TextView) findViewById(R.id.textView11);
        block[1][2] = (TextView) findViewById(R.id.textView12);
        block[1][3] = (TextView) findViewById(R.id.textView13);
        block[1][4] = (TextView) findViewById(R.id.textView14);
        block[1][5] = (TextView) findViewById(R.id.textView15);
        block[1][6] = (TextView) findViewById(R.id.textView16);
        block[1][7] = (TextView) findViewById(R.id.textView17);

        block[2][0] = (TextView) findViewById(R.id.textView20);
        block[2][1] = (TextView) findViewById(R.id.textView21);
        block[2][2] = (TextView) findViewById(R.id.textView22);
        block[2][3] = (TextView) findViewById(R.id.textView23);
        block[2][4] = (TextView) findViewById(R.id.textView24);
        block[2][5] = (TextView) findViewById(R.id.textView25);
        block[2][6] = (TextView) findViewById(R.id.textView26);
        block[2][7] = (TextView) findViewById(R.id.textView27);

        block[3][0] = (TextView) findViewById(R.id.textView30);
        block[3][1] = (TextView) findViewById(R.id.textView31);
        block[3][2] = (TextView) findViewById(R.id.textView32);
        block[3][3] = (TextView) findViewById(R.id.textView33);
        block[3][4] = (TextView) findViewById(R.id.textView34);
        block[3][5] = (TextView) findViewById(R.id.textView35);
        block[3][6] = (TextView) findViewById(R.id.textView36);
        block[3][7] = (TextView) findViewById(R.id.textView37);

        block[4][0] = (TextView) findViewById(R.id.textView40);
        block[4][1] = (TextView) findViewById(R.id.textView41);
        block[4][2] = (TextView) findViewById(R.id.textView42);
        block[4][3] = (TextView) findViewById(R.id.textView43);
        block[4][4] = (TextView) findViewById(R.id.textView44);
        block[4][5] = (TextView) findViewById(R.id.textView45);
        block[4][6] = (TextView) findViewById(R.id.textView46);
        block[4][7] = (TextView) findViewById(R.id.textView47);

        block[5][0] = (TextView) findViewById(R.id.textView50);
        block[5][1] = (TextView) findViewById(R.id.textView51);
        block[5][2] = (TextView) findViewById(R.id.textView52);
        block[5][3] = (TextView) findViewById(R.id.textView53);
        block[5][4] = (TextView) findViewById(R.id.textView54);
        block[5][5] = (TextView) findViewById(R.id.textView55);
        block[5][6] = (TextView) findViewById(R.id.textView56);
        block[5][7] = (TextView) findViewById(R.id.textView57);

        block[6][0] = (TextView) findViewById(R.id.textView60);
        block[6][1] = (TextView) findViewById(R.id.textView61);
        block[6][2] = (TextView) findViewById(R.id.textView62);
        block[6][3] = (TextView) findViewById(R.id.textView63);
        block[6][4] = (TextView) findViewById(R.id.textView64);
        block[6][5] = (TextView) findViewById(R.id.textView65);
        block[6][6] = (TextView) findViewById(R.id.textView66);
        block[6][7] = (TextView) findViewById(R.id.textView67);

        block[7][0] = (TextView) findViewById(R.id.textView70);
        block[7][1] = (TextView) findViewById(R.id.textView71);
        block[7][2] = (TextView) findViewById(R.id.textView72);
        block[7][3] = (TextView) findViewById(R.id.textView73);
        block[7][4] = (TextView) findViewById(R.id.textView74);
        block[7][5] = (TextView) findViewById(R.id.textView75);
        block[7][6] = (TextView) findViewById(R.id.textView76);
        block[7][7] = (TextView) findViewById(R.id.textView77);

        block[m][n].setText("@");
        textView2.setText((m+1)+","+(n+1));
        passed[m][n]=true;

    }

    public void continuous(View view){
        if(finished)
        {
            new AlertDialog.Builder(MyActivity.this)
                    .setMessage("Oops！")
                    .setNeutralButton("確定",null)
                    .show();
        }
        runnable.run();
        continuing = true;
    }

    public void restart(View view) {
        if(!continuing)
        {
            handler.removeCallbacks(runnable);
            finished=false;
            block[m][n].setText("");
            for(int i=0;i<8;i++)
            {
                for(int j=0;j<8;j++)
                {
                    passed[i][j] = false;
                    if( i==0 || i==2 || i==4 || i==6 )
                    {
                        block[i][j].setBackgroundColor(Color.parseColor("#8BC34A"));
                        if( j==1 || j==3 || j==5 || j==7 )
                            block[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                    }
                    else
                    {
                        block[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                        if( j==1 || j==3 || j==5 || j==7 )
                            block[i][j].setBackgroundColor(Color.parseColor("#8BC34A"));
                    }
                }
            }
            r = (int)(Math.random()*64);
            m=r/8;
            n=r%8;
            block[m][n].setText("@");
            passed[m][n] = true;
            textView2.setText((m+1)+","+(n+1));
        }
    }

    public void Next()
    {
        int a =(int)(Math.random()*8)+1;
        boolean [] direction=new boolean[8];
        int i=0;
        while (true)
        {
            if( a==1 )
            {
                if((m+1)<8 && (n+2)<8)
                {
                    if(!passed[m+1][n+2])
                    {
                        block[m][n].setBackgroundColor(Color.parseColor("#E91E1E"));
                        block[m][n].setText("");
                        m=m+1;
                        n=n+2;
                        break;
                    }
                }
                direction[0] = true;
            }
            else if( a==2 )
            {
                if((m+2)<8 && (n+1)<8)
                {
                    if(!passed[m+2][n+1]) {
                        block[m][n].setBackgroundColor(Color.parseColor("#E91E1E"));
                        block[m][n].setText("");
                        m = m + 2;
                        n = n + 1;
                        break;
                    }
                }
                direction[1] = true;
            }
            else if( a==3  )
            {
                if((m-1)>-1 && (n+2)<8)
                {
                    if(!passed[m-1][n+2])
                    {
                        block[m][n].setBackgroundColor(Color.parseColor("#E91E1E"));
                        block[m][n].setText("");
                        m=m-1;
                        n=n+2;
                        break;
                    }
                }
                direction[2] = true;
            }
            else if( a==4  )
            {
                if((m-2)>-1 && (n+1)<8)
                {
                    if(!passed[m-2][n+1])
                    {
                        block[m][n].setBackgroundColor(Color.parseColor("#E91E1E"));
                        block[m][n].setText("");
                        m=m-2;
                        n=n+1;
                        break;
                    }
                }
                direction[3] = true;
            }
            else if( a==5 )
            {
                if((m+1)<8 && (n-2)>-1)
                {
                    if(!passed[m+1][n-2])
                    {
                        block[m][n].setBackgroundColor(Color.parseColor("#E91E1E"));
                        block[m][n].setText("");
                        m=m+1;
                        n=n-2;
                        break;
                    }
                }
                direction[4] = true;
            }
            else if( a==6 )
            {
                if((m+2)<8 && (n-1)>-1)
                {
                    if(!passed[m+2][n-1])
                    {
                        block[m][n].setBackgroundColor(Color.parseColor("#E91E1E"));
                        block[m][n].setText("");
                        m=m+2;
                        n=n-1;
                        break;
                    }
                }
                direction[5] = true;
            }
            else if( a==7 )
            {
                if((m-1)>-1 && (n-2)>-1)
                {
                    if(!passed[m-1][n-2])
                    {
                        block[m][n].setBackgroundColor(Color.parseColor("#E91E1E"));
                        block[m][n].setText("");
                        m=m-1;
                        n=n-2;
                        break;
                    }
                }
                direction[6] = true;
            }
            else if( a==8 )
            {
                if((m-2)>-1 && (n-1)>-1)
                {
                    if(!passed[m-2][n-1])
                    {
                        block[m][n].setBackgroundColor(Color.parseColor("#E91E1E"));
                        block[m][n].setText("");
                        m=m-2;
                        n=n-1;
                        break;
                    }
                }
                direction[7] = true;
            }
            a =(int)(Math.random()*8)+1;

            for(i=0;i<8;i++)
            {
                if(!direction[i])
                    break;
            }
            if(i==8)
            {
                break;
            }
        }
        if(i==8)
        {
            new AlertDialog.Builder(MyActivity.this)
                    .setMessage("Oops！")
                    .setNeutralButton("確定",null)
                    .show();
            finished=true;
        }
        else
        {
            passed[m][n]=true;
            block[m][n].setText("@");
            textView2.setText((m+1)+","+(n+1));
        }
        int b=0;
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)
            {
                if(!passed[x][y])
                    break;
                else
                    b++;
            }
        }
        if(b==64)
        {
            new AlertDialog.Builder(MyActivity.this)
                    .setMessage("Great！")
                    .setNeutralButton("確定",null)
                    .show();
            finished=true;
        }
    }
    public void nextstep(View view){
        if(!continuing)
        {
            Next();
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
