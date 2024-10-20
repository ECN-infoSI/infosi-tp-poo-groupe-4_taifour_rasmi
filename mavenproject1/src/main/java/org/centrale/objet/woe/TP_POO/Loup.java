
package org.centrale.objet.woe.TP_POO;

import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe du loup
 * @author Mouad, Kaoutar
 */
public class Loup extends Monstre implements Combattant{
    

    public Loup(String identifiant,int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(identifiant,pV, dA, pPar, paAtt, paPar, p);

    }
    
    public Loup(Loup l){
        super(l);
    }
        
    
    
    public Loup(){
        super();
    }
    
    /**
     * constructeur pour le chargement de l'élément 
     * @param ligne
     */
    public Loup(String ligne){
       super(ligne);
    }


    /**
     * méthode combattre de la creature de type Loup
     * @param crea 
     */
    @Override
    public void combattre(Creature crea){
        if(getPos().distance(crea.getPos())==1 || getPos().distance(crea.getPos())==sqrt(2)){ 
            Random ga = new Random();
            int rand = (int)(ga.nextInt(100)+1);
            if(rand>getPageAtt()){
                System.out.println("l'attaque de "+getIdentifiant()+" est ratée ");
            }
            else{
                System.out.println("l'attaque de "+getIdentifiant()+" est réussie ");
                rand = (int)(ga.nextInt(100)+1);
                if(rand>crea.getPagePar()){
                    crea.setPtVie(crea.getPtVie()-getDegAtt());
                }
                else{
                    crea.setPtVie(crea.getPtVie()-getDegAtt()+crea.getPtPar());
                }
            }
        }  
    }
    
    /**
     * cette méthode a pour rôle de renvoyer la liste des creatures que le loup a le droit de combattre
     * @param monde
     * @return la liste des creatures
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
                else{
                    s=monde.getW()[this.getPos().getX()+i][this.getPos().getY()+j];
                    if (!(".".equals(s)) && monde.getListeC().containsKey(s)){
                        l.add(s);
                    }
                }
            }
        }
        return l;
    }
    
    /**
     * pour le sauvegarde d'une partie
     * @return la,ligne de sauvegarde
     */
    @Override
    public String getTexteSauvegarde(){
        String s="Loup "+getIdentifiant()+" "+getPtVie()+" "+getDegAtt()+" "+getPtPar()+" "+getPageAtt()+" "+getPagePar()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
    
    /**
     * affiche un loup
    */
    public void affiche(){
        System.out.print("le loup est dans la position : ");
        getPos().affiche();
    }
    
}
