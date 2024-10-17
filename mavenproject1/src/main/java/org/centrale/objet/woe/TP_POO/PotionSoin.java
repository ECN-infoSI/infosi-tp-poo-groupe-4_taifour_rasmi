/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.StringTokenizer;

/**
 * Cette classe a pour rôle de définir une postion de soin pour les protagonistes 
 * @author Mouad, Kaoutar
 */
public class PotionSoin extends Objet implements Utilisable{
    //Attribus de la classe 
    /**
     * 
     * val: le nombre de soins
     */
    
    public PotionSoin() {

    }

    

    @Override
    public void activer(Joueur j,String s){
        int ptVie = j.getPerso().getPtVie();
        if(ptVie==100){
            System.out.println("Les points de vie sont à plein.");
        }
        else{
            if(ptVie+getVal() > 100) j.getPerso().setPtVie(100);
            else j.getPerso().setPtVie(ptVie+getVal());
        }
        j.getInventaire().remove(s);
    }
     /**
     * @param ligne
     */
    //constructeur pour le chargement de l'élément 
    public PotionSoin(String ligne){
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        this.ptSoin=Integer.parseInt(tokenizer.nextToken());
        setPos(new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));
    }
}
