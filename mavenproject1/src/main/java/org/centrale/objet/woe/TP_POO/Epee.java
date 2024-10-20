
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
        String s=tokenizer.nextToken();
        setNom(s);
        setIdentifiant(s);
        setVal(Integer.parseInt(tokenizer.nextToken()));
        setDuree(Integer.parseInt(tokenizer.nextToken()));
        if(tokenizer.hasMoreTokens()){
            mot=tokenizer.nextToken();
            if(mot==null) {

            } else {
                setPos(new Point2D(Integer.parseInt(mot),Integer.parseInt(tokenizer.nextToken())));
            }
        
        }
    }
    
    /**
     * méthode pour activer un inventaire (epee) du joueur 
     * @param j: le joueur 
     * @param s: l'identifiant de l'inventaire 
     */
    @Override
    public void activer(Joueur j,String s){
        j.getPerso().setDegAtt(j.getPerso().getDegAtt()+this.getVal());
        j.getEffets().put(s,j.getInventaire().get(s));
        j.getInventaire().remove(s);
    }
    
    /**
     * pour sauvegarder un epee
     * @return 
     */
    @Override
     public String getTexteSauvegarde(){
        String s="Epee "+getNom()+" "+getVal()+" "+getDuree()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
     /**
      * sauvegarde de l'invetaire (epee)
      * @return la ligne de sauvegarde
      */
     @Override
    public String getTexteSauvegardeInve(){
        String s="Inventaire Epee "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    
     /**
      * sauvegarde de l'effet (epee)
      * @return la ligne de sauvegarde
      */
    @Override
    public String getTexteSauvegardeEffe(){
        String s="Effet Epee "+getNom()+" "+getVal()+" "+getDuree();
        return s;
    }
    /**
     * cette méthode a pour objectif de désactiver un effet (epee)
     * @param j: joueur 
     * @param s: l'identifiant de l'inventaire 
     */
    @Override
    public void desactiver(Joueur j,String s){
        j.getPerso().setDegAtt(j.getPerso().getDegAtt()-this.getVal());
        j.getEffets().remove(s);
    }
}
