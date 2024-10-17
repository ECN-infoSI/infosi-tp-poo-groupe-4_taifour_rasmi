/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.ArrayList;

/**
 *Cette classe définit un nuage toxique
 * 
 * @author Mouad, Kaoutar
 * 
 */
public class NuageToxique extends Objet implements Combattant{
    
    ArrayList<Point2D> zone;

    public NuageToxique(ArrayList<Point2D> zone) {
        this.zone = zone;
    }
    
    
    
    
    @Override
    public void combattre(Creature c){
        
    }
    
    public ArrayList<String> CombatsPotentiels(World monde){
        ArrayList<String> l = new ArrayList<>();
        String s;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                if(i==0 && j==0){
                    
                }
                else{
                    s=monde.getW()[this.getPos().getX()+i][this.getPos().getY()+j];
                    if (!(".".equals(s))){
                        l.add(s);
                    }
                }
            }
        }
        return l;
    }
}
