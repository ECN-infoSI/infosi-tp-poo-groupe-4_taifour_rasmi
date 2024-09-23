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
    public static void main(String[] args){
        World monde = new World();
        monde.creerMondeAlea();
        
        System.out.println("Les 3 personnage sont placés aléatoirement :");
        monde.bugs.affiche();
        monde.peon.affiche();
        monde.robin.affiche();
        
        monde.bugs.deplace();
        monde.peon.deplace();
        monde.robin.deplace();
        
        System.out.println("Les 3 personnage après déplacement :");
        monde.bugs.affiche();
        monde.peon.affiche();
        monde.robin.affiche();
    }
    
}
