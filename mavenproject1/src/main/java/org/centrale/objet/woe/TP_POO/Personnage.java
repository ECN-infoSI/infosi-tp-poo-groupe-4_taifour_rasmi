/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Random;
import java.util.StringTokenizer;


/**
 * Classe personnage
 * @author Mouad,Kaoutar
 */

public abstract class Personnage extends Creature{
    //Attributs de la classe
    /**
     * nom du personnage
     * distAttMax : distance d'attack maximale
     */
    private String nom;
    private int distAttMax;
    
    /**
     * @see org.centrale.objet.woe.TP_POO.Point2D
     */
    
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        super(n,pV,dA,pPar,paAtt,paPar,new Point2D(p));
        nom=n;
        distAttMax=dMax;
    }
    
    public Personnage(Personnage perso){
        super(perso.getNom(),perso.getPtVie(),perso.getDegAtt(),perso.getPtPar(),perso.getPageAtt(),perso.getPagePar(),new Point2D(perso.getPos()));
        this.nom=perso.getNom();
        this.distAttMax=perso.getDistAttMax();
    }
    
    public Personnage(){
        
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

   
 
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
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
     * Affiche la position de la Personnage
     */
    @Override
    public void afficher(){
        System.out.print("le personnage "+nom+" se trouve dans la position : ");
        this.getPos().affiche();
    }
    
    
}
