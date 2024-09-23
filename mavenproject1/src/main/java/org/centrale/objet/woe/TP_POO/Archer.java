/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Random;

/**
 *  Classe Archer
 *  @author Mouad, Kaoutar
 */
public class Archer extends Personnage {
    //Attributs 
    /**
     * nbFleches: nombre de flèches possédées par l'arher
     */
    private int nbFleches;
    
    Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches){
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        this.nbFleches=nbFleches;
    }
    
    Archer(Archer a){
        super(a); //super((Personnage)a)
        this.nbFleches=a.getNbFleches();
    }
    
    Archer(){
        super();
    }

    /**
     *
     * @return
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     *
     * @param nbFleches
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
   
    public void combattre(Creature crea){
        if(getPos().distance(crea.getPos())>1 && getPos().distance(crea.getPos())<getDistAttMax()){ 
            Random ga = new Random();
            int rand = (int)(ga.nextInt(100)+1);
            if(rand>getPageAtt()){
                System.out.println("l'attaque est ratée.");
            }
            else{
                System.out.println("attaque réussite");
                crea.setPtVie(crea.getPtVie()-getDegAtt());
                
                
            }
        }
    }
    
}
