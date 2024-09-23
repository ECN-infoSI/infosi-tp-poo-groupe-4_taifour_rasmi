/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Random;

/**
 * Classe Monstre
 * @author Mouad, Kaoutar
 * 
 */
public class Monstre extends Creature{
    
    Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
    }
    Monstre(Monstre m){
        super(m.getPtVie(),m.getDegAtt(),m.getPtPar(),m.getPageAtt(),m.getPagePar(),new Point2D(m.getPos()));
    }
    
    Monstre(){
        super();
    }



 
    
}
