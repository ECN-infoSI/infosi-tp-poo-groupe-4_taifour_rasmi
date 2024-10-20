/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Cette class définit un type de personnage qui est Guerrier
 * @author Mouad, Kaoutar
 */
public class Guerrier extends Personnage implements Combattant{
    
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        super(n,pV,dA,pPar,paAtt,paPar,dMax,p);
    }
    
    public Guerrier(Guerrier p){
        super(p);
    }
    
    public Guerrier(){
        super();
    }
    
     
    /**
     * @param ligne
     */
    //constructeur pour le chargement de l'élément 
    public Guerrier(String ligne){
        //StringTokenizer tokenizer = new StringTokenizer(ligne);
        //String mot = tokenizer.nextToken();
        //super(tokenizer.nextToken(),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));
        super(ligne);
    }
    
    /**
     * cette méthode a pour but de permettre le combat entre deux creature
     * @param creature 
     */
    @Override
    public void combattre(Creature creature){
        if(getPos().distance(creature.getPos())==1 || getPos().distance(creature.getPos())==sqrt(2)){ 
            Random ga = new Random();
            int rand = (int)(ga.nextInt(100)+1);
            if(rand>getPageAtt()){
                System.out.println("l'attaque de "+getNom()+" est ratée ");
            }
            else{
                System.out.println("l'attaque de "+getNom()+" est réussie ");
                rand = (int)(ga.nextInt(100)+1);
                if(rand>creature.getPagePar()){
                    creature.setPtVie(creature.getPtVie()-getDegAtt());
                }
                else{
                    creature.setPtVie(creature.getPtVie()-getDegAtt()+creature.getPtPar());
                }
            }
        }  
    }
    
    
    @Override
    public ArrayList<String> CombatsPotentiels(World monde){
        ArrayList<String> l = new ArrayList<>();
        String s;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                int x=this.getPos().getX()+i;
                int y=this.getPos().getY()+j;
                if((i==0 && j==0)||x<0 || y<0 || x>=monde.getTaille() || y>=monde.getTaille()){
                    
                }
                else {
                    s=monde.getW()[this.getPos().getX()+i][this.getPos().getY()+j];
                    if (!(".".equals(s))&& monde.getListeC().containsKey(s)){
                        l.add(s);
                    }
                }
            }
        }
        return l;
    }
    public String getTexteSauvegarde(){
        String s="Guerrier "+getNom()+" "+getPtVie()+" "+getDegAtt()+" "+getPtPar()+" "+getPageAtt()+" "+getPagePar()+" "+getDistAttMax()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
    
    
    
    
}
