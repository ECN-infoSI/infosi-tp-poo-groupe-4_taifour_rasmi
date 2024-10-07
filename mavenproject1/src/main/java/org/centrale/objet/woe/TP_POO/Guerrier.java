/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Random;

/**
 *
 * @author user
 */
public class Guerrier extends Personnage{
    
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        super(n,pV,dA,pPar,paAtt,paPar,dMax,p);
    }
    
    public Guerrier(Paysan p){
        super(p);
    }
    
    public Guerrier(){
        super();
    }
    
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
