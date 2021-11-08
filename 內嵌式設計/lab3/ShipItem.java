package com.cornez.shippingcalculator;

/**
 * Created by trishcornez on 6/29/14.
 */
public class ShipItem {

    //private boolean male;
    private double height;
    private double weight;
    private double standard1;
    private double standard2;
    private double cal;
    //private Double height;


    public void compheight(double knee, int age,String sex){
        double h;
        if(sex=="男性")
        {
            h=85.1+(1.73*knee)-(0.11*age);
        }
        else
        {
            h=91.45+(1.53*knee)-(0.16*age);
        }
        height=h;
        height=Math.round(height*10.0)/10.0;
    }

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



    public Double getheight(){return height;}
    public Double getweight(){return weight;}
    public Double getstandadr1weight(){return standard1;}
    public Double getstandadr2weight(){return standard2;}
    public Double getcal(){return cal;}


}
