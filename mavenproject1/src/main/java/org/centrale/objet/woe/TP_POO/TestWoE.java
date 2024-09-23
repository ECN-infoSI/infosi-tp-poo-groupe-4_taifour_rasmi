/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 *
 * @author user
 */
public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        World monde = new World();
        monde.creerMondeAlea();
        
        monde.robin.setNom("robin");
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
