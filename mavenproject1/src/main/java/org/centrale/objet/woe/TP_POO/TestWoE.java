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
    public static void main(String[] args){
        World monde = new World();
        //monde.creerMondeAlea();
        
        monde.robin.setNom("robin");
        monde.guillaumeT.setNom("guillaumeT");
        
        System.out.println("l'objet guillameT est une copie profonde de robin :");
        //monde.bugs.affiche();
        //monde.peon.affiche();
        monde.robin.affiche();
        monde.guillaumeT.affiche();
        
        //monde.bugs.deplace();
        //monde.peon.deplace();
        monde.robin.deplace();
        
        
        System.out.println("Les 2 personnage après déplacement de robin:");
        //monde.bugs.affiche();
        //monde.peon.affiche();
        monde.robin.affiche();
        monde.guillaumeT.affiche();
    }
    
}
