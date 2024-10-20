/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.StringTokenizer;

/**
 *
 * @author HPSALAMA
 */
public class Eau extends Nourriture {

    public Eau() {
        super();
    }
    public Eau(String nom,int duree,int val,Point2D pos,boolean bonus) {
        super(nom,duree,val,pos,true);
    }
     /**
     * @param ligne
     */
    //constructeur pour le chargement de l'élément 
    public Eau(String ligne){
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        setNom(tokenizer.nextToken());
        setVal(Integer.parseInt(tokenizer.nextToken()));
        setDuree(Integer.parseInt(tokenizer.nextToken()));
        setBonus(true);
        if(tokenizer.hasMoreTokens()){  
            mot=tokenizer.nextToken();
            if(mot==null) {

            } else {
                setPos(new Point2D(Integer.parseInt(mot),Integer.parseInt(tokenizer.nextToken())));
            }
        
        }
    }
    
    public String getTexteSauvegarde(){
        String s="Eau "+getNom()+" "+getVal()+" "+getDuree()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
    
    @Override
    public String getTexteSauvegardeInve(){
        String s="Inventaire Eau "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    @Override
    public String getTexteSauvegardeEffe(){
        String s="Effet Eau "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
}
