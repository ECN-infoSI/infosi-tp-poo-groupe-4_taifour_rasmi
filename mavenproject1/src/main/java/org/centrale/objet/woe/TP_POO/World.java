/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;
import java.util.Random;

/**
 * Cette classe a pour but de représenter le « monde » dans lequel  évolueront les différents protagonistes de WoE
 * @author Mouad, Kaoutar
 */
public class World {
    //Attributs de la classe
    /**
     * robin: un archer
     * peon : un paysan 
     * bugs : un lapin 
     */
    /**
     * @see org.centrale.objet.woe.TP_POO.Archer
     */
    public Archer robin;

    /**
     *@see org.centrale.objet.woe.TP_POO.Paysan
     */
    public Paysan peon;

    /**
     *@see org.centrale.objet.woe.TP_POO.Lapin
     */
    public Lapin bugs;
    
    World(){
        robin = new Archer();
        peon = new Paysan();
        bugs = new Lapin();
    }
    /**
     * Crée le monde en positionnant l'archer, le paysant et le lapin de manière aléatoire dans le monde.
     * l'archer, le paysant et le lapin n'ont pas la même position initiale
     */
    void creerMondeAlea(){
        
        Random ga = new Random();
        Point2D p = new Point2D(ga.nextInt(50),ga.nextInt(50));
        robin.setPos(p);
        /**
         * @see Point2D.generePointDiff
         */
        p = p.generePointDiff(p);
        peon.setPos(p);
        p = p.generePointDiff(p);
        while(p.equals(robin.getPos())){
            p = p.generePointDiff(p);
        }
        bugs.setPos(p);
        
    }
}
