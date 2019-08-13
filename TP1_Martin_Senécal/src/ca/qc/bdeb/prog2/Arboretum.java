package ca.qc.bdeb.prog2;

import java.util.Scanner;

/*
Classe arboretum: Cette classe est en quelque sorte la classe mère du programme,
car c'est ici que se déroule le jeu. On appele des méthodes et on appele les autres 
classes. Arboretum est le jeux. 
 */
public class Arboretum {
//Déclaration de variable de ma classe Arboretum:

    private Arbre tabArbre[][] = new Arbre[5][6];
    private Joueur joueurA = new Joueur(1);
    private Joueur joueurB = new Joueur(2);

    public enum Soleil {
        NORD,
        EST,
        SUD,
        OUEST,
    }

    private Soleil soleil;
//---------------------------------------------------

    public Arboretum() { //Constructeur
    }
//--------------------Méthodes-----------------------

    public void demarrer() {
        /*  Cette méthode sert à partir le jeu. Elle est appelée à partir du main. On créée
    les arbres initiales ainsi qu'on dit c'est à qui le tour et à quel tour on est
    grâce aux deux boucles for imbriquées. Après les 12 tours (dont chacun d'entre 
    eux les deux joueurs ont joué), on affiche les résultats finals/gagnants.
         */

        tabArbre[1][0] = new Arbre(joueurA, 1);
        tabArbre[3][5] = new Arbre(joueurB, 1);
      

        for (int i = 0; i < 12; i++) {
            initialiserVal();
            int val = i % 4;
            switch (val) {
                case 0:
                    soleil = Soleil.values()[val];
                    ensoleillementNord();
                    break;
                case 1:
                    soleil = Soleil.values()[val];
                    ensoleillementEst();
                    break;
                case 2:
                    soleil = Soleil.values()[val];
                    ensoleillementSud();
                    break;
                case 3:
                    soleil = Soleil.values()[val];
                    ensoleillementOuest();
                    break;
            }

            for (int j = 1; j <= 2; j++) {
                System.out.print("\nTOUR: " + (i + 1) + " DU: ");
                if (j == 1) {
                    System.out.println("Joueur A:");
                    System.out.println("-------------------------------------------------------------------");
                    afficherMenu(joueurA);

                } else {
                    System.out.println("Joueur B:");
                    System.out.println("-------------------------------------------------------------------");
                    afficherMenu(joueurB);
                }

            }
        }
        pointsFinales();
        afficherResultats();

    }

    private void ensoleillementEst() {
        /*
        Cette méthode sert à calculer la chlorophylle de chaque joueur dans 
        l'arboretum lorsque le soleil se retrouve à l'Est. 
         */

        int arbreMax = 0;

        for (int i = 0; i < tabArbre.length; i++) {
            arbreMax = 0;
            for (int j = tabArbre[i].length; j >= 0; j--) {

                try {
                    if ((tabArbre[i][j].getTaille() > arbreMax) && (tabArbre[i][j].getTaille() >= 1)) {

                        arbreMax = tabArbre[i][j].getTaille();

                        if (joueurA == tabArbre[i][j].getJoueur()) {
                            joueurA.setChlorophylle(joueurA.getChlorophylle() + tabArbre[i][j].getTaille());

                        } else if (joueurB == tabArbre[i][j].getJoueur()) {
                            joueurB.setChlorophylle(joueurB.getChlorophylle() + tabArbre[i][j].getTaille());
                        }

                    }

                } catch (NullPointerException e) {

                } catch (ArrayIndexOutOfBoundsException e) {

                }

            }

        }
    }

    private void ensoleillementOuest() {
        /*
        Cette méthode sert à calculer la chlorophylle de chaque joueur dans 
        l'arboretum lorsque le soleil se retrouve à l'Ouest. 
         */

        int arbreMax = 0;
        for (int i = 0; i < tabArbre.length; i++) {
            arbreMax = 0;
            for (int j = 0; j < tabArbre[i].length; j++) {

                try {
                    if ((tabArbre[i][j].getTaille() > arbreMax) && (tabArbre[i][j].getTaille() >= 1)) {

                        arbreMax = tabArbre[i][j].getTaille();

                        if (joueurA == tabArbre[i][j].getJoueur()) {
                            joueurA.setChlorophylle(joueurA.getChlorophylle() + tabArbre[i][j].getTaille());

                        } else if (joueurB == tabArbre[i][j].getJoueur()) {
                            joueurB.setChlorophylle(joueurB.getChlorophylle() + tabArbre[i][j].getTaille());
                        }

                    }

                } catch (NullPointerException e) {

                } catch (ArrayIndexOutOfBoundsException e) {

                }

            }

        }
    }

    private void ensoleillementNord() {
        /*
        Cette méthode sert à calculer la chlorophylle de chaque joueur dans 
        l'arboretum lorsque le soleil se retrouve au Nord. 
         */

        int arbreMax;
        for (int i = 0; i < 6; i++) {
            arbreMax = 0;
            for (int j = 0; j < tabArbre.length; j++) {

                try {
                    if ((tabArbre[j][i].getTaille() > arbreMax) && (tabArbre[j][i].getTaille() >= 1)) {

                        arbreMax = tabArbre[j][i].getTaille();

                        if (joueurA == tabArbre[j][i].getJoueur()) {
                            joueurA.setChlorophylle(joueurA.getChlorophylle() + tabArbre[j][i].getTaille());

                        } else if (joueurB == tabArbre[j][i].getJoueur()) {
                            joueurB.setChlorophylle(joueurB.getChlorophylle() + tabArbre[j][i].getTaille());
                        }

                    }

                } catch (NullPointerException e) {

                } catch (ArrayIndexOutOfBoundsException e) {

                }

            }

        }
    }

    private void ensoleillementSud() {
        /*
        Cette méthode sert à calculer la chlorophylle de chaque joueur dans 
        l'arboretum lorsque le soleil se retrouve au Sud. 
         */

        int arbreMax;
        for (int i = 0; i < 6; i++) {
            arbreMax = 0;
            for (int j = tabArbre.length; j >= 0; j--) {

                try {
                    if ((tabArbre[j][i].getTaille() > arbreMax) && (tabArbre[j][i].getTaille() >= 1)) {

                        arbreMax = tabArbre[j][i].getTaille();

                        if (joueurA == tabArbre[j][i].getJoueur()) {
                            joueurA.setChlorophylle(joueurA.getChlorophylle() + tabArbre[j][i].getTaille());

                        } else if (joueurB == tabArbre[j][i].getJoueur()) {
                            joueurB.setChlorophylle(joueurB.getChlorophylle() + tabArbre[j][i].getTaille());
                        }

                    }

                } catch (NullPointerException e) {

                } catch (ArrayIndexOutOfBoundsException e) {

                }

            }

        }
    }

    private void afficherMenu(Joueur joueur) {

        /*
        Cette méthode est appelé à chaque fois qu'un joueur va jouer. Il a donc 
        des options et dépendant de l'option, on appele d'autres méthodes. Avant,
        il faut s'assurer que le joueur a assez d'argent et qu'il décide bien de 
        continuer la partie avant d'offrir les choix.
         */
        Scanner scanner = new Scanner(System.in);
        boolean rester = true;
        boolean prochainTour = false;
        int choix = 0;

        while (rester && (joueur.getChlorophylle() > 0 && prochainTour == false)) {
            afficherJeu();
            System.out.println("Votre pointage:" + joueur.getPoints());
            System.out.println("Vos points de chlorophylle:" + joueur.getChlorophylle()+"Θ");
            System.out.println("\n");
            System.out.println("***************Menu Principal****************");
            System.out.println("1) Semer une graine (coût de 1Θ)\n"
                    + "2) Faire pousser un arbre (coût variant entre 1Θ et 3Θ)\n"
                    + "3) Couper un arbre mature (coût de 4Θ)\n"
                    + "4) Terminer son tour\n"
                    + "5) Quitter le jeu");
            System.out.println("---------------------------------------------");
            System.out.print("Veuillez entrer votre choix > ");

            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Choix Erroné. Veuillez n'entrer que des nombres.\n\n");
            }

            switch (choix) {
                case 1:
                    semerGraine(joueur);

                    break;
                case 2:
                    pousserArbre(joueur);
                    break;
                case 3:
                    couperArbre(joueur);
                    break;
                case 4:
                    prochainTour = true;
                    break;
                case 5:
                    rester = quitterPartie(scanner);
                    break;
            }
        }

    }

    private boolean quitterPartie(Scanner scanner) {
        /*
        Cette méthode sert à quitter le programme si le joueur décide de quitter
        en plein milieu de la partie. En faisant cela, il n'a aucun gagnant. On 
        vérifie tout de même si c'est bien ça qui désire.
         */
        boolean rester = true;
        boolean continuer = true;
        int repQuitter = 0;

        while (continuer) {
            System.out.println("****************************************************************");
            System.out.println("\nÊtes-vous sûr de vouloir quitter la partie?- 1(oui) ou 2 (non)");

            try {
                repQuitter = Integer.parseInt(scanner.nextLine());
                System.out.println("--------------------");
                if (repQuitter == 1) {
                    System.out.println("Au Revoir! Voici vos résultats jusqu'à maintenant:");
                    System.out.println("--------------------\n");
                    afficherResultats();
                    System.exit(0);
                } else if (repQuitter == 2) {
                    rester = true;
                    continuer = false;
                } else {
                    rester = true;
                    continuer = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("\n!!!Choix Erroné. Veuillez n'entrer qu'un nombre entre 0 et 1!!!");
                System.out.println("-----------------------\n");
            }
        }

        return rester;
    }

    private void semerGraine(Joueur joueur) {
        /*
        Cette méthode (un des choix du jeux) sert à semer une graine du joueur.
        Pour planter, il faut vérifie si aux alentours, il y a un arbre du joueur.
        Il a donc beaucoup de conditions à vérifier et des exceptions à traiter.
         */

        int ligne = 0, colonne = 0;
        boolean continuer = true;
        boolean erreur = true;
        System.out.println("*****************************************");
        System.out.println("Semage de graine:");
        System.out.println("------------------------");

        ligne = (demanderPositionLigne()) - 1;
        colonne = (demanderPositionColonne()) - 1;
        System.out.println("\n\n");
        if (joueur.getChlorophylle() <= 0) {
            System.out.println("!!Manque de chlorophylles.");
        }

        try {
            if ((tabArbre[ligne][colonne] == null) && (joueur.getChlorophylle() > 0)) {

                for (int i = -2; i <= 2; i++) {
                    try {
                        if ((tabArbre[ligne][colonne + i] != null) && (tabArbre[ligne][colonne + i].getTaille() > 0) && ((tabArbre[ligne][colonne + i].getJoueur()) == joueur)) {

                            tabArbre[ligne][colonne] = new Arbre(joueur);
                            tabArbre[ligne][colonne].setArbreUtiliser(true);

                            erreur = false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if ((tabArbre[i + ligne][colonne] != null) && (tabArbre[i + ligne][colonne].getTaille() > 0) && (tabArbre[i + ligne][colonne].getJoueur() == joueur)) {

                            tabArbre[ligne][colonne] = new Arbre(joueur);
                            tabArbre[ligne][colonne].setArbreUtiliser(true);

                            erreur = false;

                        }

                    } catch (ArrayIndexOutOfBoundsException e) {

                    }

                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("!!Position Introuvable.");
        }
        if (erreur == true) {
            System.out.println("Impossible à semer ici.");
            System.out.println("-----------------------\n");
        } else {
            joueur.setChlorophylle(joueur.getChlorophylle() - 1);
        }

    }

    private int demanderPositionLigne() {
        /*
        Cette méthode sert à demander une ligne au joueur + vérifie si c'est 
        vraiment des nombres qui ont été entrés.
         */
        boolean condition1 = true;
        int ligne = 0;
        Scanner scanner = new Scanner(System.in);

        while (condition1) {
            try {
                System.out.print("Veuillez entrer le numéro de ligne>");
                ligne = Integer.parseInt(scanner.nextLine());
                condition1 = false;
            } catch (NumberFormatException e) {
                System.out.println("!!Veuillez n'entrer que des chiffres. SVP.\n");

            }
        }
        return ligne;
    }

    private int demanderPositionColonne() {
        /*
        Cette méthode sert à demander une colonne au joueur + vérifie si c'est 
        vraiment des nombres qui ont été entrés.
         */
        boolean condition2 = true;
        int colonne = 0;
        Scanner scanner = new Scanner(System.in);

        while (condition2) {
            try {
                System.out.print("Veuillez entrer le numéro de colonne>");
                colonne = Integer.parseInt(scanner.nextLine());
                condition2 = false;
            } catch (NumberFormatException e) {
                System.out.println("!!Veuillez n'entrer que des chiffres. SVP.\n");

            }
        }
        return colonne;
    }

    private void pousserArbre(Joueur joueur) {
        /*
        Cette méthode sert à faire pousser un arbre du joueur. Il faut vérifier
        certaines conditions: chlorophylles (assez de), bonne position et case
        non utiliser. Dépendant de la taille, le coût de la chlorophylle change.
         */
        int ligne = 0, colonne = 0;
        boolean erreur = true;
        System.out.println("***********************************");
        System.out.println("Pousser un arbre:");

        ligne = (demanderPositionLigne()) - 1;
        colonne = (demanderPositionColonne()) - 1;
        System.out.println("-----------------\n\n");
        try {
            if ((tabArbre[ligne][colonne] != null) && (tabArbre[ligne][colonne].getJoueur() == joueur) && (tabArbre[ligne][colonne].getTaille() <= 2)) {
                if (tabArbre[ligne][colonne].isArbreUtiliser() == false) {
                    if ((tabArbre[ligne][colonne].getTaille() == 0)) {
                        if (joueur.getChlorophylle() >= 1) {
                            erreur = false;
                            joueur.setChlorophylle(joueur.getChlorophylle() - 1);
                        } else {
                            System.out.println("!!Manque de chlorophylles..");
                        }
                    } else if (tabArbre[ligne][colonne].getTaille() == 1) {

                        if (joueur.getChlorophylle() >= 2) {
                            erreur = false;
                            joueur.setChlorophylle(joueur.getChlorophylle() - 2);
                        } else {
                            System.out.println("!!Manque de chlorophylles..");
                        }
                    } else if ((tabArbre[ligne][colonne].getTaille() == 2)) {
                        if (joueur.getChlorophylle() >= 3) {
                            erreur = false;
                            joueur.setChlorophylle(joueur.getChlorophylle() - 3);
                        } else {
                            System.out.println("!!Manque de chlorophylles..");
                        }
                    }
                } else {
                    System.out.println("!!Attendre le prochain tour pour planter ici.");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("!!Position Introuvable.");
        }
        if (erreur) {
            System.out.println("Impossible de pousser un arbre ici.");
            System.out.println("***********************************\n");
        } else {
            tabArbre[ligne][colonne].setTaille(tabArbre[ligne][colonne].getTaille() + 1);
            tabArbre[ligne][colonne].setArbreUtiliser(true);

        }

    }

    private void couperArbre(Joueur joueur) {
        /*
        Cette méthode demande au joueur quel arbre il veut couper. On vérifie si
        c'est la bonne taille-bon joueur-assez d'argent et si l'arbre est dispo.
         */
        int ligne = 0, colonne = 0;
        boolean erreur = true;
        System.out.println("********************************************");
        System.out.println("Couper un arbre mature de taille 3:\n");

        ligne = (demanderPositionLigne()) - 1;
        colonne = (demanderPositionColonne()) - 1;
        System.out.println("---------------------\n\n");
        if (joueur.getChlorophylle() <= 3) {
            System.out.println("!!Manque de chlorophylles.");
        }
        try {
            if ((tabArbre[ligne][colonne] != null) && (tabArbre[ligne][colonne].getJoueur() == joueur) && (tabArbre[ligne][colonne].getTaille() == 3) && (joueur.getChlorophylle() >= 4)) {
                if (tabArbre[ligne][colonne].isArbreUtiliser() == false) {
                    tabArbre[ligne][colonne].setTaille(-1);
                    joueur.setChlorophylle(joueur.getChlorophylle() - 4);
                    tabArbre[ligne][colonne].setArbreUtiliser(true);
                    erreur = false;

                    if ((ligne == 0) || (ligne == 4) || (colonne == 0) || (colonne == 5)) {
                        joueur.setPoints(joueur.getPoints() + 5);
                    } else if (((ligne == 1) && (colonne >= 1 || colonne <= 4)) || ((ligne == 3) && (colonne >= 1 || colonne <= 4)) || ((ligne == 2) && (colonne == 1 || colonne == 4))) {
                        joueur.setPoints(joueur.getPoints() + 7);
                    } else {
                        joueur.setPoints(joueur.getPoints() + 9);

                    }
                } else {
                    System.out.println("!!Terre non-fertile: Attendre le prochain tour...");
                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("!!Position Introuvable.");
        }

        if (erreur == true) {
            System.out.println("Impossible à couper ici.");
            System.out.println("*********************************\n");
        }

    }

    private void afficherJeu() {
        /*
        Cette méthode sert à afficher la matrice arboretum avec la position du 
        Soleil!! Dépendant du nombre de tour, on sait son orientation avec l'enum.
        Traiter les exceptions si à une case c'est nulle (pas d'arbre).
         */
        System.out.println("\n");
        if (soleil == soleil.NORD) {
            System.out.println("\t\t\t\t\t\t☼");
        }
        System.out.println("\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6");
        System.out.println("\t-------------------------------------------------------------------------------------------------");

        for (int i = 0; i < tabArbre.length; i++) {
            if (i == 2) {
                if (soleil == soleil.OUEST) {
                    System.out.print("☼");
                }
            }
            System.out.print("\t" + (i + 1) + "-|");

            for (int j = 0; j < tabArbre[i].length; j++) {
                try {
                    System.out.print("\t" + tabArbre[i][j].afficherArbre() + "\t|");
                } catch (NullPointerException e) {
                    System.out.print("\t\t|");
                }

                if (i == 2 && j == 5) {
                    if (soleil == soleil.EST) {
                        System.out.print("    ☼");
                    }
                }
            }
            System.out.println(" ");
        }
        if (soleil == soleil.SUD) {
            System.out.println("\t\t\t\t\t\t\t☼");
        }
        System.out.println("\n");
    }

    private void initialiserVal() {
        /*
        Cette méthode initialise les valeurs de la matrice lorsqu'au prochain tour,
        on passe de l'arbre coupé à une nouvelle case vierge ainsi qu'au prochain tour,
        on peut refaire pousser un arbre.
         */
        for (int i = 0; i < tabArbre.length; i++) {
            for (int j = 0; j < tabArbre[i].length; j++) {
                try {
                    if (tabArbre[i][j].isArbreUtiliser() == true) {
                        tabArbre[i][j].setArbreUtiliser(false);
                    }
                } catch (NullPointerException e) {

                }
                try {
                    if (tabArbre[i][j].getTaille() == -1) {
                        tabArbre[i][j] = null;
                    }
                } catch (NullPointerException e) {

                }
            }
        }
    }

    private void pointsFinales() {
        /*
        Cette méthode calcule les points finales du jeux: toutes les arbres de 
        l'arboretum restant valent 1 points pour le joueur en question.
         */
        for (int i = 0; i < tabArbre.length; i++) {
            for (int j = 0; j < tabArbre[i].length; j++) {
                try {
                    if ((tabArbre[i][j].getTaille() >= 1 && tabArbre[i][j].getTaille() <= 3) && tabArbre[i][j].getJoueur() == joueurA) {
                        joueurA.setPoints(joueurA.getPoints() + 1);
                    } else if ((tabArbre[i][j].getTaille() >= 1 && tabArbre[i][j].getTaille() <= 3) && tabArbre[i][j].getJoueur() == joueurB) {
                        joueurB.setPoints(joueurB.getPoints() + 1);
                    }
                } catch (NullPointerException e) {

                }

            }
        }

    }

    private void afficherResultats() {
        /*
        Cette méthode donne le gagnants du jeu ainsi que les statistques finales
        des joueurs.
         */
        System.out.println("***************************************************");
        if (joueurA.getPoints() > joueurB.getPoints()) {
            System.out.println("*Le gagnant est le joueur A!!                    *");
        } else if (joueurB.getPoints() > joueurA.getPoints()) {
            System.out.println("*Le gagnant est le joueur B!!                    *");
        } else {
            System.out.println("*Égalité des deux joueurs!!!                      *");
        }
        System.out.println("*Les points du joueur A:" + joueurA.getPoints() + "                         *");
        System.out.println("*Les points du joueur B:" + joueurB.getPoints() + "                         *");
        System.out.println("*Chlorophylle de joueur A:" + joueurA.getChlorophylle() + "                       *");
        System.out.println("*Chlorophylle de joueur B:" + joueurB.getChlorophylle() + "                       *");
        System.out.println("***************************************************");

    }
}
