package org.centrale.objet.woe.TP_POO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
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
     * taille: la taille du tableau
     * listeC: la liste de l'ensemble des crétures 
     * listeO: la liste de l'ensemble des objets 
     * joueur: le joueur courant 
     * fichiers: les fichiers de sauvegarde
     */
    private String[][] W;
    private  int taille=20;
    private HashMap<String,Creature> listeC;
    private HashMap<String,Objet> listeO;
    private Joueur joueur;
    private ArrayList<String> fichiers;
    

    public int getTaille() {
        return taille;
    }
    
    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String[][] getW() {
        return W;
    }

    public void setW(String[][] W) {
        this.W = W;
    }
    
    public HashMap<String, Creature> getListeC() {
        return listeC;
    }
    
    public void setListeC(HashMap<String, Creature> listeC) {
        this.listeC = listeC;
    }
    
    public HashMap<String, Objet> getListeO() {
        return listeO;
    }
    
    public void setListeO(HashMap<String, Objet> listeO) {
        this.listeO = listeO;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public ArrayList<String> getFichiers() {
        return fichiers;
    }

    public void setFichiers(ArrayList<String> fichiers) {
        this.fichiers = fichiers;
    }
    
    
    
    public World() throws IOException{
        W = new String[taille][taille]; 
        //listeC = new ArrayList<>();
        listeC = new HashMap<>();
        listeO = new HashMap<>();
        joueur=new Joueur();
        
        //on stocke les fichiers de chargement
        fichiers = new ArrayList<>(); 
        Files.newDirectoryStream(new File(".").toPath(), "*.txt").forEach(path -> fichiers.add(path.getFileName().toString()));
        
        //on place les cases vides dans le tableau
        for (String[] W1 : W) {
            for (int j = 0; j < W1.length; j++) {
                W1[j] = "."; 
            }
        }
    }
    
//méthodes 
    
    
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
     * creation des pretagonistes  
     * @param k: le nombre aléatoire d'archers
     */
    public  void creaArcher(int k){
        for(int i=0;i<k;i++){
            Archer a=new Archer();
            a.setPos(new Point2D(genererPosUnique()));
            a.setNom("Ar"+i);
            W[a.getPos().getX()][a.getPos().getY()]=a.getNom();
            a.setIdentifiant("Ar"+i);
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
            a.setIdentifiant("Pay"+i);
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
             a.setIdentifiant("Guer"+i);
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
        Random ga = new Random();
        for(int i=0;i<k;i++){
            PotionSoin a=new PotionSoin();
            a.setPos(new Point2D(genererPosUnique()));
            a.setNom("Soin"+i);
            a.setIdentifiant("Soin"+i);
            W[a.getPos().getX()][a.getPos().getY()]=a.getNom();
            a.setVal(10+ga.nextInt(41));
            listeO.put(a.getNom(),a);
        }    
    }
    
    /**
     * creation des épées  
     * @param k: le nombre aléatoire de potions
     */
    public void creerEpee(int k){
        Random ga = new Random();
        for(int i=0;i<k;i++){
            Epee a=new Epee();
            a.setNom("Epee"+i);
            a.setIdentifiant("Epee"+i);
            a.setPos(new Point2D(genererPosUnique()));
            W[a.getPos().getX()][a.getPos().getY()]=a.getNom();
            a.setVal(5+ga.nextInt(26));
            listeO.put(a.getNom(),a);
        }    
    }
    
    /**
     * creation de nourritures  
     * @param k: le nombre aléatoire de potions
     */
    public void creerNourriture(int k){
        for(int i=0;i<k;i++){
            Miel a=new Miel();
            a.setNom("miel"+i);
            a.setIdentifiant("miel"+i);
            a.setPos(new Point2D(genererPosUnique()));
            W[a.getPos().getX()][a.getPos().getY()]=a.getNom();
            a.setDuree(5);
            a.setVal(5);
            listeO.put(a.getNom(),a);
        }    
    }

    
    /**
     * Crée le monde en positionant les protagonistes et les objets de manière aléatoire dans le monde.
     * les protagonistes et les objets n'ont pas les mêmes positions
     */
    public void creerMondeAlea() {
        creaArcher(5);
        creaPaysan(6);
        creaGuerrier(5);
        creaLapin(10);
        creaLoup(6);
        creerPotions(8);
        creerEpee(15);
        creerNourriture(4);
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
    public void tourDeJeu() throws IOException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        String type=joueur.typeJeu();
        if ("char".equals(type)){
            if(!fichiers.isEmpty()){
                System.out.println("Veuillez choisir parmi les fichiers:");
                for (String fichier:fichiers){
                    System.out.println(fichier);
                }
                Scanner sc = new Scanner(System.in);
                String fichier = sc.nextLine();
                chargementPartie(fichier);
                //joueur=this.joueur;
                System.out.println(joueur.getPerso().getNom());
                updateWorld();
            }
            
        }
        else{
            creerMondeAlea();
            joueur.choisirType();
            joueur.PlacerJoueur(this);
        }

        Random ga = new Random();
        int a = ga.nextInt(taille);
        int b = ga.nextInt(taille);
       // joueur.getPerso().getPtVie()>0
        while(joueur.getPerso().getPtVie()>0 ){
            //k++;
            System.out.println();
            System.out.println();
            System.out.println();
            this.afficheWorld();
            
            
            decEffets(joueur);
            //Random gc = new Random();
            

            while(".".equals(W[a][b]) || !((listeC.get(W[a][b])) instanceof Creature) ){
                a = ga.nextInt(taille);
                b = ga.nextInt(taille);
            }
            
            Creature c = listeC.get(W[a][b]);
            
            //le joueur qui va jouer maintenant 
            if(c==joueur.getPerso()){
                joueur.tourDuJoueur(this);
            }
            //une creature choisie aleatoirement va jouer 
            else{
                a = ga.nextInt(2);
                if(a==0){
                    c.deplacer(this);
                }
                else{
                    if(c instanceof Paysan || c instanceof Lapin){
                        c.deplacer(this);
                    }
                    else{
                        if(c instanceof Guerrier){
                            ArrayList<String> l = ((Guerrier) c).CombatsPotentiels(this);
                            if(l.isEmpty()) c.deplacer(this);
                            else{
                                b = ga.nextInt(l.size());
                                ((Guerrier) c).combattre(listeC.get(l.get(b)));
                            }
                        }
                        else if(c instanceof Archer){
                            ArrayList<String> l = ((Archer) c).CombatsPotentiels(this);
                            if(l.isEmpty()) c.deplacer(this);
                            else{
                                b = ga.nextInt(l.size());
                                ((Archer) c).combattre(listeC.get(l.get(b)));
                            }
                        }
                        else if(c instanceof Loup){
                            ArrayList<String> l = ((Loup) c).CombatsPotentiels(this);
                            if(l.isEmpty()) c.deplacer(this);
                            else{
                                b = ga.nextInt(l.size());
                                ((Loup) c).combattre(listeC.get(l.get(b)));
                            }
                        }
                        
                    }
                    
                }
                        
            }
            testMeurtre();
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
               
               source = source + ".txt";
               
               String ligne;
               BufferedReader fichier =new BufferedReader(new FileReader(source)) ;
               ligne=fichier.readLine();
               StringTokenizer tokenizer = new StringTokenizer(ligne);
               String nomClass=tokenizer.nextToken();
               this.taille=Integer.parseInt(tokenizer.nextToken());
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
        Package p = this.getClass().getPackage();
        if(nomClass.equals("Inventaire")) {
            nomClass=tokenizer.nextToken();
            StringBuilder sb = new StringBuilder();
            while (tokenizer.hasMoreTokens()) {
                sb.append(tokenizer.nextToken());
                if (tokenizer.hasMoreTokens()) {
                    sb.append(" ");  
                }
            }
         ligne = nomClass+" "+sb.toString();
            try{
         Class classe= Class.forName(p.getName()+"."+nomClass);
         Constructor ct= classe.getConstructor(String.class);
         Object element = (Object)ct.newInstance((Object)ligne);
       
         this.joueur.getInventaire().put(((Objet)element).getNom(),(Utilisable)element);
         }
        catch(NoSuchMethodException e){
            e.getMessage();
        }
        } 
        //System.out.println(nomClass);
        else{
        try{
            Class classe= Class.forName(p.getName()+"."+nomClass);
            Constructor ct= classe.getConstructor(String.class);
            Object element = (Object)ct.newInstance((Object)ligne);
            if(element instanceof Creature) listeC.put(((Creature)element).getIdentifiant(),(Creature)element);
            else if(element instanceof Objet) listeO.put(((Objet)element).getNom(),(Objet)element);
            else if(element instanceof Joueur) {
                this.joueur=(Joueur)element;
                System.out.println("test"+this.joueur.getPerso().getIdentifiant());
                listeC.put(this.joueur.getPerso().getIdentifiant(),(Creature)this.joueur.getPerso());
            }    
            if(element instanceof Utilisable && this.joueur.getInventaire()!=null) this.joueur.getInventaire().put(((Objet)element).getNom(),(Utilisable)element);
        }
        catch(NoSuchMethodException e){
            e.getMessage();
        }
        }
       
    }
    
    /**
     * cette méthode a pour objectif de modifier le word
     */  
    public void updateWorld(){
        
        listeC.forEach((key,value)-> {
            W[value.getPos().getX()][value.getPos().getY()]=key;
         
        });
        listeO.forEach((key,value)-> {
            W[value.getPos().getX()][value.getPos().getY()]=key;
         
        });
        
        //this.joueur.PlacerJoueur(this);
    
    }
    /**
     * Cette méthode a pour rôle de supprimer les créatures qui ont perdu leurs points de vie.
     */
    public void testMeurtre(){

        listeC.forEach((key,value)-> {
            if(value.getPtVie()<=0){
                
                W[value.getPos().getX()][value.getPos().getY()]=".";
                listeC.remove(key);
            }
        });
        
       
    }
    
    public void decEffets(Joueur joueur){
        if(joueur.getEffets().isEmpty()){
            
        }
        else{
            joueur.getEffets().forEach((key, value)-> {
                ((Objet)value).setDuree(((Objet)value).getDuree()-1);
                if(((Objet)value).getDuree()==0){
                    value.desactiver(joueur,((Objet)value).getNom());
                }
            });
        }
    }
    
    /**
     * cette méthode a pour but de sauvegarder une partie
     * @param  source du fichier pour l'enregistrer
     */
    public void sauvegardePartie(String source) throws IOException{
        //BufferedWriter bufferedWriter=null;
        // System.out.println(this.joueur.getInventaire());
        source = source + ".txt";
        String taille="Taille "+this.taille;
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(source))){
            bufferedWriter.write(taille);
            bufferedWriter.newLine();
            listeC.forEach((key,value)-> {
                try {
                    bufferedWriter.write(value.getTexteSauvegarde());
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    ex.getMessage();
                }
        });
            listeO.forEach((key,value)-> {
                try {
                    bufferedWriter.write(value.getTexteSauvegarde());
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    ex.getMessage();
                }
        });
            bufferedWriter.write(joueur.getTexteSauvegarde());
            bufferedWriter.newLine();
            if (joueur.getInventaire()==null){
            } else {
                joueur.getInventaire().forEach((key,value)-> {
                    try {
                        bufferedWriter.write(value.getTexteSauvegardeInve());
                        bufferedWriter.newLine();
                    } 
                    catch (IOException ex) {
                        ex.getMessage();
                    }
                });
            }
            if (joueur.getInventaire()==null){
            } else {
                joueur.getEffets().forEach((key,value)-> {
                    try {
                        bufferedWriter.write(value.getTexteSauvegardeEffe());
                        bufferedWriter.newLine();
                    } 
                    catch (IOException ex) {
                        ex.getMessage();
                    }
                });
            }
        }
        catch(FileNotFoundException e){
            e.getMessage();
        }
        catch(IOException e){
            e.getMessage();
        }
        /*finally{
            try{
                if(bufferedWriter !=null){
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            }
            catch(IOException e){
                e.getMessage();
            }
        }*/
    }
}
