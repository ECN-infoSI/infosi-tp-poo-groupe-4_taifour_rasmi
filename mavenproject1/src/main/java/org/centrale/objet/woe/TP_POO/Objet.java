/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 * Classe Objet
 * @author Mouad, kaoutar
 */
public abstract class Objet extends ElementDeJeu{
    //Attributs de la classe
    /**
     * pos: la position de l'objet
     */
    private Point2D pos;

    Objet(){
        pos = new Point2D();
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    
}
