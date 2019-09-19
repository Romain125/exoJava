package exoboucle;

public class MainBoucle {

    public static void main(String[] args) {

//        boucleInfinie();

        int limite = 10;
        int factorielle = factorielle(limite);
        System.out.println(factorielle);

        dessinerRectangle(3,5);

        int[] array = {0,1,2,3};
        int[] arrayAvecUneCaseEnPlus = addToArray(array, 4);
        for (int i = 0; i < arrayAvecUneCaseEnPlus.length; i++) {
            System.out.print(arrayAvecUneCaseEnPlus[i]);
        }
        System.out.println();
    }

    private static int[] addToArray(int[] tableauEntree, int ajout) {
        int[] tableauResultat = new int[tableauEntree.length+1];
        for (int i = 0; i < tableauEntree.length; i++) {
            tableauResultat[i] = tableauEntree[i];
        }
        tableauResultat[tableauResultat.length-1] = ajout;
        return tableauResultat;
    }

    private static int factorielle(int limite) {
        int resultat = 1;
        for (int i = 2; i < limite; i++) {
            resultat = resultat*i;
        }
        return resultat;
    }

    private static void boucleInfinie(){
        while(true){}
    }

    private static void dessinerRectangle(int longueur, int largeur) {
        String ligne = "";

        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                ligne += "O";
            }
            System.out.println(ligne);
            ligne = "";
        }
    }

}
