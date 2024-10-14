/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import static java.lang.Math.sqrt;
import java.util.Random;
import java.util.StringTokenizer;

/**
 *
 * @author Mouad, Kaoutar
 */
public class Loup extends Monstre implements Combattant{
    

    public Loup(String identifiant,int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(identifiant,pV, dA, pPar, paAtt, paPar, p);

    }
    
    public Loup(Loup l){
        super(l);
    }
        
    
    
    public Loup(){
        super();
    }
    /**
     * @param ligne
     */
    //constructeur pour le chargement de l'élément 
    public Loup(String ligne){
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        super(tokenizer.nextToken(),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));
    }
    

    public void affiche(){
        System.out.print("le loup est dans la position : ");
        getPos().affiche();
    }
    /**
     * méthode combattre de la creature de type Loup
     * @param crea 
     */
    @Override
    public void combattre(Creature crea){
        if(getPos().distance(crea.getPos())==1 || getPos().distance(crea.getPos())==sqrt(2)){ 
            Random ga = new Random();
            int rand = (int)(ga.nextInt(100)+1);
            if(rand>getPageAtt()){
                System.out.println("l'attaque est ratée.");
            }
            else{
                System.out.println("attaque réussite");
                rand = (int)(ga.nextInt(100)+1);
                if(rand>crea.getPagePar()){
                    crea.setPtVie(crea.getPtVie()-getDegAtt());
                }
                else{
                    crea.setPtVie(crea.getPtVie()-getDegAtt()+crea.getPtPar());
                }
            }
        }  
    }
    
}
