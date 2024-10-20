
package org.centrale.objet.woe.TP_POO;


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
     * constructeur pour le chargement de l'élément 
     * @param ligne
     */
    public Paysan(String ligne){
        
        super(ligne);
    }
    /**
     * pour la sauvegarde du paysan
     * @return la ligne
     */
    public String getTexteSauvegarde(){
        String s="Paysan "+getNom()+" "+getPtVie()+" "+getDegAtt()+" "+getPtPar()+" "+getPageAtt()+" "+getPagePar()+" "+getDistAttMax()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
    
}
