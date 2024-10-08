/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;


/**
 * Classe Monstre
 * @author Mouad, Kaoutar
 * 
 */
public class Monstre extends Creature{
    
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
    }
    public Monstre(Monstre m){
        super(m.getPtVie(),m.getDegAtt(),m.getPtPar(),m.getPageAtt(),m.getPagePar(),new Point2D(m.getPos()));
    }
    
    public Monstre(){
        super();
    }

    /**
     * Affiche la position de la creature
     */
    public void affiche(){
        System.out.print("le monstre se trouve dans la position : ");
        this.getPos().affiche();
    }

 
    
}
