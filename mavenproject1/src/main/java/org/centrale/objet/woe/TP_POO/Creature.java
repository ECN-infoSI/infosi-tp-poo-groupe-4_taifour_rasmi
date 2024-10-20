
package org.centrale.objet.woe.TP_POO;

import java.util.Random;
import java.util.StringTokenizer;

/**
 * Classe Creature 
 * @author Mouad, Kaoutar
 */
public abstract class Creature extends ElementDeJeu implements Deplacable  {
    //Attributs de la classe
    /**
     * ptVie : points de vie de la creature
     * degAtt : dégats des attacks
     * ptPar : points de parade
     * pageAtt : pourcentage d'attack
     * pagePar : pourcentage de parade
     * pos : position de la creature
     */
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    /**
     * @see org.centrale.objet.woe.TP_POO.Point2D
     */
    private Point2D pos;
    
    public Creature(String identifiant,int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(identifiant);
        ptVie=pV;
        degAtt=dA;
        ptPar=pPar;
        pageAtt=paAtt;
        pagePar=paPar;
        pos=new Point2D(p);
    }
    
    /**
     * Constructeur pour le chargement d'une créature
     * @param ligne 
     */
    public Creature(String ligne){
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        setIdentifiant(tokenizer.nextToken());
         ptVie=Integer.parseInt(tokenizer.nextToken());
        degAtt=Integer.parseInt(tokenizer.nextToken());;
        ptPar=Integer.parseInt(tokenizer.nextToken());;
        pageAtt=Integer.parseInt(tokenizer.nextToken());;
        pagePar=Integer.parseInt(tokenizer.nextToken());;
        pos=new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
    }
    
    public Creature(){
        pos=new Point2D();
    }
    
    public int getPtVie() {
        return ptVie;
    }


    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }


    public int getDegAtt() {
        return degAtt;
    }


    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }


    public int getPtPar() {
        return ptPar;
    }


    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }


    public int getPageAtt() {
        return pageAtt;
    }


    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }


    public int getPagePar() {
        return pagePar;
    }


    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }


    public Point2D getPos() {
        return pos;
    }


    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    

    
    /**
     * affichage de la creature
     */
    public abstract void afficher();
   
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
    
    
    public String getTexteSauvegarde(){
        return " ";
    }
    
    
}
