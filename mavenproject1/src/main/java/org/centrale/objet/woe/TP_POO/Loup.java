/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 *
 * @author user
 */
public class Loup extends Monstre{
    
    
    public void affiche(){
        System.out.print("le loup est dans la position : ");
        getPos().affiche();
    }
    
}
