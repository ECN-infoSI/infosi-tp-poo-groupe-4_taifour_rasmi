
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
      * constructeur pour le chargement de l'élément 
      * @param ligne
      */
    public Poisson(String ligne){
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
     * cette méthode a pour rôle de sauvegarder le poisson sous format de ligne
     * @return : la ligne
     */
    @Override
     public String getTexteSauvegarde(){
        String s="Poisson "+getNom()+" "+getVal()+" "+getDuree()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
     /**
     * cette méthode a pour rôle de sauvegarder le poisson sous format de ligne (comme étant inventaire du joueur)
     * @return : la ligne
     */
     
    @Override
    public String getTexteSauvegardeInve(){
        String s="Inventaire Poisson "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    
     /**
     * cette méthode a pour rôle de sauvegarder le poisson sous format de ligne (comme étant effet de joueur)
     * @return : la ligne
     */
    @Override
    public String getTexteSauvegardeEffe(){
        String s="Effet Poisson "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    
    
}
