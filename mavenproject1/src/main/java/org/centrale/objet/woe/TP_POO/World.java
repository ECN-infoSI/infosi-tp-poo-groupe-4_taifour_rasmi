/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

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
    private String[][] W;
    private final int taille=20;
    //public ArrayList<Creature> listeC;
    private HashMap<String,Creature> listeC;
    private HashMap<String,Objet> listeO;
    

    public int getTaille() {
        return taille;
    }

    public String[][] getW() {
        return W;
    }

    public HashMap<String, Creature> getListeC() {
        return listeC;
    }

    public HashMap<String, Objet> getListeO() {
        return listeO;
    }
    
    
    public World(){
        W = new String[taille][taille]; 
        //listeC = new ArrayList<>();
        listeC = new HashMap<>();
        listeO = new HashMap<>();
        for (String[] W1 : W) {
            for (int j = 0; j < W1.length; j++) {
                W1[j] = "."; 
            }
        }
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
    
    public  void creaArcher(int k){
        for(int i=0;i<k;i++){
            Archer a=new Archer();
            a.setPos(new Point2D(genererPosUnique()));
            a.setNom("Ar"+i);
            W[a.getPos().getX()][a.getPos().getY()]=a.getNom();
            a.getPos().affiche();
            a.setPtVie(100);
            listeC.put(a.getNom(),a);
        }
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire de paysans
     */
    public void creaPaysan(int k){
        for(int i=0;i<k;i++){
            Paysan a=new Paysan();
            a.setPtVie(80);
            a.setPos(new Point2D(genererPosUnique()));
            a.setNom("Pay"+i);
            W[a.getPos().getX()][a.getPos().getY()]=a.getNom();
            listeC.put(a.getNom(),a);
        }
        
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire de lapins
     */
    public void creaLapin(int k){
        
        for(int i=0;i<k;i++){
            Lapin a=new Lapin();
            a.setPos(new Point2D(genererPosUnique()));
            a.setIdentifiant("La"+i);
            W[a.getPos().getX()][a.getPos().getY()]=a.getIdentifiant();
            a.setPtVie(50);
            listeC.put(a.getIdentifiant(),a);
        }
        
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire de guerriers
     */
    public void creaGuerrier(int k){
        for(int i=0;i<k;i++){
            Guerrier a=new Guerrier();
            a.setPos(new Point2D(genererPosUnique()));
            a.setNom("Guer"+i);
            W[a.getPos().getX()][a.getPos().getY()]=a.getNom();
            a.setPtVie(100);
            listeC.put(a.getNom(),a);
        }
        
    }
    /**
     * creation des pretagonistes  
     * @param k: le nombre aléatoire de loups
     */
    public void creaLoup(int k){
        for(int i=0;i<k;i++){
            Loup a=new Loup();
            a.setPos(new Point2D(genererPosUnique()));
            a.setIdentifiant("Loup"+i);
            W[a.getPos().getX()][a.getPos().getY()]=a.getIdentifiant();
            a.setPtVie(150);
            listeC.put(a.getIdentifiant(),a);
        }
        
    }
    
    /**
     * creation des potions  
     * @param k: le nombre aléatoire de potions
     */
    public void creerPotions(int k){
        for(int i=0;i<k;i++){
            PotionSoin a=new PotionSoin();
            a.setPos(new Point2D(genererPosUnique()));
            a.setNom("Soin"+i);
            W[a.getPos().getX()][a.getPos().getY()]=a.getNom();
            a.setVal(20);
            listeO.put(a.getNom(),a);
        }    
    }
    
    /**
     * creation des épées  
     * @param k: le nombre aléatoire de potions
     */
    public void creerEpee(int k){
        for(int i=0;i<k;i++){
            Epee a=new Epee();
            a.setNom("Epee"+i);
            a.setPos(new Point2D(genererPosUnique()));
            W[a.getPos().getX()][a.getPos().getY()]="epee"+1;
            listeO.put(a.getNom(),a);
        }    
    }
    
    /**
     * creation de nourritures  
     * @param k: le nombre aléatoire de potions
     */
    public void creerNourriture(int k){
        for(int i=0;i<k;i++){
            Nourriture a=new Nourriture();
            a.setNom("Nour"+i);
            a.setPos(new Point2D(genererPosUnique()));
            W[a.getPos().getX()][a.getPos().getY()]="Nour"+1;
            listeO.put(a.getNom(),a);
        }    
    }
    
    
    
    
    /**
     * génération d'une position non occupée par un autre protagoniste / objet
     * @return une position unique de type Point2D
     */
    public Point2D genererPosUnique(){
        Point2D p;
        Random ga = new Random();
        do{
            p=new Point2D(ga.nextInt(W.length), ga.nextInt(W[0].length));
        }while(!W[p.getX()][p.getY()].equals("."));
        return p;
    }
    
    /**
     * Crée le monde en positionant les protagonistes et les objets de manière aléatoire dans le monde.
     * les protagonistes et les objets n'ont pas les mêmes positions
     */
    
    public void creerMondeAlea() {
        creaArcher(10);
        creaPaysan(30);
        creaGuerrier(15);
        creaLapin(30);
        creaLoup(10);
        creerPotions(5);
        creerEpee(6);
    }
    
         
    /**
     * Affichage de World
     */
    public void afficheWorld(){
    
        //à mettre à jour pour visualiser l'ensemble des protagonistes et des objets stockés dans listeC et listeO
        for (String[] W1 : W) {
            for (String W11 : W1) {
                System.out.print(W11 + "\t"); 
            }
            System.out.println(); 
        }
    
    }
    
    
    /**
     * méthode qui définit le tour du jeu   
     * @param joueur: le joueur humain
    */
    public void tourDeJeu(Joueur joueur){
        
        while(joueur.getPerso().getPtVie()>0){
            this.afficheWorld();
            Random ga = new Random();
            //Random gc = new Random();
            int a = ga.nextInt(taille);
            int b = ga.nextInt(taille);

            while(".".equals(W[a][b]) && !(listeC.get(W[a][b]) instanceof Creature) ){
                a = ga.nextInt(taille);
                b = ga.nextInt(taille);
            }
            
           
            Creature c = listeC.get(W[a][b]);

            if(c==joueur.getPerso()){
                
                String s = joueur.choixJeu();
                if("combattre".equals(s)){
                    ArrayList<String> l = ((Combattant)joueur.getPerso()).CombatsPotentiels(this);
                    if(l.isEmpty()){
                        System.out.println("Il n'a aucune créature à portée.");
                    }
                    System.out.println("Entrez le nom de la créature que vous voulez combattre :");
                    Scanner sc = new Scanner(System.in);
                    String crea = sc.nextLine();
                    Creature cr = listeC.get(crea);
                    if(joueur.getPerso() instanceof Guerrier guerrier){
                        guerrier.combattre(cr);
                    }
                    if(joueur.getPerso() instanceof Archer archer){
                        archer.combattre(cr);
                    }
                }
                else if ("se deplacer".equals(s)){
                    joueur.deplacerJoueur(this);
                }
                else{
                    if(joueur.getInventaire().isEmpty()){
                        System.out.println("Votre inventaire est vide ! vous ne pouvez pas activer aucun objet.");
                    }
                    else joueur.activerobjetChoix();
                }
            }
            else{
                a = ga.nextInt(2);
                if(a==0){
                    c.deplacer();
                }
                else{
                    if(c instanceof Paysan || c instanceof Lapin){
                        c.deplacer();
                    }
                    else{
                        if(c instanceof Guerrier){
                            ArrayList<String> l = ((Guerrier) c).CombatsPotentiels(this);
                            if(l.isEmpty()) c.deplacer();
                            else{
                                b = ga.nextInt(l.size());
                                ((Guerrier) c).combattre(listeC.get(l.get(b)));
                            }
                        }
                        else if(c instanceof Archer){
                            ArrayList<String> l = ((Archer) c).CombatsPotentiels(this);
                            if(l.isEmpty()) c.deplacer();
                            else{
                                b = ga.nextInt(l.size());
                                ((Archer) c).combattre(listeC.get(l.get(b)));
                            }
                        }
                        else{
                            ArrayList<String> l = ((Loup) c).CombatsPotentiels(this);
                            if(l.isEmpty()) c.deplacer();
                            else{
                                b = ga.nextInt(l.size());
                                ((Loup) c).combattre(listeC.get(l.get(b)));
                            }
                        }
                        
                    }
                    
                }
                        
            }
            
        }   
    }
    
    
    
    
    
    
    /**
     * cette méthode a pour but de charger une partie déjà enregistrée
     * @param source: le nom du fichier de sauvegarde à charger
     * @throws java.io.IOException
     * @throws java.lang.NoSuchMethodException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     */
    
    public void chargementPartie(String source) throws IOException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
           try{
               String ligne;
               BufferedReader fichier =new BufferedReader(new FileReader(source)) ;
               ligne=fichier.readLine();
               while(ligne!=null){
                    creerElementJeu(ligne);
                   ligne=fichier.readLine();
               }
           }
           catch(FileNotFoundException e){
                e.getMessage();
           }
    }
    
    /**
     * cette méthode a pour but de créer un élèment de jeu
     * @param ligne: c'est le tokenizer qu'on va découper (correspond à la ligne)
     * @throws java.lang.NoSuchMethodException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     */
    
    public void creerElementJeu(String ligne) throws NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String nomClass=tokenizer.nextToken();
        System.out.println(nomClass);
        Package p = this.getClass().getPackage();
        try{
            Class classe= Class.forName(p.getName()+"."+nomClass);
            Constructor ct= classe.getConstructor(String.class);
            ElementDeJeu element = (ElementDeJeu)ct.newInstance((Object)ligne);
            if(element instanceof Creature) listeC.put(element.getIdentifiant(),(Creature)element);
        }
        catch(NoSuchMethodException e){
            e.getMessage();
        }
       
    }
    
    /**
     * cette méthode a pour objectif de modifier le word
     */  
    public void updateWorld(){
        
        listeC.forEach((key,value)-> {
            W[value.getPos().getX()][value.getPos().getY()]=key;
        });
    
    }
}
