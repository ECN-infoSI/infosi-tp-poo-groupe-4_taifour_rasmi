
package org.centrale.objet.woe.TP_POO;

import java.util.ArrayList;

/**
 * Interdace de combattant
 * @author Mouad, Kaoutar
 */
public interface Combattant {

    /**
     * cette méthode a pour but de permettre le combat entre deux creature
     *@param creature
     */
    public void combattre(Creature creature);
    
    /**
     * Cette méthode retourne la liste des créatures que le joueur a le doit de combattre.
     * @param monde : dans lequel on joue
     * @return : la liste des créatures
     */
    public abstract ArrayList<String> CombatsPotentiels(World monde);
}
