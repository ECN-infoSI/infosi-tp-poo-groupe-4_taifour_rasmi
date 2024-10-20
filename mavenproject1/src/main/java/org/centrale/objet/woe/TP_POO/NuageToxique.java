
package org.centrale.objet.woe.TP_POO;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *Cette classe définit un nuage toxique
 * @author Mouad, Kaoutar
 * 
 */
public class NuageToxique extends Objet implements Combattant{
    //Attributs de la classe
    /**
     *paAtt: pourcentage d'attack
     *degAtt : dégats des attacks
     */

    private int paAtt;
    private int degAtt;
    
    public NuageToxique(){
        super();
    }
    public int getPaAtt() {
        return paAtt;
    }

    public void setPaAtt(int paAtt) {
        this.paAtt = paAtt;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     * constructeur pour le chargement du nuage 
     * @param ligne
     */
    public NuageToxique(String ligne){
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        setNom(tokenizer.nextToken());
        this.paAtt=Integer.parseInt(tokenizer.nextToken());
        this.degAtt=Integer.parseInt(tokenizer.nextToken());
        setPos(new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));
  
    }
    /**
     * renvoie la liste des creatures que le nuage peut combattre 
     * @param monde
     * @return  la liste
     */
    public ArrayList<String> CombatsPotentiels(World monde){
        ArrayList<String> l = new ArrayList<>();
        String s;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                if(i==0 && j==0){
                    
                }
                else{
                    s=monde.getW()[this.getPos().getX()+i][this.getPos().getY()+j];
                    if (!(".".equals(s))){
                        l.add(s);
                    }
                }
            }
        }
        return l;
    }
    
    
    @Override
    public void combattre(Creature c){
        
    }
    
    @Override
     public String getTexteSauvegarde(){
        String s="NuageToxique "+getNom()+" "+getPaAtt()+" "+getDegAtt()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
     
   
    
}
