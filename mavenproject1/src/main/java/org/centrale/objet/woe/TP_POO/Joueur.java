
package org.centrale.objet.woe.TP_POO;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
     *effets : une collection des effets activés par le joueur
     *inventaire : une collection des objets collectés par le joueur
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
        //on supprime le nom de la classe Joueur pour appeler le constructeur de chargement pour le personnage de joueur 
        while (tokenizer.hasMoreTokens()) {
            sb.append(tokenizer.nextToken());
            if (tokenizer.hasMoreTokens()) {
                sb.append(" ");  
            }
        }
        String ligne2 = nomClass+" "+sb.toString();
        
        try{
            Class classe= Class.forName(p.getName()+"."+nomClass);
            Constructor ct= classe.getConstructor(String.class);
            ElementDeJeu element = (ElementDeJeu)ct.newInstance((Object)ligne2);
            if(element instanceof Guerrier) this.perso=(Guerrier)element;
            else this.perso=(Archer)element;
            
            //System.out.println("testJoueur"+this.perso.getIdentifiant());
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
        
        String s = sc.nextLine();
        //pour gerer les valeurs saisies par le joueur 
        while(!"1".equals(s) && !"2".equals(s)){
            System.out.println("Veuillez saisir le numéro correspondant à votre choix :");
            s = sc.nextLine();
        }
        
        //sc.nextLine();
        System.out.println("Entrez le nom de votre personnage");
        String nom = sc.nextLine();
        
        Random ga = new Random();
        
        if("1".equals(s)){
            creerGuerrierJoueur(ga,nom);
        }else{
            creerArcherJoueur(ga,nom);
        }
    }
    
    /**
     * cette méthode a pour rôle de créer un gerrier 
     * @param ga 
     */
    private void creerGuerrierJoueur(Random ga,String nom){
        perso= new Guerrier();
        perso= new Guerrier();
        perso.setNom(nom);
        perso.setIdentifiant(nom);
        perso.setPtVie(100+ga.nextInt(51));
        perso.setPtPar(20+ga.nextInt(11));
        perso.setDegAtt(30+ga.nextInt(11));
        perso.setDistAttMax(1);
        perso.setPageAtt(80+ga.nextInt(21));
        perso.setPagePar(20+ga.nextInt(20));            
    }
    
    /**
     * cette méthode a pour rôle de créer un archer 
     * @param ga 
     */
    private void creerArcherJoueur(Random ga,String nom){
            perso= new Archer();
            perso.setNom(nom);
            perso.setIdentifiant(nom);
            perso.setPtVie(80+ga.nextInt(20));
            perso.setPtPar(30+ga.nextInt(21));
            perso.setDegAtt(10+ga.nextInt(11));
            perso.setDistAttMax(3);
            perso.setPageAtt(50+ga.nextInt(11));
            perso.setPagePar(30+ga.nextInt(20));                 
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
        System.out.println("5- Quitter");
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        //tant que la saisie n'est pas correcte
        
        while(!"1".equals(s) && !"2".equals(s) && !"3".equals(s) && !"4".equals(s) && !"5".equals(s)){
            System.out.println("Veuillez saisir le numero correspondant à votre choix :");
            System.out.println("1- Combattre");
            System.out.println("2- Se deplacer");
            System.out.println("3- Utiliser un objet");
            System.out.println("4- Sauvegarder");
            System.out.println("5- Quitter");
            s = sc.nextLine();
        }
        switch (s) {
            case "1":
                return ("combattre");
            case "2":
                return ("se deplacer");
            case "3":
                return ("utiliser un objet");
            case "4":
                return ("Sauvegarder");
            default:
                return ("Quitter");
        }
        
    }
 
    /**
     * une méthode pour donner au joueur la possibilité de choisir entre charger une partie ou bien creer un monde de nouveau
     * @return une chaîne de caractère correspondante au choix
     */
    public String typeJeu(){
        
        System.out.println("Choisissez le chiffre correspondant au type de votre jeu: ");
        System.out.println("1- creer un monde aléatoirement");
        System.out.println("2- Charger une partie");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //tant que la saisie n'égale à 0 ni à 1
        while(!"1".equals(s) && !"2".equals(s) ){
            System.out.println("Veuillez chosir le chiffre correspondant au type de votre jeu: ");
            System.out.println("1- creer un monde aléatoirement");
            System.out.println("2- Charger une partie");
            s = sc.nextLine();
        }
        switch (s) {
            case "1":
                return ("alea");
            case "2":
                return ("char");
            default:
                return ("");
        }
        
    }
     
    /**
     * la méthode a pour but de déplacer le joueur
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
        System.out.println(key);
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
    
    /**
     * cette méthode a pour rôle de permettre au joueur ou bien à un pretagoniste de ramasser un objet
     * @param monde
     * @param p : position de l'objet à ramasser 
     */
    public void ramasserObjet(World monde, Point2D p){
        String s = monde.getW()[p.getX()][p.getY()];
        inventaire.put(s, (Utilisable)monde.getListeO().get(s));
        monde.getListeO().remove(s);
    }
    
    /**
     * cette méthode définit le tour du joueur 
     * @param monde
     * @throws IOException
     * @throws NoSuchMethodException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException 
     */
    public void tourDuJoueur(World monde) throws IOException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
                decEffets();
                afficheJoueur();
                String s = this.choixJeu();
                if("combattre".equals(s)){
                    
                    ArrayList<String> l = ((Combattant)this.getPerso()).CombatsPotentiels(monde);
                    if(l.isEmpty()){
                        System.out.println("Il n'y a aucune créature à portée.");
                    }
                    else{
                        System.out.println("Entrez le nom de la créature que vous voulez combattre parmi les suivants :");
                        for(String elt : l){
                            System.out.println(elt);
                        }
                        Scanner sc = new Scanner(System.in);
                        String crea = sc.nextLine();
                        while(!(l.contains(crea))){
                            System.out.println("Veuillez entrer un nom de créature valide :)");
                            crea = sc.nextLine();
                        }
                        Creature cr = monde.getListeC().get(crea);
                        if(perso instanceof Guerrier){
                            ((Guerrier)perso).combattre(cr);
                        }
                        else if(perso instanceof Archer){
                            ((Archer)perso).combattre(cr);
                        }
                    }
                    
                }
                else if ("se deplacer".equals(s)){
                    deplacerJoueur(monde);
                }
                else if ("utiliser un objet".equals(s)){
                    if(inventaire.isEmpty()){
                        System.out.println("Votre inventaire est vide ! vous ne pouvez pas activer aucun objet.");
                    }
                    else activerobjetChoix();
                }
                else if ("Sauvegarder".equals(s)){
                    System.out.println("Veuillez saisir le nom de votre fichier: ");
                    Scanner sc = new Scanner(System.in);
                    String fichier = sc.nextLine();
                    monde.sauvegardePartie(fichier);
                    System.out.println("Votre partie est bien sauvegardée.");
                    System.exit(0);
                }
                else {
                   System.exit(0);
                }
                
           

    }
    
        /**
     * decremente les effets des objets activés à chaque tour de jeu du joueur 
     */
    public void decEffets(){
        if(effets.isEmpty()){
            
        }
        else{
            effets.forEach((key, value)-> {
                ((Objet)value).setDuree(((Objet)value).getDuree()-1);
                if(((Objet)value).getDuree()==0){
                    value.desactiver(this,((Objet)value).getNom());
                }
            });
        }
    }
    
    /**
     * pour l'affichage des information de joueur 
     */
    public void afficheJoueur(){
        System.out.println("___________________________________________");
        System.out.println("Nom du joueur :"+perso.getIdentifiant());
        System.out.println("Points de vie :"+perso.getPtVie());
        System.out.println("dégats des attacks :"+perso.getDegAtt());
        System.out.println("points de parade :"+perso.getPtPar());
        System.out.println("Position :"+perso.getPos().toString());
        System.out.println();
        if(!(inventaire.isEmpty())) {
            System.out.println("Inventaire:");
            inventaire.forEach((key,value)-> {
                System.out.println(key+" sa duree est: "+((Objet)value).getDuree());
            }); 
        }
        else System.out.println("Votre Inventiare est vide");
        if(!(effets.isEmpty())){
            System.out.println("effet: ");
            effets.forEach((key,value)-> {
                System.out.println(key+" duree "+((Objet)value).getDuree());
            });  
        }
        else System.out.println("Votre liste des effets est vide");
        System.out.println("___________________________________________");
    }

}
