/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 * Classe Lapin
 * @author Mouad, Kaoutar
 */
public class Lapin extends Monstre {
    
    public Lapin(String identifiant,int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(identifiant,pV, dA, pPar, paAtt, paPar, p);
    }
    
    public Lapin(Lapin l){
        super(l);
    }
    
    public Lapin(){
        super();
    }
    
    public void affiche(){
        System.out.print("le lapin"+getIdentifiant()+" est dans la position : ");
        getPos().affiche();
    }
    
    
}
