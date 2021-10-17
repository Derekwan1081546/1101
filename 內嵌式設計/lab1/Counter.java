package com.cornez.tapbuttoncounter;

import android.view.View;

class Counter {
    private int mCount;
    private double c1=-8.78469475556,c2 = 1.61139411
    ,c3 = 2.33854883889,c4 = -0.14611605,c5 = -0.012308094
    ,c6 = -0.0164248277778,c7 = 0.002211732
    ,c8 = 0.00072546,c9 = -0.000003582;
    private double hi;

    public Counter(){
        mCount = 0;
    }
    public void CountVal(int num) { mCount=num;}
    public void addCount(){
        mCount++;
    }
    public void minusCount() { mCount--; }

    public void comp(int t,int r) {
        hi= c1 + c2*t + c3*r + c4*t*r + c5*t*t + c6*r*r + c7*t*t*r + c8*t*r*r + c9*t*t*r*r;
    }
    public Integer getCount() {
        return mCount;
    }

}
