
package org.centrale.objet.woe.TP_POO;


/**
 * Classe Monstre
 * @author Mouad, Kaoutar
 * 
 */
public abstract class Monstre extends Creature{
    public Monstre(String identifiant,int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(identifiant,pV, dA, pPar, paAtt, paPar, p);
    }
    public Monstre(Monstre m){
        super(m.getIdentifiant(),m.getPtVie(),m.getDegAtt(),m.getPtPar(),m.getPageAtt(),m.getPagePar(),new Point2D(m.getPos()));
    }
    
    public Monstre(){
        super();
    }
    public Monstre(String s){
        super(s);
    }
 
    /**
     * Affiche la position du monstre
     */
    @Override
    public void afficher(){
        System.out.print("le monstre se trouve dans la position : ");
        this.getPos().affiche();
    }
    

   
}
