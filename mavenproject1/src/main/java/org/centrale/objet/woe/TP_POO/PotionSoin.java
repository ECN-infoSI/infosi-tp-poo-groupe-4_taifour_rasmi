/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 * Cette classe a pour rôle de définir une postion de soin pour les protagonistes 
 * @author Mouad, Kaoutar
 */
public class PotionSoin extends Objet{
    //Attribus de la classe 
    /**
     * 
     * ptSoin: le nombre de soins
     */
    private int ptSoin;
    
    public PotionSoin() {

    }

    public int getPtSoin() {
        return ptSoin;
    }

    public void setPtSoin(int ptSoin) {
        this.ptSoin = ptSoin;
    }
    
    @Override
    public void activer(Joueur j,Integer s){
        int ptVie = j.getPerso().getPtVie();
        if(ptVie==100){
            System.out.println("Les points de vie sont à plein.");
        }
        else{
            if(ptVie+ptSoin > 100) j.getPerso().setPtVie(100);
            else j.getPerso().setPtVie(ptVie+ptSoin);
        }
        j.getInventaire().remove(s);
    }
}
