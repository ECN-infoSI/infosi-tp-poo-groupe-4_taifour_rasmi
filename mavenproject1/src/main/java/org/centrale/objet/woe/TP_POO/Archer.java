package org.centrale.objet.woe.TP_POO;

import java.util.ArrayList;
import java.util.Random;


/**
 *  Classe Archer
 *  @author Mouad, Kaoutar
 */
public class Archer extends Personnage implements Combattant{
    //Attributs 
    /**
     * nbFleches: nombre de flèches possédées par l'arher
     */
    private int nbFleches;
    
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches){
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        this.nbFleches=nbFleches;
    }
    
    public Archer(Archer a){
        super(a); //super((Personnage)a)
        this.nbFleches=a.getNbFleches();
    }
    
    public Archer(){
        super();
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    /**
     * méthode combattre de la creature de type Archer
     * @param crea 
    */
    @Override
    public void combattre(Creature crea){
        if(getPos().distance(crea.getPos())<getDistAttMax()){ 
            nbFleches -= 1;
            Random ga = new Random();
            int rand = (int)(ga.nextInt(100)+1);
            if(rand>getPageAtt()){
                System.out.println("l'attaque de "+getNom()+" est ratée ");
            }
            else{
                System.out.println("attaque de "+getNom()+" est réussie");
                crea.setPtVie(crea.getPtVie()-getDegAtt());
            }
        }
    } 
    /**
     * @param ligne
     */
    //constructeur pour le chargement de l'élément 
    public Archer(String ligne){
        /**StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        super(tokenizer.nextToken(),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));
        this.nbFleches=Integer.parseInt(tokenizer.nextToken());*/
        super(ligne);
          
    }
    
    @Override
    public ArrayList<String> CombatsPotentiels(World monde){
        ArrayList<String> l = new ArrayList<>();
        String s;
        for(int i=-2;i<3;i++){
            for(int j=-2;j<3;j++){
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
    
    public String getTexteSauvegarde(){
        String s="Archer "+getNom()+" "+getPtVie()+" "+getDegAtt()+" "+getPtPar()+" "+getPageAtt()+" "+getPagePar()+" "+getDistAttMax()+" "+getPos().getX()+" "+getPos().getY()+" "+nbFleches;
        return s;
    }
}
