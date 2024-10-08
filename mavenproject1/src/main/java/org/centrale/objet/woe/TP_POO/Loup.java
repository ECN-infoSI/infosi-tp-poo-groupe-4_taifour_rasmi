/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Random;

/**
 *
 * @author Mouad, Kaoutar
 */
public class Loup extends Monstre implements Combattant{
    
    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
    }
    
    public Loup(Lapin l){
        super(l);
    }
    
    public Loup(){
        super();
    }
    

    public void affiche(){
        System.out.print("le loup est dans la position : ");
        getPos().affiche();
    }
    /**
     * méthode combattre de la creature de type Loup
     * @param crea 
     */
    @Override
    public void combattre(Creature crea){
        if(getPos().distance(crea.getPos())==1){ 
            Random ga = new Random();
            int rand = (int)(ga.nextInt(100)+1);
            if(rand>getPageAtt()){
                System.out.println("l'attaque est ratée.");
            }
            else{
                System.out.println("attaque réussite");
                rand = (int)(ga.nextInt(100)+1);
                if(rand>crea.getPagePar()){
                    crea.setPtVie(crea.getPtVie()-getDegAtt());
                }
                else{
                    crea.setPtVie(crea.getPtVie()-getDegAtt()+crea.getPtPar());
                }
            }
        }  
    }
    
}
