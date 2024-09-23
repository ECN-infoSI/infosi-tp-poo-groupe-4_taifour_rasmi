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
     *
     */
    public Archer guillaumeT;
    /**
     *@see org.centrale.objet.woe.TP_POO.Paysan
     */
    
    public Paysan peon;

    /**
     *@see org.centrale.objet.woe.TP_POO.Lapin
     */
    public Lapin bugs1;

    /**
     *
     */
    public Lapin bugs2;
    
    /**
     *@see org.centrale.objet.woe.TP_POO.Guerrier
     */
    public Guerrier grosBill;
    
    /**
     *@see org.centrale.objet.woe.TP_POO.Guerrier
     */
    public Loup wolfie;
    
    public String[][] W;
    
    World(){
        robin = new Archer();
        peon = new Paysan();
        bugs1 = new Lapin();
        bugs2 = new Lapin();
        guillaumeT = new Archer(robin);
        grosBill = new Guerrier();
        wolfie = new Loup();
        W = new String[40][40];
        
    }
    /**
     * Crée le monde en positionnat  l'archer, le paysant et le lapin de manière aléatoire dans le monde.
     * @return 
     */
    
    public Point2D genererPosUnique() {
            Point2D p;
            Random ga = new Random();
            do {
                p = new Point2D(ga.nextInt(W.length), ga.nextInt(W[0].length));
            } while (!W[p.getX()][p.getY()].equals(".")); 
            return p;
        }
    
    public void creerMondeAlea() {

        for (String[] W1 : W) {
            for (int j = 0; j < W1.length; j++) {
                W1[j] = "."; 
            }
        }

        
        Point2D p = genererPosUnique();
        robin.setPos(p);
        W[p.getX()][p.getY()] = "Archer";

        
        p = genererPosUnique();
        peon.setPos(p);
        W[p.getX()][p.getY()] = "Paysan";

        
        p = genererPosUnique();
        bugs1.setPos(p);
        W[p.getX()][p.getY()] = "Lapin1";

        
        p = genererPosUnique();
        bugs2.setPos(p);
        W[p.getX()][p.getY()] = "Lapin2";

        
        p = genererPosUnique();
        guillaumeT.setPos(p);
        W[p.getX()][p.getY()] = "Archer2";

        
        p = genererPosUnique();
        grosBill.setPos(p);
        W[p.getX()][p.getY()] = "Guerrier";

       
        p = genererPosUnique();
        wolfie.setPos(p);
        W[p.getX()][p.getY()] = "Loup";
    }

}
