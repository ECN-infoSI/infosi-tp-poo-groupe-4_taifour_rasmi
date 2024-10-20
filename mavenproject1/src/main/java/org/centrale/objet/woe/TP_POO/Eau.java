
package org.centrale.objet.woe.TP_POO;

import java.util.StringTokenizer;

/**
 * Cette classe a pour objectif de définir une nourriture: Eau
 * @author Mouad, Kaoutar
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
    
    /**
     * Pour enregister l'eau
     * @return 
     */
    @Override
    public String getTexteSauvegarde(){
        String s="Eau "+getNom()+" "+getVal()+" "+getDuree()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
    
    /**
     * Pour enregister l'eau comme étant un inventaire
     * @return 
     */
    @Override
    public String getTexteSauvegardeInve(){
        String s="Inventaire Eau "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    
    /**
     * Pour enregister l'eau étant un effet
     * @return 
     */
    @Override
    public String getTexteSauvegardeEffe(){
        String s="Effet Eau "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
}
