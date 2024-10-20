
package org.centrale.objet.woe.TP_POO;

import java.util.StringTokenizer;

/**
 * Cette classe a pour objectif de définir une nourriture
 * @author Mouad,Kaoutar
 */
public class Poisson extends Nourriture {

    public Poisson() {
        super();
    }
    public Poisson(String nom,int duree,int val,Point2D pos,boolean bonus) {
        super(nom,duree,val,pos,true);
    }
     /**
     * @param ligne
     */
    //constructeur pour le chargement de l'élément 
    public Poisson(String ligne){
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
    @Override
     public String getTexteSauvegarde(){
        String s="Poisson "+getNom()+" "+getVal()+" "+getDuree()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
     @Override
    public String getTexteSauvegardeInve(){
        String s="Inventaire Poisson "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    @Override
    public String getTexteSauvegardeEffe(){
        String s="Effet Poisson "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    
    
}
