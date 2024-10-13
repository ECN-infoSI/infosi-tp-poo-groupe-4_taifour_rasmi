/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 * cette classe a pour but de créer les différents objets nécessaires aux tests de la classe World et des autres classes
 * @author Mouad, Kaoutar
 */

public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String []args){
    
        World monde=new World();
        Joueur kaoutar = new Joueur();
        kaoutar.choisirType();
        kaoutar.getPerso().setPos(new Point2D(0,0));
        monde.creerMondeAlea();
        monde.W[0][0]=kaoutar.getPerso().getNom();
        monde.afficheWorld();
        kaoutar.deplacerJoueur(monde);
        monde.afficheWorld();
        
       
    }
}
