/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 *
 * @author Mouad, Kaoutar
 */
public class Nourriture extends Objet implements Utilisable{
    //Attributs de la classe
    /**
     * nom : on donne un nom à la nourriture
     * bonus : valeur boolean indique si l'effet est un bonus (1) ou un malus (0)
     * carac : indique la caractéristique qui sera affectée par l'effet (sauf les points de vie)
     * val : indique la valeur de l'effet
     */
    private boolean bonus;
    private String carac;
    
    
    //ask the teacher abt potions nd swords.

  
    public Nourriture(boolean bonus, String carac, int val) {
        super();
        this.bonus = bonus;
        this.carac = carac;
        this.setVal(val);
    }

    public Nourriture() {
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public String getCarac() {
        return carac;
    }

    public void setCarac(String carac) {
        this.carac = carac;
    }


    
    
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
    
    
    
}
