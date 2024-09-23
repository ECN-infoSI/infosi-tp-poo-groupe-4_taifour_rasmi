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
    public static void main(String[] args){
        World monde = new World();
        
        monde.wolfie.setPos(new Point2D(4,5));
        monde.wolfie.setDegAtt(20);
        monde.wolfie.setPtVie(100);
        monde.wolfie.setPagePar(10);
        monde.wolfie.setPtPar(30);
        monde.wolfie.affiche();
        
        monde.grosBill.setPos(new Point2D(4,6));
        monde.grosBill.setDegAtt(20);
        monde.grosBill.setPageAtt(80);
        monde.grosBill.affiche();
        
        monde.robin.setPos(new Point2D(4,7));
        monde.robin.setDegAtt(10);
        monde.robin.setPageAtt(60);
        monde.robin.setDistAttMax(3);
        monde.robin.affiche();
        
        System.out.println("Le guerrier et l'archer vont attaquer le loup.");
        monde.grosBill.combattre(monde.wolfie);
        monde.robin.combattre(monde.wolfie);
        
        System.out.println("Le loup après le combat :");
        System.out.println("Points de vie : "+monde.wolfie.getPtVie());
        System.out.println("pourcentage de parade : "+monde.wolfie.getPtPar());
        
        
        //monde.creerMondeAlea();
        
        /*monde.robin.setNom("robin");
        monde.peon.setNom("peon");
        monde.guillaumeT.setNom("guillaumeT");
        monde.grosBill.setNom("groBill");
        
        System.out.println("les position des créatures :");
        monde.grosBill.affiche();
        monde.peon.affiche();
        monde.robin.affiche();
        monde.guillaumeT.affiche();
        monde.wolfie.affiche();
        monde.bugs1.affiche();
        monde.bugs2.affiche();
        */
        
        
        
        monde.afficheWord();
        
        /*monde.bugs.deplace();
        monde.peon.deplace();
        monde.robin.deplace();
        
        
        System.out.println("Les 2 personnage après déplacement de robin:");
        monde.bugs1.affiche();
        monde.peon.affiche();
        monde.robin.affiche();
        monde.guillaumeT.affiche();
        */
    }
    
}
