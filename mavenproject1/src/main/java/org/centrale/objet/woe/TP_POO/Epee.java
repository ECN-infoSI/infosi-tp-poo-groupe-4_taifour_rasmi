/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.StringTokenizer;

/**
 * Classe Epee
 * @author Mouad, Kaoutar
 */
public class Epee extends Objet implements Utilisable{
    
    public Epee(){
    super();
    }
     public Epee(String nom,int duree,int val,Point2D pos){
       super(nom,duree,val,pos);
    }

     /**
     * @param ligne
     */
    //constructeur pour le chargement de l'élément 
    public Epee(String ligne){
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        setVal(Integer.parseInt(tokenizer.nextToken()));
        setPos(new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));
    }
    
    @Override
    public void activer(Joueur j,String s){
        j.getPerso().setDegAtt(j.getPerso().getDegAtt()+this.getVal());
        j.getEffets().put(s,j.getInventaire().get(s));
        j.getInventaire().remove(s);
    }
    
}
