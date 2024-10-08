/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Scanner;
import java.util.Random;

/**
 *Cette classe a pour but de céer un joueur. Ce joueur peut choisir le type de personnage et la manière de jeu (se déplacer ou bien combattre)
 * @author Mouad, Kaoutar
 * 
 */
public class Joueur {
    //Attributs de la classe
    /**
     * perso: le personnage choisi par l'utilisateur 
     */
    private Personnage perso;
    
    public Joueur(){
    
    }
    /**
     * cette méthode a pour but de permettre au joueur le choix du personnage et so nom
     */
    public void choisirType(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Veuillez choisir le type de votre personnage en choisissant le numéro correspondant :");
        System.out.println("1 - Guerrier");
        System.out.println("2 - Archer");
        
        int s = sc.nextInt();
        //pour gerer les valeurs saisies par le joueur 
        while(s!=1 && s!=2){
            
            System.out.println("Veuillez saisir le numéro correspondant à votre choix :");
            s = sc.nextInt();
        }
        
        sc.nextLine();
        System.out.println("Entrez le nom de votre personnage");
        String nom = sc.nextLine();
        
        Random ga = new Random();
        if(s==1){
            perso= new Guerrier();
            perso.setNom(nom);
            perso.setPtVie(100+ga.nextInt(51));
            perso.setPtPar(20+ga.nextInt(11));
            perso.setDegAtt(30+ga.nextInt(11));
            perso.setDistAttMax(1);
            perso.setPageAtt(50+ga.nextInt(21));
            perso.setPagePar(20+ga.nextInt(20));
        }else{
            perso= new Archer();
            perso.setNom(nom);
            perso.setPtVie(80+ga.nextInt(20));
            perso.setPtPar(30+ga.nextInt(21));
            perso.setDegAtt(10+ga.nextInt(11));
            perso.setDistAttMax(3);
            perso.setPageAtt(40+ga.nextInt(11));
            perso.setPagePar(30+ga.nextInt(20));
        }
        
        System.out.println(perso instanceof Guerrier);
        
        
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }
    
}
