/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 * Cette classe a pour rôle de définir une postion de soin pour les protagonistes 
 * @author Mouad, Kaoutar
 */
public class PotionSoin extends Objet {
    //Attribus de la classe 
    /**
     * nom: nom de la potion
     * ptSoin: le nombre de soins
     */
    private String nom;
    private int ptSoin;
    
    public PotionSoin() {

    }
    
    public PotionSoin(String nom,int ptSoin) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom=nom;
    }

    public int getPtSoin() {
        return ptSoin;
    }

    public void setPtSoin(int ptSoin) {
        this.ptSoin = ptSoin;
    }
    
}
