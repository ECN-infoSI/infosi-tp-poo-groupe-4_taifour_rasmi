/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Random;
import java.util.StringTokenizer;

/**
 *  Classe Archer
 *  @author Mouad, Kaoutar
 */
public class Archer extends Personnage implements Combattant{
    //Attributs 
    /**
     * nbFleches: nombre de flèches possédées par l'arher
     */
    private int nbFleches;
    
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches){
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        this.nbFleches=nbFleches;
    }
    
    public Archer(Archer a){
        super(a); //super((Personnage)a)
        this.nbFleches=a.getNbFleches();
    }
    
    public Archer(){
        super();
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    /**
     * méthode combattre de la creature de type Archer
     * @param crea 
    */
    @Override
    public void combattre(Creature crea){
        if(getPos().distance(crea.getPos())>1 && getPos().distance(crea.getPos())<getDistAttMax()){ 
            nbFleches -= 1;
            Random ga = new Random();
            int rand = (int)(ga.nextInt(100)+1);
            if(rand>getPageAtt()){
                System.out.println("l'attaque est ratée.");
            }
            else{
                System.out.println("attaque réussite");
                crea.setPtVie(crea.getPtVie()-getDegAtt());
            }
        }
    } 
    /**
     * 
     * @param ligne 
     */
    public Archer(String ligne){
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        setIdentifiant(tokenizer.nextToken());
        setPtVie(Integer.parseInt(tokenizer.nextToken()));
        setDegAtt(Integer.parseInt(tokenizer.nextToken()));
        setPtPar(Integer.parseInt(tokenizer.nextToken()));
        setPageAtt(Integer.parseInt(tokenizer.nextToken()));
        setPagePar(Integer.parseInt(tokenizer.nextToken()));
        setDistAttMax(Integer.parseInt(tokenizer.nextToken()));
        setPos(new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));
        this.nbFleches=Integer.parseInt(tokenizer.nextToken());
    }
}
