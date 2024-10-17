/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 * Classe Epee
 * @author Mouad, Kaoutar
 */
public class Epee extends Objet implements Utilisable{
     
    
    
    @Override
    public void activer(Joueur j,String s){
        j.getPerso().setDegAtt(j.getPerso().getDegAtt()+this.getVal());
        j.getEffets().put(s,j.getInventaire().get(s));
        j.getInventaire().remove(s);
    }

    
    
    
    
}
