/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.StringTokenizer;

/**
 *Cette classe définit un nuage toxique
 * 
 * @author Mouad, Kaoutar
 * 
 */
public class NuageToxique extends Objet implements Combattant{
    
    private int paAtt;
    private int degAtt;

    public int getPaAtt() {
        return paAtt;
    }

    public void setPaAtt(int paAtt) {
        this.paAtt = paAtt;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
    
    @Override
    public void combattre(Creature c){
        
    }
    
     /**
     * @param ligne
     */
    //constructeur pour le chargement de l'élément 
    public NuageToxique(String ligne){
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        this.paAtt=Integer.parseInt(tokenizer.nextToken());
        this.degAtt=Integer.parseInt(tokenizer.nextToken());
        setPos(new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));
        
        
    }
    
}
