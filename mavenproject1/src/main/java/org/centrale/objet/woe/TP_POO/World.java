/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Cette classe a pour but de représenter le « monde » dans lequel  évolueront les différents protagonistes de WoE
 * @author Mouad, Kaoutar
 */
public class World {
    //Attributs de la classe
    /**
     * W: la surface sur laquelle les pretagonistes se place
     * listeC: la liste de l'ensemble des crétures 
     * listeO: la liste de l'ensemble des objets 
     */
   
    public String[][] W;
    
    public LinkedList<Creature> listeC=new LinkedList<>();
    public LinkedList<Objet> listeO=new LinkedList<>();
    
    World(){
        
        W = new String[40][40]; 
    }
    /**
     * génération d'un nombre aléatoire 
     * @return un nombre alèatoire
     */
    
    public int genNombreAleatoire(){
        Random ga = new Random();
        return ga.nextInt(20);
    }
    
    /**
     * génération d'un tableau des 5 nombres aléatoires 
     * @return tableau de 5 nombres aléatoires 
     */
    
    public int[] geneTabl(){
        int[] t=new int[5];
        t[0]=genNombreAleatoire();
        //System.out.print("["+t[0]+"]");
        for(int i=1;i<=4;i++){
            t[i]=genNombreAleatoire();
            for(int j=1;j<=i;j++){
                while(t[j-1]==t[i]) t[i]=genNombreAleatoire();
            }  
            //System.out.print("["+t[i]+"]");
        }
        return t;
    }
    
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire d'archers
     */
    
    public void creaArcher(int k){
        for(int i=0;i<k;i++){
            Archer a=new Archer();
            a.setPos(new Point2D(genererPosUnique()));
            a.setNom("archer"+i);
            a.affiche();
            listeC.add(a);
        }
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire de paysans
     */
    public void creaPaysan(int k){
        for(int i=0;i<k;i++){
            Paysan p=new Paysan();
            p.setPos(new Point2D(genererPosUnique()));
            p.setNom("paysan"+i);
            p.affiche();
            listeC.add(p);
        }
        
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire de lapins
     */
    public void creaLapin(int k){
        for(int i=0;i<k;i++){
            Lapin p=new Lapin();
            p.setPos(new Point2D(genererPosUnique()));
            p.affiche();
            listeC.add(p);
        }
        
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire de guerriers
     */
    public void creaGuerrier(int k){
        for(int i=0;i<k;i++){
            Guerrier p=new Guerrier();
            p.setPos(new Point2D(genererPosUnique()));
            p.setNom("guerrier"+i);
            p.affiche();
            listeC.add(p);
        }
        
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire de loups
     */
    public void creaLoup(int k){
        for(int i=0;i<k;i++){
            Loup p=new Loup();
            p.setPos(new Point2D(genererPosUnique()));
            p.affiche();
            listeC.add(p);
        }
        
    }
    
    
    
    /**
     * génération d'une position non occupée par un autre protagoniste / objet
     * @return une position unique 
     */
    public Point2D genererPosUnique() {
        Point2D p;
        Random ga = new Random();
        p = new Point2D(ga.nextInt(30), ga.nextInt(30));
        for(int i=0;i<listeC.size();i++){
            for(int j=0;j<=i;j++){
                while(listeC.get(j).getPos().equals(p)) p = new Point2D(ga.nextInt(30), ga.nextInt(30));
            }  
        }  
        //Pour la liste des objets
        /*
        for(int i=0;i<listeO.size();i++){
            for(int j=0;j<=i;j++){
                while(listeO.get(j).getPos().equals(p)) p = new Point2D(ga.nextInt(30), ga.nextInt(30));
            }  
        }*/ 
        
        return p;
    }
    
    
    /**
     * Crée le monde en positionant les protagonistes et les objets de manière aléatoire dans le monde.
     * les protagonistes et les objets n'ont pas les mêmes positions
     */
    
    public void creerMondeAlea() {
        
        for (String[] W1 : W) {
            for (int j = 0; j < W1.length; j++) {
                W1[j] = "."; 
            }
        }

        int[] t=geneTabl();
        creaArcher(t[0]);
        creaPaysan(t[1]);
        creaGuerrier(t[2]);
        creaLapin(t[3]);
        creaLoup(t[4]);
    }
        
        
    /**
     * Affichage de World
     */
    public void afficheWorld(){
    
        
        for (String[] W1 : W) {
            for (String W11 : W1) {
                System.out.print(W11 + "\t"); 
            }
            System.out.println(); 
        }
    
    }

}
