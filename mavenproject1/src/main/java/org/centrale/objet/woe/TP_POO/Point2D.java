
package org.centrale.objet.woe.TP_POO;

import java.util.Random;

/**
 * Classe Point2D pour définir la position 
 * @author Mouad, Kaoutar
 */
public class Point2D {
    //Attributs 
    /**
     * x: position 
     * y: position
     */
    private int x;
    private int y;
    
    public Point2D(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public Point2D(Point2D p){
        this.x=p.getX();
        this.y=p.getY();
    }
    
    public Point2D(){
        
    }
    
    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     *
     * @param x
     * @param y
     */
    public void setPos(int x,int y){
        this.x=x;
        this.y=y;
    }
    /**
     * changement de la position par translation
     * @param dx
     * @param dy 
     */
    public void translate(int dx, int dy){
        setPos(x+dx,y+dy);
    }

    /**
     * affichage de la position
     */
    public void affiche(){
        System.out.println("("+x+","+y+")");
    }
    /**
     * calcule de la distance par rapport à un autre point 
     * @param p: le ponit avec lequel nous voulons calculer la distance
     * @return la distance
     */
    public double distance(Point2D p){
        double d = Math.sqrt(Math.pow(p.getX()-x,2)+Math.pow(p.getY()-y,2));
        return d;
    }

    /**
     * tester si les deux objets ont la même position
     * @param pos
     * @return 
     */
    public boolean equals(Point2D pos){
        return this.x==pos.getX() && this.y==pos.getY();
    }
    
    @Override
    public String toString(){
        return "("+x+","+y+")" ;
    }
}


