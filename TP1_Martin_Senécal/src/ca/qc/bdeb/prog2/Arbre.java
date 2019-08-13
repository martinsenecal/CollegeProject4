/*
Classe arbre: Il y a plusieurs sortes d'arbres. On doit donc les créer. Chaque
arbre possède une taille, un joueur ainsi qu'une condition si cette arbre est 
utiliser ou non. On se sert de cette classe dans arboretum par l'entremise de 
getter et de setter.

 */
package ca.qc.bdeb.prog2;

public class Arbre {

   //Déclaration de variable de ma classe Arbre:
    private int taille;
    private Joueur joueur;
    private boolean arbreUtiliser=false;
//---------Constructeur (2)-------------------
    
    public Arbre(Joueur joueur, int taille) {
        this.taille = taille;
        this.joueur = joueur;
    }
    
    public Arbre(Joueur joueur) {
        this.joueur = joueur;
    }
//---------Méthode (getter-setter)-------------
    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getTaille() {
        return taille;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public boolean isArbreUtiliser() {
        return arbreUtiliser;
    }

    public void setArbreUtiliser(boolean arbreUtiliser) {
        this.arbreUtiliser = arbreUtiliser;
    }
    
//---------Méthode------------------------------------
    public String afficherArbre() {
       /*
        Cette méthode s'occupe de créer une String dépendant du joueur et de sa
        taille afin d'afficher l'arbre dans l'Arboretum. On retourne le caract.
        afin de l'afficher dans une autre méthode de l'arboretum.
        */
        String caractere = null;
        if ((this.taille == 0) && (this.joueur.getNumJoueur() == 1)) {
            caractere = "a  ";
        } else if ((this.taille == 1) && (this.joueur.getNumJoueur() == 1)) {
            caractere = "A  ";
        } else if ((this.taille == 2) && (this.joueur.getNumJoueur() == 1)) {
            caractere = "AA ";
        } else if ((this.taille == 3) && (this.joueur.getNumJoueur() == 1)) {
            caractere = "AAA ";
        } else if ((this.taille == 4) && (this.joueur.getNumJoueur() == 1)) {
            caractere = "x  ";
        } else if ((this.taille == 0) && (this.joueur.getNumJoueur() == 2)) {
            caractere = "b  ";
        } else if ((this.taille == 1) && (this.joueur.getNumJoueur() == 2)) {
            caractere = "B  ";
        } else if ((this.taille == 2) && (this.joueur.getNumJoueur() == 2)) {
            caractere = "BB ";
        } else if ((this.taille == 3) && (this.joueur.getNumJoueur() == 2)) {
            caractere = "BBB";
        } else {
            caractere = "x  ";
        }
        return caractere;
    }



}
