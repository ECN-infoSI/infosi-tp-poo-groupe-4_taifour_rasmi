/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.util.HashMap;
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
 effets : une collection des effets activés par le joueur
 inventaire : une collection des objets collectés par le joueur
     */
    private Personnage perso;
    private HashMap<String,Utilisable> inventaire;
    private HashMap<String,Utilisable> effets;
    
    public Joueur(){
        effets = new HashMap<>();
        inventaire = new HashMap<>();
    }
    
     public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

    public HashMap<String, Utilisable> getInventaire() {
        return inventaire;
    }

    public HashMap<String, Utilisable> getEffets() {
        return effets;
    }
    
    /**
     * méthode qui place le personnage de notre joueur dans la liste de créature et dans la liste d'affichage   
     * @param monde : le monde dans lequel on souhaite placer notre joueur
    */
    public void PlacerJoueur(World monde){
        perso.setPos(monde.genererPosUnique());
        monde.getListeC().put(perso.getNom(),perso);
        monde.getW()[perso.getPos().getX()][perso.getPos().getY()]=perso.getNom();
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
        
        
        //System.out.println(perso instanceof Guerrier);
        
    }
    /**
     * une méthode pour donner au joueur la possibilité de choisir de combattre ou bien de se déplacer
     * @return une chaîne de caractère correspondante au choix
     */
    public String choixJeu(){
        
        System.out.println("Choisissez le chiffre correspondant à votre action pour votre tour de rôle: ");
        System.out.println("1- Combattre");
        System.out.println("2- Se déplacer");
        System.out.println("3- Utiliser un objet");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        //tant que la saisie n'égale à 0 ni à 1
        while(s!=1 && s!=2 && s!=3){
            
            System.out.println("Veuillez saisir le numéro correspondant à votre choix :");
            System.out.println("1- Combattre");
            System.out.println("2- Se déplacer");
            System.out.println("3- Utiliser un objet");
            s = sc.nextInt();
        }
        switch (s) {
            case 1:
                return ("combattre");
            case 2:
                return ("se deplacer");
            default:
                return ("utiliser un objet");
        }
        
    }
     
    /**
     * la méthode a pour but de déplacer le joueur
     * 
     * @param monde : prend en paramètre le monde dans lequel le joueur souhaite effectuer son déplacement
     */
    public void deplacerJoueur(World monde){
        int taille=monde.getW().length;
        int x=perso.getPos().getX();
        int y=perso.getPos().getY();
        valeurEntrer(monde,x,y,taille);
        
    } 
    
    /**
     * la méthode sert à permettre au joueur de choisir les valeurs d'entrée pour son déplacement et gère les différents déplacements possibles
     * 
     */
    private void valeurEntrer(World monde,int x,int y,int taille){
        int s;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("choisir la position pour le déplacement: ");
            System.out.println("1- En haut"); // (i-1,j)
            System.out.println("2- En bas"); // (i+1,j)
            System.out.println("3- A droite"); // (i,j+1)
            System.out.println("4- A gauche");// (i,j-1)
            System.out.println("5- Diagonale en haut à droite");// (i-1,j+1)
            System.out.println("6- Diagonale en bas à gauche"); // (i+1,j-1)
            System.out.println("7- Diagonale en haut à gauche"); // (i-1,j-1)
            System.out.println("8- Diagonale en bas à droite"); 
            s = sc.nextInt();
        }
        //tant que la saisie n'est pas correcte
        while(!(s>0 && s<9));
                
        switch(s){
            case 1:
                if(x-1>=0){ // (i-1,j)
                    if(".".equals(monde.getW()[x-1][y])) {
                        perso.setPos(new Point2D(x-1,y));
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y]=perso.getNom();
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x-1][y])){
                        ramasserObjet(monde,new Point2D(x-1,y));
                        perso.setPos(new Point2D(x-1,y));
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y]=perso.getNom();
                    }
                    else valeurEntrer(monde,x,y,taille);
                }
                else valeurEntrer(monde,x,y,taille);
                break;
            case 2:
                if(x+1<taille ){ // (i+1,j)
                    if(".".equals(monde.getW()[x+1][y])) {
                        perso.setPos(new Point2D(x+1,y));
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y]=perso.getNom();
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x+1][y])){
                        ramasserObjet(monde,new Point2D(x+1,y));
                        perso.setPos(new Point2D(x+1,y));
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y]=perso.getNom();
                    }
                    else valeurEntrer(monde,x,y,taille);
                }
                else valeurEntrer(monde,x,y,taille);
                break;
            case 3:
                if(y+1<taille){ // (i,j+1)
                    if(".".equals(monde.getW()[x][y+1])) {
                        perso.setPos(new Point2D(x,y+1));
                        monde.getW()[x][y]=".";
                        monde.getW()[x][y+1]=perso.getNom();
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x][y+1])){
                        ramasserObjet(monde,new Point2D(x,y+1));
                        perso.setPos(new Point2D(x,y+1));
                        monde.getW()[x][y]=".";
                        monde.getW()[x][y+1]=perso.getNom();
                    }  
                    else valeurEntrer(monde,x,y,taille);
                }
                else valeurEntrer(monde,x,y,taille);
                break;
            case 4:
                if(y-1>0){ // (i,j-1)
                    if(".".equals(monde.getW()[x][y-1]))
                    {
                     perso.setPos(new Point2D(x,y-1));
                     monde.getW()[x][y]=".";
                     monde.getW()[x][y-1]=perso.getNom();
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x][y-1])){
                        ramasserObjet(monde,new Point2D(x,y-1));
                        perso.setPos(new Point2D(x,y-1));
                        monde.getW()[x][y]=".";
                        monde.getW()[x][y-1]=perso.getNom();
                    }
                    else valeurEntrer(monde,x,y,taille);
                }
                else valeurEntrer(monde,x,y,taille);
                break;
            case 5:
                if(x-1>=0 && y+1<taille){ // (i-1,j+1)
                    if(".".equals(monde.getW()[x-1][y+1])){
                         perso.setPos(new Point2D(x-1,y+1));
                         monde.getW()[x][y]=".";
                         monde.getW()[x-1][y+1]=perso.getNom();
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x-1][y+1])){
                        ramasserObjet(monde,new Point2D(x-1,y+1));
                        perso.setPos(new Point2D(x-1,y+1));
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y+1]=perso.getNom();
                    }
                    else valeurEntrer(monde,x,y,taille);
                }
                else valeurEntrer(monde,x,y,taille);
                break;
            case 6:
                if(y-1>=0 && x+1<taille){ // (i+1,j-1)
                    if(".".equals(monde.getW()[x+1][y-1])){
                        perso.setPos(new Point2D(x+1,y-1));
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y-1]=perso.getNom();
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x+1][y-1])){
                        ramasserObjet(monde,new Point2D(x+1,y-1));
                        perso.setPos(new Point2D(x+1,y-1));
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y-1]=perso.getNom();
                    }
                    else valeurEntrer(monde,x,y,taille);
                }
                else valeurEntrer(monde,x,y,taille);
                break;
            case 7: 
                if(x-1>=0 && y-1>=0){  // (i-1,j-1)
                    if(".".equals(monde.getW()[x-1][y-1])) {
                        perso.setPos(new Point2D(x-1,y-1));
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y-1]=perso.getNom();
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x-1][y-1])){
                        ramasserObjet(monde,new Point2D(x-1,y-1));
                        perso.setPos(new Point2D(x-1,y-1));
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y-1]=perso.getNom();
                    }
                    else valeurEntrer(monde,x,y,taille);
                }
                else valeurEntrer(monde,x,y,taille);
                break;
            case 8:
                if(x+1<taille && y+1<taille){ // (i+1,j+1)
                    if(".".equals(monde.getW()[x+1][y+1])) {
                        perso.setPos(new Point2D(x+1,y+1));
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y+1]=perso.getNom();
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x+1][y+1])){
                        ramasserObjet(monde,new Point2D(x+1,y+1));
                        perso.setPos(new Point2D(x+1,y+1));
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y+1]=perso.getNom();
                    }
                    else valeurEntrer(monde,x,y,taille);
                }
                else valeurEntrer(monde,x,y,taille);
                break;   
        }
    }
    
    /**
     * la méthode permet au joueur d'activer un objet qu'il dispose dans son inventaire
     * 
     */
    public void activerobjetChoix(){
        System.out.println("Veuillez choisir l'objet à activer :");
        inventaire.forEach((key, value) -> {
        System.out.println(key + "- " + ((Objet)value).getVal());
        });
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        inventaire.get(s).activer(this, s);
        
        
        

    }
    
    public void ramasserObjet(World monde, Point2D p){
        String s = monde.getW()[p.getX()][p.getY()];
        inventaire.put(s, (Utilisable)monde.getListeO().get(s));
        monde.getListeO().remove(s);
    }
    
   
    
    
}
