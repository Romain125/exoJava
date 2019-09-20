package exomorpion;

import java.util.Scanner;

public class MainMorpion {

    public static void main(String[] args) {

        char[][] plateau = new char[3][3];

        //Exercice 1
        initialiserPlateau(plateau);

        //Exercice 2
        afficherPlateau(plateau);

        //Exercice 3
        boolean unJoueurAGagne = unJoueurAGagne(plateau);

        boolean auJoueur1 = true;
        String nom = "";
        char symbole;
        //Exercice 4
        while(!unJoueurAGagne(plateau)){
            //Exercice 5
            if(auJoueur1){
                nom = "Joueur 1";
                symbole = 'X';
            }else{
                nom = "Joueur 2";
                symbole = 'O';
            }

            System.out.println("Au tour de : "+nom);

            //Exercice 6
            tourDeJeu(plateau, symbole);

            //On change de joueur (Exercice 5)
            auJoueur1 = !auJoueur1;
        }
        afficherPlateau(plateau);
        System.out.println("Fin de la partie, un des deux joueurs a un ligne entière");
        System.out.println(nom+ " a gagné !");
    }

    private static void tourDeJeu(char[][] plateau, char symbole) {
        //Ici, on pourrait avoir du code plus complexe :
        //  - Vérifier qu'un utilisateur a bien saisi une entrée valide
        //  - Entrer directement le couple ligne/colonne
        //  - Vérifier qu'un utilisateur n'a pas joué sur une case déjà occupée
        //etc...

        Scanner scanner = new Scanner(System.in);
        afficherPlateau(plateau);
        System.out.println("Entrez la ligne");
        int colonne = scanner.next().charAt(0);
        System.out.println("Entrez la colonne");
        int ligne = scanner.nextInt();
        plateau[colonne-65][ligne-1] = symbole;
    }

    //Un tour de jeu sans l'exercice bonus
    private static void tourDeJeuSimple(char[][] plateau, char symbole) {
        Scanner scanner = new Scanner(System.in);
        afficherPlateau(plateau);
        System.out.println("Entrez la ligne");
        int colonne = scanner.nextInt();
        System.out.println("Entrez la colonne");
        int ligne = scanner.nextInt();
        plateau[colonne][ligne] = symbole;
    }

    private static boolean unJoueurAGagne(char[][] plateau) {
        boolean unJoueurAGagne = false;
        //Même ligne
        unJoueurAGagne |= (plateau[0][0] == plateau[0][1]) && (plateau[0][0] == plateau[0][2] ) && (plateau[0][0] != '¤');
        unJoueurAGagne |= (plateau[1][0] == plateau[1][1]) && (plateau[1][0] == plateau[1][2] ) && (plateau[1][0] != '¤');
        unJoueurAGagne |= (plateau[2][0] == plateau[2][1]) && (plateau[2][0] == plateau[2][2] ) && (plateau[2][0] != '¤');
        //Même colonne
        unJoueurAGagne |= (plateau[0][0] == plateau[1][0]) && (plateau[0][0] == plateau[2][0] ) && (plateau[0][0] != '¤');
        unJoueurAGagne |= (plateau[0][1] == plateau[1][1]) && (plateau[0][1] == plateau[2][1] ) && (plateau[0][1] != '¤');
        unJoueurAGagne |= (plateau[0][2] == plateau[1][2]) && (plateau[0][2] == plateau[2][2] ) && (plateau[0][2] != '¤');
        //Diagonales
        unJoueurAGagne |= (plateau[0][0] == plateau[1][1]) && (plateau[0][0] == plateau[2][2] ) && (plateau[0][0] != '¤');
        unJoueurAGagne |= (plateau[2][0] == plateau[1][1]) && (plateau[2][0] == plateau[0][2] ) && (plateau[2][0] != '¤');

        return unJoueurAGagne;
    }


    private static void afficherPlateau(char[][] plateau) {
        System.out.println("  1 2 3");
        for (int i = 0; i < plateau.length; i++) {
            char numeroLigne = (char) (65+i);
            System.out.print(numeroLigne+"|");
            for (int j = 0; j < plateau[i].length; j++) {
                System.out.print(plateau[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    private static void initialiserPlateau(char[][] plateau) {
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                plateau[i][j] = '¤';
            }
        }
    }

}
