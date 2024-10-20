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
public class Miel extends Nourriture {

    public Miel() {
        super();
    }
    public Miel(String nom,int duree,int val,Point2D pos,boolean bonus) {
        super(nom,duree,val,pos,true);
    }
    
    /**
     * @param ligne
     */
    //constructeur pour le chargement de l'élément 
    public Miel(String ligne){
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        String s=tokenizer.nextToken();
        setNom(s);
        setIdentifiant(s);
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
    
    @Override
     public String getTexteSauvegarde(){
        String s="Miel "+getNom()+" "+getVal()+" "+getDuree()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
     @Override
    public String getTexteSauvegardeInve(){
        String s="Inventaire Miel "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    @Override
    public String getTexteSauvegardeEffe(){
        String s="Effet Miel "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    
}
