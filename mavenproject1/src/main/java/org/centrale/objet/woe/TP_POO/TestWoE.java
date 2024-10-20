
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
        Joueur joueur=new Joueur();
        monde.setJoueur(joueur);
        joueur.choisirType();
        joueur.PlacerJoueur(monde);
        monde.creerMondeAlea();
        monde.tourDeJeu(joueur);
        //pour le sauvegarde et le chargement de partie, nous avons tourDuJeu qui s'arrete une fois le joueuer 
        //a perdu toute ses points, donc on modifie la condition de tourDuJeU POUR VISUALISER SES PARTIES
        //car pour l'arreter dans le premier cas ça prend du temps
        //consulter le fichier dans la racine du fichier pour visualiser le résultat 
        monde.sauvegardePartie("enregistre.txt");
        System.out.println("Chargement de la partie");
        monde.chargementPartie("enregistre.txt");
        monde.afficheWorld();
    }
}
