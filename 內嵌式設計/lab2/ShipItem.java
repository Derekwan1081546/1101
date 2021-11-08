package com.cornez.shippingcalculator;

/**
 * Created by trishcornez on 6/29/14.
 */
public class ShipItem {

    // SHIPPING CONSTANTS
    static final Double BASE = 3.00;
    static final Double ADDED = .50;
    static final int BASE_WEIGHT = 16;
    static final double EXTRA_OUNCES = 4.0;

    // DATA MEMBERS
    private Integer mWeight;
    private Double mBaseCost;
    private Double mAddedCost;
    private Double mTotalCost;

    //private boolean male;
    private double weight;
    private double standard1;
    private double standard2;
    private double cal;
    //private Double height;

    public void comp(double w, double height,String sex,int a){
        //double roundDbl = Math.round(hi*10.0)/10.0;
        if(sex=="男性")
        {
            weight=(height-80)*0.7;
        }
        else
        {
            weight=(height-70)*0.6;
        }

        standard1=weight*0.9;
        standard2=weight*1.1;

        if(a==1)
        {
            if(w<standard1)
            {
                cal=35*weight;
            }
            else if(w>standard2)
            {
                cal=25*weight;
            }
            else
            {
                cal=30*weight;
            }
        }
        else if(a==2)
        {
            if(w<standard1)
            {
                cal=40*weight;
            }
            else if(w>standard2)
            {
                cal=30*weight;
            }
            else
            {
                cal=35*weight;
            }
        }
        else if(a==3)
        {
            if(w<standard1)
            {
                cal=45*weight;
            }
            else if(w>standard2)
            {
                cal=35*weight;
            }
            else
            {
                cal=40*weight;
            }
        }
        weight=Math.round(weight*10.0)/10.0;
        standard1=Math.round(standard1*10.0)/10.0;
        standard2=Math.round(standard2*10.0)/10.0;
        cal=Math.round(cal*10.0)/10.0;
    }

    public ShipItem() {
        mWeight = 0;
        mAddedCost = 0.0;
        mBaseCost = BASE;
        mTotalCost = 0.0;
    }

    public void setWeight (int w){
        mWeight = w;
        computeCosts();
    }

    private void computeCosts() {
        mAddedCost = 0.0;
        mBaseCost = BASE;

        if (mWeight <= 0)
            mBaseCost = 0.0;
        else if (mWeight > BASE_WEIGHT)
            mAddedCost = Math.ceil((double) (mWeight - BASE_WEIGHT) / EXTRA_OUNCES) * ADDED;

        mTotalCost = mBaseCost + mAddedCost;
    }

    public Double getweight(){return weight;}
    public Double getstandadr1weight(){return standard1;}
    public Double getstandadr2weight(){return standard2;}
    public Double getcal(){return cal;}
    public Double getBaseCost() {
        return mBaseCost;
    }

    public Double getAddedCost() {
        return mAddedCost;
    }

    public Double getTotalCost() {
        return mTotalCost;
    }

}
