/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.StringTokenizer;

/**
 *  Classe Miel
 * @author Kaourar,Mouad
 */
public class Miel extends Nourriture {

    public Miel() {
        super();
    }
    public Miel(String nom,int duree,int val,Point2D pos,boolean bonus) {
        super(nom,duree,val,pos,true);
    }
    
    /**
     * constructeur pour le chargement de l'élément
     * @param ligne
     */
     
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
    
    /**
     * pour sauvegarder le miel
     * @return la ligne de sauvegarde
     */
    @Override
     public String getTexteSauvegarde(){
        String s="Miel "+getNom()+" "+getVal()+" "+getDuree()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
    /**
     * pour sauvegarder le miel en tant qu'inventaire de joueur 
     * @return la ligne de sauvegarde
     */
     @Override
    public String getTexteSauvegardeInve(){
        String s="Inventaire Miel "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    
    /**
     * pour sauvegarder le miel en tant qu'effet de joueur 
     * @return la ligne de sauvegarde
     */
    @Override
    public String getTexteSauvegardeEffe(){
        String s="Effet Miel "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    
}
