/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;
import java.util.Random;

/**
 * Classe personnage
 * @author Mouad,Kaoutar
 */

public class Personnage {
    //Attributs de la classe
    /**
     * nom du personnage
     * ptVie : points de vie du personnage
     * degAtt : dégats des attacks
     * ptPar : points de parade
     * pageAtt : pourcentage d'attack
     * pagePar : pourcentage de parade
     * distAttMax : distance d'attack maximale
     * pos : position du personnage
     */
    private String nom;
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private int distAttMax;
    
    /**
     * @see org.centrale.objet.woe.TP_POO.Point2D
     */
    private Point2D pos;
    
    Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        nom=n;
        ptVie=pV;
        degAtt=dA;
        ptPar=pPar;
        pageAtt=paAtt;
        pagePar=paPar;
        distAttMax=dMax;
        pos= new Point2D(p);
    }
    
    Personnage(Personnage perso){
        this.nom=perso.getNom();
        this.ptVie=perso.getPtVie();
        this.degAtt=perso.getDegAtt();
        this.ptPar=perso.getPtPar();
        this.pageAtt=perso.getPageAtt();
        this.pagePar=perso.getPagePar();
        this.distAttMax=perso.getDistAttMax();
        this.pos=new Point2D(perso.getPos());
    }
    
    Personnage(){
       this.pos = new Point2D(); 
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

    /**
     *
     * @return
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     *
     * @return
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     *
     * @return
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     *
     * @return
     */
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
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * deplacer un personnage
     * 
     */
    public void deplace(){
        Random ga = new Random();
        this.pos.translate(ga.nextInt(2)-1, ga.nextInt(2)-1);
    }
    /**
     * affiche la position du personnage avec son nom
     */
    public void affiche(){
        System.out.print("le personnage "+nom+" est dans la position : ");
        pos.affiche();
    }
    
}
