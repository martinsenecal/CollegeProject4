package ca.qc.bdeb.prog2;

import static java.lang.Boolean.parseBoolean;
import java.util.Scanner;

public class TP1 {

    /**
     * TP1 du cours #2 d'Info Martin Senécal
     * Mon analyse:
     * Après de multiples tests, mon programme n'a aucun bug à ce que je vois.
     * J'ai toutes fais mes vérifications afin d'éviter d'avoir des erreurs et
     * celles-ci sont toujours indiqués à l'utilisateur. C'est sûr que mon prog.
     * n'est pas parfait. Il y a encore place à l'optimiser ainsi qu'éviter des
     * répétitions. Cependant, je crois que mes classes sont bien, je les ai bien
     * utiliser afin d'éviter d'avoir trop de variables déclarés. De plus, le fait
     * d'avoir utiliser un enum, m'a beaucoup aidé pour le soleil. Mon affichage est bien, 
     * j'ai tenté de la rendre la plus claire possible. Mon point à améliorer serait 
     * d'avoir des conditions moins grandes.
     * 
     * Bonne correction et bon jeu! (essayez de ne pas vous endormir en jouant au jeu pour la 50e fois..)
     * Martin Senécal :)
     */
    public static void main(String[] args) {
        /*
        Ici, on créé l'arboretum et on lance le jeux en appelant démarrer.
        Lorsque la partie termine, le joueur a le choix de recommencer une 
        nouvelle partie.
        */ 
        //Déclaration de variable/Scanner:
        boolean continuer = true;
        boolean rep = true;
        Scanner scanner = new Scanner(System.in);
        
        //---------------------------------------
        
        while (continuer) {
            Arboretum arboretum = new Arboretum();

            arboretum.demarrer();
            System.out.println("******************************************************************");
            System.out.println("\nVoulez-vous rejouer une nouvelle partie? true(oui) - false (non)");

            rep = parseBoolean(scanner.nextLine());
            System.out.println("******************************************************************");
            if (rep) {
                continuer = true;

            } else {

                continuer = false;

            }

        }
    }
}
