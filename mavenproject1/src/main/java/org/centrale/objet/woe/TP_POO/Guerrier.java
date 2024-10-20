
package org.centrale.objet.woe.TP_POO;

import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Random;


/**
 * Cette class définit un type de personnage qui est Guerrier
 * @author Mouad, Kaoutar
 */
public class Guerrier extends Personnage implements Combattant{
    
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        super(n,pV,dA,pPar,paAtt,paPar,dMax,p);
    }
    
    public Guerrier(Guerrier p){
        super(p);
    }
    
    public Guerrier(){
        super();
    }
    
     
    /**
     * constructeur pour le chargement de l'élément 
     * @param ligne
     */
    public Guerrier(String ligne){
        super(ligne);
        System.out.println(ligne);
    }
    
    /**
     * cette méthode a pour but de permettre le combat entre deux creature
     * @param creature 
     */
    @Override
    public void combattre(Creature creature){
        if(getPos().distance(creature.getPos())==1 || getPos().distance(creature.getPos())==sqrt(2)){ 
            Random ga = new Random();
            int rand = (int)(ga.nextInt(100)+1);
            if(rand>getPageAtt()){
                System.out.println("l'attaque de "+getNom()+" est ratée ");
            }
            else{
                System.out.println("l'attaque de "+getNom()+" est réussie ");
                rand = (int)(ga.nextInt(100)+1);
                if(rand>creature.getPagePar()){
                    creature.setPtVie(creature.getPtVie()-getDegAtt());
                }
                else{
                    creature.setPtVie(creature.getPtVie()-getDegAtt()+creature.getPtPar());
                }
            }
        }  
    }
    /**
     * cette méthode renvoie la liste des créatures que le joueur a le droit de combattre 
     * @param monde
     * @return : la liste des créatures 
     */
    
    @Override
    public ArrayList<String> CombatsPotentiels(World monde){
        ArrayList<String> l = new ArrayList<>();
        String s;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                int x=this.getPos().getX()+i;
                int y=this.getPos().getY()+j;
                if((i==0 && j==0)||x<0 || y<0 || x>=monde.getTaille() || y>=monde.getTaille()){
                    
                }
                else {
                    s=monde.getW()[this.getPos().getX()+i][this.getPos().getY()+j];
                    if (!(".".equals(s))&& monde.getListeC().containsKey(s)){
                        l.add(s);
                    }
                }
            }
        }
        return l;
    }
    
    /**
     * la ligne de sauvegarde de guerrier 
     * @return la ligne
     */
    public String getTexteSauvegarde(){
        String s="Guerrier "+getNom()+" "+getPtVie()+" "+getDegAtt()+" "+getPtPar()+" "+getPageAtt()+" "+getPagePar()+" "+getDistAttMax()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
    
    
    
    
}
