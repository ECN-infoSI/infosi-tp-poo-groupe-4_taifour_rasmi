
package org.centrale.objet.woe.TP_POO;

import java.util.Random;
import java.util.StringTokenizer;


/**
 * Classe personnage
 * @author Mouad,Kaoutar
 */

public abstract class Personnage extends Creature{
    //Attributs de la classe
    /**
     * nom du personnage
     * distAttMax : distance d'attack maximale
     */
    private String nom;
    private int distAttMax;
    
    /**
     * @see org.centrale.objet.woe.TP_POO.Point2D
     */
    
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        super(n,pV,dA,pPar,paAtt,paPar,new Point2D(p));
        nom=n;
        distAttMax=dMax;
    }
    
    public Personnage(Personnage perso){
        super(perso.getNom(),perso.getPtVie(),perso.getDegAtt(),perso.getPtPar(),perso.getPageAtt(),perso.getPagePar(),new Point2D(perso.getPos()));
        this.nom=perso.getNom();
        this.distAttMax=perso.getDistAttMax();
    }
    
    public Personnage(){
        
    }
    
    public Personnage(String s){
        super(s);
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

   
 
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
    
    
    /**
     * deplacer le personnage
     * @param monde : monde dans lequel on effectue ce déplacement
     */
    @Override
    public void deplacer(World monde){
        int x = getPos().getX();
        int y = getPos().getY();
        int taille = monde.getTaille();
        Random ga = new Random();
        int s = ga.nextInt(8);
        switch(s){
            case 0:
                if(x-1>=0){ // (i-1,j)
                    if(".".equals(monde.getW()[x-1][y])) {
                        this.getPos().translate(-1, 0);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y]=getNom();
                    }
                    
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 1:
                if(x+1<taille ){ // (i+1,j)
                    if(".".equals(monde.getW()[x+1][y])) {
                        this.getPos().translate(1, 0);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y]=getNom();
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 2:
                if(y+1<taille){ // (i,j+1)
                    if(".".equals(monde.getW()[x][y+1])) {
                        this.getPos().translate(0, 1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x][y+1]=getNom();
                    }
                        
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 3:
                if(y-1>=0){ // (i,j-1)
                    if(".".equals(monde.getW()[x][y-1]))
                    {
                        this.getPos().translate(0, -1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x][y-1]=getNom();
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 4:
                if(x-1>=0 && y+1<taille){ // (i-1,j+1)
                    if(".".equals(monde.getW()[x-1][y+1])){
                        this.getPos().translate(-1, +1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y+1]=getNom();
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 5:
                if(y-1>=0 && x+1<taille){ // (i+1,j-1)
                    if(".".equals(monde.getW()[x+1][y-1])){
                        this.getPos().translate(1, -1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y-1]=getNom();
                    
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 6: 
                if(x-1>=0 && y-1>=0){  // (i-1,j-1)
                    if(".".equals(monde.getW()[x-1][y-1])) {
                        this.getPos().translate(-1, -1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y-1]=getNom();
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;
            case 7:
                if(x+1<taille && y+1<taille){ // (i+1,j+1)
                    if(".".equals(monde.getW()[x+1][y+1])) {
                        this.getPos().translate(1, 1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y+1]=getNom();
                    }
                    else deplacer(monde);
                }
                else deplacer(monde);
                break;   
        }
        
        
        
    }
    
    /**
     * Affiche la position de la Personnage
     */
    @Override
    public void afficher(){
        System.out.print("le personnage "+nom+" se trouve dans la position : ");
        this.getPos().affiche();
    }
    
    
}
