package com.rentingvis.service.impl;

public class Point{
    double x, y;
    public Point(){
        x = y = 0;
    }
    public Point(double _x, double _y){
        x = _x;
        y = _y;
    }
    public double distToPoint(Point v){
        return Math.sqrt((v.x-x)*(v.x-x) + (v.y-y)*(v.y-y));
    }
    void print(){
        System.out.println("(x, y) = " + x + ' ' + y);
    }
}
