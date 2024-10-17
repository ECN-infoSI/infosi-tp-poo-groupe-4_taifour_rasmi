/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;




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
    @Override
    public abstract void deplacer();
    
    
}
