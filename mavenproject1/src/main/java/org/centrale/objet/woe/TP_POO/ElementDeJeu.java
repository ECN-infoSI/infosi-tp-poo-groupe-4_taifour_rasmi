/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

/**
 *
 * @author user
 */
public abstract class ElementDeJeu {
    private String identifiant;
    
    public ElementDeJeu(String identifiant){
        this.identifiant=identifiant;
    }
    
    public ElementDeJeu(){
       
    }
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    
    
}
