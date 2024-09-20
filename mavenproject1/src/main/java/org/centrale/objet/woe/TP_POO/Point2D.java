/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

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
    
    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public void translate(int dx, int dy){
        setPosition(x+dx,y+dy);
    }
    
    public void affiche(){
        System.out.println("("+x+","+y+")");
    }
    
    public double distance(Point2D p){
        double d = Math.sqrt(Math.pow(p.getX()-x,2)+Math.pow(p.getY()-y,2));
        return d;
    }
}


