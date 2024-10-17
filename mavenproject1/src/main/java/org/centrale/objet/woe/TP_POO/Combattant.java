/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.ArrayList;

/**
 *
 * @author Mouad, Kaoutar
 */
public interface Combattant {

    /**
     * cette méthode a pour but de permettre le combat entre deux creature
     *@param creature
     */
    public void combattre(Creature creature);
    
    
    public abstract ArrayList<String> CombatsPotentiels(World monde);
}
