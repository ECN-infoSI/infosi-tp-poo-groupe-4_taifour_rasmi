
package org.centrale.objet.woe.TP_POO;

import java.util.StringTokenizer;

/**
 * Cette classe a pour rôle de définir une postion de soin pour les protagonistes 
 * @author Mouad, Kaoutar
 */
public class PotionSoin extends Objet implements Utilisable{
    
    public PotionSoin(){
        super();
    }
    
    /**
     * @param nom
     * @param duree
     * @param val
     * @param pos
     */
    public PotionSoin(String nom,int duree,int val,Point2D pos){
       super(nom,duree,val,pos);
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
    
    @Override
    public void desactiver(Joueur j,String s){
        j.getEffets().remove(s);
    }
    
     /**
     * @param ligne
     */
    //constructeur pour le chargement de l'élément 
    public PotionSoin(String ligne){
        //System.out.println(ligne);
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        //System.out.println(mot);
        setNom(tokenizer.nextToken());
        //System.out.println(getNom());
        setVal(Integer.parseInt(tokenizer.nextToken()));
        //System.out.println(getVal());
        setDuree(Integer.parseInt(tokenizer.nextToken()));
        //System.out.println(getVal());
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
        String s="PotionSoin "+getNom()+" "+getVal()+" "+getDuree()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
    @Override
    public String getTexteSauvegardeInve(){
        String s="Inventaire PotionSoin "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    @Override
    public String getTexteSauvegardeEffe(){
        String s="Effet PotionSoin "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }

    
}
