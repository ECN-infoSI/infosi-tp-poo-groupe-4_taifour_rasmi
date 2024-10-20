
package org.centrale.objet.woe.TP_POO;

/**
 *
 * @author Mouad, Kaoutar
 */
public interface Utilisable {
    
    public void activer(Joueur j,String s);
    public void desactiver(Joueur j,String s);
    public String getTexteSauvegardeInve();
    public String getTexteSauvegardeEffe();
 
}
