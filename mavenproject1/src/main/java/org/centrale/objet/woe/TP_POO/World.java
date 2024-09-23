/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;
import java.util.Random;

/**
 *
 * @author user
 */
public class World {
    public Archer robin;
    public Archer guillaumeT;
    public Paysan peon;
    public Lapin bugs;
    
    World(){
        robin = new Archer();
        peon = new Paysan();
        bugs = new Lapin();
        guillaumeT= new Archer(robin);
        
    }
    
    void creerMondeAlea(){
        
        Random ga = new Random();
        Point2D p = new Point2D(ga.nextInt(50),ga.nextInt(50));
        robin.setPos(p);
        p = p.generePointDiff(p);
        peon.setPos(p);
        p = p.generePointDiff(p);
        while(p.equals(robin.getPos())){
            p = p.generePointDiff(p);
        }
        bugs.setPos(p);
        
    }
}
