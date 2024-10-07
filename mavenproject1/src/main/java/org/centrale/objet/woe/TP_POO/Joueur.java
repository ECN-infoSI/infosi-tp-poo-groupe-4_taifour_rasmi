/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author user
 */
public class Joueur {
    
    private Personnage perso;
    

   
    
    public Joueur(){
    
    }
    
    public void choisirType(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez choisir le type de votre personnage en choisissant le numéro correspondant :");
        System.out.println("1 - Guerrier");
        System.out.println("2 - Archer");
        
        int s = sc.nextInt();
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
