/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Random;

/**
 *
 * @author user
 */
public class Point2D {

    private int x;
    private int y;
    
    Point2D(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    Point2D(Point2D p){
        this.x=p.getX();
        this.y=p.getY();
    }
    
    Point2D(){
        
    }
    
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setPos(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    
    public void translate(int dx, int dy){
        setPos(x+dx,y+dy);
    }
    
    public void affiche(){
        System.out.println("("+x+","+y+")");
    }
    
    public double distance(Point2D p){
        double d = Math.sqrt(Math.pow(p.getX()-x,2)+Math.pow(p.getY()-y,2));
        return d;
    }


    public boolean equals(Point2D pos){
        return this.x==pos.getX() && this.y==pos.getY();
    }
    
    Point2D generePointDiff(Point2D p){
        
        Random ga = new Random();
        Point2D p1 = new Point2D(ga.nextInt(50),ga.nextInt(50));
        while(p.equals(p1)){
            p1 = new Point2D(ga.nextInt(50),ga.nextInt(50));
        }
        return p1;
    }
}


