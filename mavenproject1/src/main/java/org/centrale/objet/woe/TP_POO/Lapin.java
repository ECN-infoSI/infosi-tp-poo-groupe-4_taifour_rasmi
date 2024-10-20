
package org.centrale.objet.woe.TP_POO;


/**
 * Classe Lapin
 * @author Mouad, Kaoutar
 */
public class Lapin extends Monstre {
    
    public Lapin(String identifiant,int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(identifiant,pV, dA, pPar, paAtt, paPar, p);
    }
    
    public Lapin(Lapin l){
        super(l);
    }
    
    public Lapin(){
        super();
    }
    
    /**
     * 
     */
    //constructeur pour le chargement de l'élément 
    public Lapin(String ligne){
        /**StringTokenizer tokenizer = new StringTokenizer(ligne);
        String mot = tokenizer.nextToken();
        super(tokenizer.nextToken(),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));**/
        super(ligne);
    }
    
    /**
     * affiche le lapin
     */
    public void affiche(){
        System.out.print("le lapin"+getIdentifiant()+" est dans la position : ");
        getPos().affiche();
    }
    /**
     * pour sauvegarder un lapin
     * @return la ligne de sauvegarde
     */
    public String getTexteSauvegarde(){
        String s="Lapin "+getIdentifiant()+" "+getPtVie()+" "+getDegAtt()+" "+getPtPar()+" "+getPageAtt()+" "+getPagePar()+" "+getPos().getX()+" "+getPos().getY();
        return s;
    }
    
}
