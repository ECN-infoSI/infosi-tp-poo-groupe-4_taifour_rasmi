
package org.centrale.objet.woe.TP_POO;


/**
 *
 * @author Mouad, Kaoutar
 */
public class Nourriture extends Objet implements Utilisable{
    //Attributs de la classe
    /**
     * bonus : valeur boolean indique si l'effet est un bonus (1) ou un malus (0)
     */
    private boolean bonus;
    
     public Nourriture(String nom,int duree,int val,Point2D pos,boolean bonus){
       super(nom,duree,val,pos);
       this.bonus=bonus;
    }

    public Nourriture() {
        super();
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }


    /**
     * pour activer la nourriture 
     * @param j: le joueur 
     * @param s: l'identifiant de la nourriture 
     */
    
    @Override
    public void activer(Joueur j,String s){
        if(bonus ==true){
            System.out.println("Vous bénéficiez d'un bonus de dégats d'attack");
            j.getPerso().setDegAtt(j.getPerso().getDegAtt()+10);
        }
        else{
            System.out.println("MALUS ! diminution de dégats d'attack");
            j.getPerso().setDegAtt(j.getPerso().getDegAtt()-10);
        }
        j.getEffets().put(s,j.getInventaire().get(s));
        j.getInventaire().remove(s);
        
    }
    
    /**
     * pour desactiver une nourriture 
     * @param j: le joueur 
     * @param s: l'identifiant de la nourriture 
     */

    @Override
    public void desactiver(Joueur j,String s){
        j.getPerso().setDegAtt(j.getPerso().getDegAtt()-this.getVal());
        j.getEffets().remove(s);
    }
    
    @Override
    public String getTexteSauvegardeInve(){
        return " ";
    }
    
    @Override
    public String getTexteSauvegardeEffe(){
        return " ";
    }
    
}
