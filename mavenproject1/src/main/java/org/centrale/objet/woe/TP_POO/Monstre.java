/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Random;

/**
 *
 * @author Mouad
 */
public class Monstre {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;
    
    Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        ptVie=pV;
        degAtt=dA;
        ptPar=pPar;
        pageAtt=paAtt;
        pagePar=paPar;
        pos=new Point2D(p);
    }
    
    Monstre(Monstre m){
        ptVie=m.getPtVie();
        degAtt=m.getDegAtt();
        ptPar=m.getPtPar();
        pageAtt=m.getPageAtt();
        pagePar=m.getPagePar();
        pos=new Point2D(m.getPos());
    }
    
    Monstre(){
        
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
    
    public void deplace(){
        Random ga = new Random();
        this.pos.translate(ga.nextInt(2)-1, ga.nextInt(2)-1);
    }
    
    public void affiche(){
        System.out.print("le monstre se trouve dans la position : ");
        pos.affiche();
    }
    
}
