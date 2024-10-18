/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * cette classe a pour but de créer les différents objets nécessaires aux tests de la classe World et des autres classes
 * @author Mouad, Kaoutar
 */

public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String []args) throws IOException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    
        World monde=new World();
        /*monde.chargementPartie("source.txt");
        monde.updateWorld();
        monde.afficheWorld();*/

        Joueur kaoutar = new Joueur();
        kaoutar.choisirType();
        kaoutar.getPerso().setPos(new Point2D(0,0));
        
        monde.getW()[0][0] = kaoutar.getPerso().getNom();
        monde.getListeC().put(kaoutar.getPerso().getNom(), kaoutar.getPerso());
        Epee p = new Epee();
        p.setNom("epee");
        p.setDuree(10);
        p.setVal(5);
        kaoutar.getPerso().setPtVie(100);
        p.setPos(new Point2D(1,1));
        monde.getW()[1][1] = p.getNom();
        monde.getListeO().put(p.getNom(), p);
        kaoutar.getPerso().setDegAtt(5);
        monde.tourDeJeu(kaoutar);
        //monde.chargementPartie("source.txt");
        //monde.updateWorld();
        //monde.afficheWorld();
        /*Joueur kaoutar = new Joueur();
        kaoutar.choisirType();*/
        /*kaoutar.getPerso().setPos(new Point2D(0,0));
        monde.creerMondeAlea();
        monde.W[0][0]=kaoutar.getPerso().getNom();
        monde.afficheWorld();
        kaoutar.deplacerJoueur(monde);
        monde.afficheWorld();
        //monde.tourDeJeu(kaoutar);
        
       */
    }
}
