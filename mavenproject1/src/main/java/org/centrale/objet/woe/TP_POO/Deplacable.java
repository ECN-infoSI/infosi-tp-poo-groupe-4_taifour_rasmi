
package org.centrale.objet.woe.TP_POO;

/**
 * Interface deplacable qui contient la méthode deplace propre à chaque creature
 * @author Mouad, Kaoutar
 */
public interface Deplacable {
    /**
     * methode deplacer pour un déplacement spécifique pour chaque element
     * @param monde 
     */
    void deplacer(World monde);
}
