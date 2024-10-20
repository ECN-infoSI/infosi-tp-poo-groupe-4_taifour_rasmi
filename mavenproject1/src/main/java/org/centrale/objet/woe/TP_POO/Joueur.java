/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.TP_POO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.StringTokenizer;

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
    
    public Joueur(Joueur j){
        this.effets=new HashMap<>(j.getInventaire());
        this.effets=new HashMap<>(j.getEffets());
        if(j.getPerso() instanceof Guerrier) this.perso=new Guerrier((Guerrier)j.getPerso());
        else this.perso=new Archer((Archer)j.getPerso());
    }
    /**
     * @param ligne
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     */
    //constructeur pour le chargement de l'élément 
    public Joueur(String ligne) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        effets = new HashMap<>();
        inventaire = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(ligne);
        String nomClass = tokenizer.nextToken();
        nomClass = tokenizer.nextToken();
        Package p = this.getClass().getPackage();
        StringBuilder sb = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            sb.append(tokenizer.nextToken());
            if (tokenizer.hasMoreTokens()) {
                sb.append(" ");  
            }
        }
         String ligne2 = nomClass+" "+sb.toString();
        //System.out.println(ligne2);
        try{
            Class classe= Class.forName(p.getName()+"."+nomClass);
            Constructor ct= classe.getConstructor(String.class);
            ElementDeJeu element = (ElementDeJeu)ct.newInstance((Object)ligne2);
            if(element instanceof Guerrier) this.perso=new Guerrier((Guerrier)element);
            else this.perso=new Archer((Archer)element);
        }
        catch(NoSuchMethodException e){
            e.getMessage();
        }  
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
            perso.setPageAtt(80+ga.nextInt(21));
            perso.setPagePar(20+ga.nextInt(20));
            //perso.setPos(new Point2D(ga.nextInt(20),ga.nextInt(14)));
            
        }else{
            perso= new Archer();
            perso.setNom(nom);
            perso.setPtVie(80+ga.nextInt(20));
            perso.setPtPar(30+ga.nextInt(21));
            perso.setDegAtt(10+ga.nextInt(11));
            perso.setDistAttMax(3);
            perso.setPageAtt(50+ga.nextInt(11));
            perso.setPagePar(30+ga.nextInt(20));
            //perso.setPos(new Point2D(ga.nextInt(20),ga.nextInt(14)));
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
        System.out.println("4- Sauvegarder");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        //tant que la saisie n'égale à 0 ni à 1
        while(s!=1 && s!=2 && s!=3 && s!=4){
            
            System.out.println("Veuillez saisir le numéro correspondant à votre choix :");
            System.out.println("1- Combattre");
            System.out.println("2- Se déplacer");
            System.out.println("3- Utiliser un objet");
            System.out.println("4- Sauvegarder");
            s = sc.nextInt();
        }
        switch (s) {
            case 1:
                return ("combattre");
            case 2:
                return ("se deplacer");
            case 3:
                return ("utiliser un objet");
            default:
                return ("Sauvegarder");
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
        this.valeurEntrer(monde,x,y,taille,this);
        
    } 
    
    /**
     * la méthode sert à permettre au joueur de choisir les valeurs d'entrée pour son déplacement et gère les différents déplacements possibles
     * 
     */
    private void valeurEntrer(World monde,int x,int y,int taille, Joueur j){
        int s;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("choisir une position (parmi les suivantes et ne doit pas franchir les frontières du monde ) pour effectuer un déplacement: ");
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
                        perso.getPos().setPos(x-1,y);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y]=perso.getNom();
                        
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x-1][y])){
                        ramasserObjet(monde,new Point2D(x-1,y));
                        perso.getPos().setPos(x-1,y);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y]=perso.getNom();
                        
                    }
                    else{
                        valeurEntrer(monde,x,y,taille,j);
                    }
                }
                else valeurEntrer(monde,x,y,taille,j);
                break;
            case 2:
                if(x+1<taille ){ // (i+1,j)
                    if(".".equals(monde.getW()[x+1][y])) {
                        perso.getPos().setPos(x+1,y);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y]=perso.getNom();
                        
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x+1][y])){
                        ramasserObjet(monde,new Point2D(x+1,y));
                        perso.getPos().setPos(x+1,y);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y]=perso.getNom();
                        
                    }
                    else{
                        valeurEntrer(monde,x,y,taille,j);
                    }
                }
                else valeurEntrer(monde,x,y,taille,j);
                break;
            case 3:
                if(y+1<taille){ // (i,j+1)
                    if(".".equals(monde.getW()[x][y+1])) {
                        perso.getPos().setPos(x,y+1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x][y+1]=perso.getNom();
                        
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x][y+1])){
                        ramasserObjet(monde,new Point2D(x,y+1));
                        perso.getPos().setPos(x,y+1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x][y+1]=perso.getNom();
                        
                    }  
                    else{
                        valeurEntrer(monde,x,y,taille,j);
                    }
                }
                else valeurEntrer(monde,x,y,taille,j);
                break;
            case 4:
                if(y-1>=0){ // (i,j-1)
                    if(".".equals(monde.getW()[x][y-1]))
                    {
                        perso.getPos().setPos(x,y-1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x][y-1]=perso.getNom();
                        
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x][y-1])){
                        ramasserObjet(monde,new Point2D(x,y-1));
                        perso.getPos().setPos(x,y-1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x][y-1]=perso.getNom();
                        
                    }
                    else{
                        valeurEntrer(monde,x,y,taille,j);
                    }
                }
                else valeurEntrer(monde,x,y,taille,j);
                break;
            case 5:
                if(x-1>=0 && y+1<taille){ // (i-1,j+1)
                    if(".".equals(monde.getW()[x-1][y+1])){
                        perso.getPos().setPos(x-1,y+1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y+1]=perso.getNom();
                        
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x-1][y+1])){
                        ramasserObjet(monde,new Point2D(x-1,y+1));
                        perso.getPos().setPos(x-1,y+1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y+1]=perso.getNom();
                        
                    }
                    else{
                        valeurEntrer(monde,x,y,taille,j);
                    }
                }
                else valeurEntrer(monde,x,y,taille,j);
                break;
            case 6:
                if(y-1>=0 && x+1<taille){ // (i+1,j-1)
                    if(".".equals(monde.getW()[x+1][y-1])){
                        perso.getPos().setPos(x+1,y-1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y-1]=perso.getNom();
                        
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x+1][y-1])){
                        ramasserObjet(monde,new Point2D(x+1,y-1));
                        perso.getPos().setPos(x+1,y-1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y-1]=perso.getNom();
                        
                    }
                    else{
                        valeurEntrer(monde,x,y,taille,j);
                    }
                }
                else valeurEntrer(monde,x,y,taille,j);
                break;
            case 7: 
                if(x-1>=0 && y-1>=0){  // (i-1,j-1)
                    if(".".equals(monde.getW()[x-1][y-1])) {
                        perso.getPos().setPos(x-1,y-1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y-1]=perso.getNom();
                        
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x-1][y-1])){
                        ramasserObjet(monde,new Point2D(x-1,y-1));
                        perso.getPos().setPos(x-1,y-1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x-1][y-1]=perso.getNom();
                        
                    }
                    else{
                        valeurEntrer(monde,x,y,taille,j);
                    }
                }
                else valeurEntrer(monde,x,y,taille,j);
                break;
            case 8:
                if(x+1<taille && y+1<taille){ // (i+1,j+1)
                    if(".".equals(monde.getW()[x+1][y+1])) {
                        perso.getPos().setPos(x+1,y+1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y+1]=perso.getNom();
                        
                    }
                    else if(monde.getListeO().containsKey(monde.getW()[x+1][y+1])){
                        ramasserObjet(monde,new Point2D(x+1,y+1));
                        perso.getPos().setPos(x+1,y+1);
                        monde.getW()[x][y]=".";
                        monde.getW()[x+1][y+1]=perso.getNom();
                        
                    }
                    else{
                        valeurEntrer(monde,x,y,taille,j);
                    }
                            
                }
                else valeurEntrer(monde,x,y,taille,j);
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
        String s;
        do{
            System.out.println("Selectionner votre objet:) ");
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
        }while(!(inventaire.containsKey(s)));
        
        
        inventaire.get(s).activer(this, s);
        
        
        

    }
    
    /**
     * cette méthode a pour objectif de renvoyer un texte de sauvegarde
     * @return 
     */
    public String getTexteSauvegarde(){
        String s;
        if(perso instanceof Guerrier)s=((Guerrier)perso).getTexteSauvegarde();
        else s= ((Archer)perso).getTexteSauvegarde();
        return "Joueur "+s;
    }
    public void ramasserObjet(World monde, Point2D p){
        String s = monde.getW()[p.getX()][p.getY()];
        inventaire.put(s, (Utilisable)monde.getListeO().get(s));
        monde.getListeO().remove(s);
    }

   
    
    
}
