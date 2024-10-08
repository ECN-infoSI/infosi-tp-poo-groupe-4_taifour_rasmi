/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Cette classe a pour but de représenter le « monde » dans lequel  évolueront les différents protagonistes de WoE
 * @author Mouad, Kaoutar
 */
public  class World {
    //Attributs de la classe
    /**
     * W: la surface sur laquelle les pretagonistes se place
     * listeC: la liste de l'ensemble des crétures 
     * listeO: la liste de l'ensemble des objets 
     */
   
    public String[][] W;
    
    public ArrayList<Creature> listeC=new ArrayList<>();
    public ArrayList<Objet> listeO=new ArrayList<>();
    
    public World(){
        
        W = new String[20][20]; 
    }
    /**
     * génération d'un nombre aléatoire 
     * @return un nombre alèatoire
     */
    
    public int genNombreAleatoire(){
        Random ga = new Random();
        return ga.nextInt(100);
    }
    
    /**
     * génération d'un tableau des 5 nombre aléatires 
     * @return tableau des 5 nombre aléatires 
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
     * @param k: le nombre aléatoire pour créer la créature
     */
    
    public  void creaArcher(int k){
        for(int i=0;i<k;i++){
            Archer a=new Archer();
            //a.setPos(new Point2D(genererPosUnique()));
            a.setNom("archer"+i);
            a.setPtVie(100);
            listeC.add(a);
        }
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire pour créer la créature
     */
    public void creaPaysan(int k){
        for(int i=0;i<k;i++){
            Paysan p=new Paysan();
            p.setPtVie(80);
            //p.setPos(new Point2D(genererPosUnique()));
            p.setNom("paysan"+i);
            listeC.add(p);
        }
        
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire pour créer la créature
     */
    public void creaLapin(int k){
        
        for(int i=0;i<k;i++){
            Lapin p=new Lapin();
            //p.setPos(new Point2D(genererPosUnique()));
            p.setPtVie(50);
            listeC.add(p);
        }
        
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire pour créer la créature
     */
    public void creaGuerrier(int k){
        for(int i=0;i<k;i++){
            Guerrier p=new Guerrier();
            //p.setPos(new Point2D(genererPosUnique()));
            p.setNom("guerrier"+i);
            p.setPtVie(150);
            listeC.add(p);
        }
        
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire pour créer la créature
     */
    public void creaLoup(int k){
        for(int i=0;i<k;i++){
            Loup p=new Loup();
            //p.setPos(new Point2D(genererPosUnique()));
            p.setPtVie(100);
            listeC.add(p);
        }
        
    }
    
    
    
    /**
     * génération d'une position non occupée par un autre protagoniste
     * @return une position unique 
     */
    public Point2D genererPosUnique() {
        Point2D p;
        Random ga = new Random();
        p = new Point2D(ga.nextInt(1000), ga.nextInt(1000));
        for(int i=0;i<listeC.size();i++){
            for(int j=0;j<=i;j++){
                while(listeC.get(j).getPos().equals(p)) p = new Point2D(ga.nextInt(1000), ga.nextInt(1000));
            }  
        }   
        
        for(int i=0;i<listeO.size();i++){
            for(int j=0;j<=i;j++){
                while(listeO.get(j).getPos().equals(p)) p = new Point2D(ga.nextInt(1000), ga.nextInt(1000));
            }  
        }  
        
        return p;
    }
    /**
     * Crée le monde en positionnat  les pretagonistes de manière aléatoire dans le monde.
     * les pretagonistes n'ont pas la même position 
     */
    
    public void creerMondeAlea() {

        //int[] t=geneTabl();
        
            

        creaArcher(10);
        creaPaysan(40);
        creaGuerrier(15);
        creaLapin(150);
        creaLoup(200);
        int pointVieT=0;
        Iterator<Creature> listIt = listeC.iterator();
        /*long debutN=System.nanoTime();
        for(int i=0;i<listeC.size();i++){
            pointVieT+=listeC.get(i).getPtVie();
        } */
        
        long debutN=System.nanoTime();
        while(listIt.hasNext()) {
            Creature p = listIt.next();
            pointVieT+=p.getPtVie();
        }
        System.out.println("Le nombre total des poitns de vie est ="+pointVieT);
        long finN=System.nanoTime();
        System.out.println("Le temps écoulé en ns: "+(finN-debutN));
    }
        
        
    /**
     * Affichage de Word
     */
    public void afficheWord(){
    
        for (String[] W1 : W) {
            for (String W11 : W1) {
                System.out.print(W11 + "\t"); 
            }
            System.out.println(); 
        }
    
    }
   

}
