
package org.centrale.objet.woe.TP_POO;

import java.util.StringTokenizer;

/**
 * Classe Paysan
 * @author Mouad, Kaoutar
 */
public class Paysan extends Personnage{
    
    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        super(n,pV,dA,pPar,paAtt,paPar,dMax,p);
    }
    
    public Paysan(Paysan p){
        super(p);
    }
    
    public Paysan(){
        super();
    }
    
    /**
     * @param ligne
     */
    //constructeur pour le chargement de l'élément 
    public Paysan(String ligne){
        /**StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        super(tokenizer.nextToken(),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));*/
        super(ligne);
    }
    
    public String getTexteSauvegarde(){
        String s="Paysan "+getNom()+" "+getPtVie()+" "+getDegAtt()+" "+getPtPar()+" "+getPageAtt()+" "+getPagePar()+" "+getDistAttMax()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
    
}
