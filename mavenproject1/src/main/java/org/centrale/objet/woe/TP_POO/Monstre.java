/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Random;
import java.util.StringTokenizer;


/**
 * Classe Monstre
 * @author Mouad, Kaoutar
 * 
 */
public abstract class Monstre extends Creature{
    public Monstre(String identifiant,int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(identifiant,pV, dA, pPar, paAtt, paPar, p);
    }
    public Monstre(Monstre m){
        super(m.getIdentifiant(),m.getPtVie(),m.getDegAtt(),m.getPtPar(),m.getPageAtt(),m.getPagePar(),new Point2D(m.getPos()));
    }
    
    public Monstre(){
        super();
    }

    
     /**
     * deplace le personnage
     */
    @Override
    public void deplacer(){
        Random ga = new Random();
        this.getPos().translate(ga.nextInt(2)-1, ga.nextInt(2)-1);
    }
    
    /**
     * Affiche la position du monstre
     */
    @Override
    public void afficher(){
        System.out.print("le monstre se trouve dans la position : ");
        this.getPos().affiche();
    }
    

   
}
