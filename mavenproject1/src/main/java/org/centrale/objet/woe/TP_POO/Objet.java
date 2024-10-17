/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 * Classe Objet
 * @author Mouad, kaoutar
 */
public abstract class Objet extends ElementDeJeu {
    //Attributs de la classe
    /**
     * nom : nom de l'objet
     * pos: la position de l'objet
     * duree : la duree d'activation de l'objet
     */
    private Point2D pos;
    private String nom;
    private int duree;
    private int val;
    

    public Objet(){
        pos = new Point2D();
    }
    
    public Objet(String nom,int duree,int val,Point2D pos){
        this.nom=nom;
        this.duree=duree;
        this.val=val;
        this.pos=new Point2D(pos);
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVal() {
        return val;
    }
    
    public void setVal(int val) {
        this.val = val;
    }
    
    
}
