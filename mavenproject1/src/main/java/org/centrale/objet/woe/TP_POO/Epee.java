/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 * Classe Epee
 * @author Mouad, Kaoutar
 */
public class Epee extends Objet{
    
    
    @Override
    public void activer(Joueur j,Integer s){
        j.getPerso().setDegAtt(j.getPerso().getDegAtt()+5);
        j.getEffets().put(s,j.getInventaire().get(s));
        j.getInventaire().remove(s);
    }
    
}
