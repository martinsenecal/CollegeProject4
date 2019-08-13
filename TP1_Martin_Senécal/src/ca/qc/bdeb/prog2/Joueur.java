/*
Classe joueur: Il y a deux joueurs. Chacun de ses joueurs possèdent un numéro,
un pointage de chlorophylle et un pointage de points. On appele cette classe 
surtout dans l'arboretum. Toutes les infos du joueur sont contenu ici.
 */
package ca.qc.bdeb.prog2;

public class Joueur {
    //Déclaration de variable de ma classe Joueur:

    private int numJoueur;
    private int chlorophylle = 0;
    private int points = 0;

    public Joueur() {
    }

    
//---------Constructeur-------------------
    public Joueur(int numJoueur) {
        this.numJoueur = numJoueur;
    }
//---------Méthode (getter-setter)-------------

    public int getNumJoueur() {
        return numJoueur;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public int getChlorophylle() {
        return chlorophylle;
    }

    public void setChlorophylle(int chlorophylle) {
        this.chlorophylle = chlorophylle;
    }

}
