/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Random;
import java.util.StringTokenizer;


/**
 * Classe Monstre
 * @author Mouad, Kaoutar
 * 
 */
public abstract class Monstre extends Creature{
    public Monstre(String identifiant,int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(identifiant,pV, dA, pPar, paAtt, paPar, p);
    }
    public Monstre(Monstre m){
        super(m.getIdentifiant(),m.getPtVie(),m.getDegAtt(),m.getPtPar(),m.getPageAtt(),m.getPagePar(),new Point2D(m.getPos()));
    }
    
    public Monstre(){
        super();
    }
    public Monstre(String s){
        super(s);
    }

    
     /**
     * deplace le personnage
     * @param monde : monde dans lequel on effectue ce déplacement
     */
    @Override
    public void deplacer(World monde){
        int x = getPos().getX();
        int y = getPos().getY();
        int taille = monde.getTaille();
        Random ga = new Random();
        int s = ga.nextInt(9);
        switch(s){
            case 1:
                if(x-1>=0){ // (i-1,j)
                    if(".".equals(monde.getW()[x-1][y])) {
                        this.getPos().translate(-1, 0);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y]=getIdentifiant();
                    }
                    
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 2:
                if(x+1<taille ){ // (i+1,j)
                    if(".".equals(monde.getW()[x+1][y])) {
                        this.getPos().translate(1, 0);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y]=getIdentifiant();
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 3:
                if(y+1<taille){ // (i,j+1)
                    if(".".equals(monde.getW()[x][y+1])) {
                        this.getPos().translate(0, 1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x][y+1]=getIdentifiant();
                    }
                        
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 4:
                if(y-1>=0){ // (i,j-1)
                    if(".".equals(monde.getW()[x][y-1]))
                    {
                        this.getPos().translate(0, -1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x][y-1]=getIdentifiant();
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 5:
                if(x-1>=0 && y+1<taille){ // (i-1,j+1)
                    if(".".equals(monde.getW()[x-1][y+1])){
                        this.getPos().translate(-1, +1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y+1]=getIdentifiant();
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 6:
                if(y-1>=0 && x+1<taille){ // (i+1,j-1)
                    if(".".equals(monde.getW()[x+1][y-1])){
                        this.getPos().translate(1, -1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y-1]=getIdentifiant();
                    
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 7: 
                if(x-1>=0 && y-1>=0){  // (i-1,j-1)
                    if(".".equals(monde.getW()[x-1][y-1])) {
                        this.getPos().translate(-1, -1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y-1]=getIdentifiant();
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 8:
                if(x+1<taille && y+1<taille){ // (i+1,j+1)
                    if(".".equals(monde.getW()[x+1][y+1])) {
                        this.getPos().translate(1, 1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y+1]=getIdentifiant();
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;   
        }
    }
    
    /**
     * Affiche la position du monstre
     */
    @Override
    public void afficher(){
        System.out.print("le monstre se trouve dans la position : ");
        this.getPos().affiche();
    }
    

   
}
