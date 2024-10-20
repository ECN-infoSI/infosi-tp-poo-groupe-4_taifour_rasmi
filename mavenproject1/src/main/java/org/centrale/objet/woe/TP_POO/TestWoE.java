
package org.centrale.objet.woe.TP_POO;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * cette classe a pour but de créer les différents objets nécessaires aux tests de la classe World et des autres classes
 * @author Mouad, Kaoutar
 */

public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String []args) throws IOException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    
        World monde=new World();
        //Joueur joueur=new Joueur();
        //monde.setJoueur(joueur);*/
        monde.tourDeJeu();
    }
}
