package exomethodes;

public class MainMethodes {
    public static void main(String[] args) {
        int a = 12;
        int b = 56;
        int sum = additioner2entiers(a, b);
        System.out.println(sum);

        int partieEntiere = partieEntiere(58,7);
        System.out.println(partieEntiere);

    }

    private static int partieEntiere(int divise, int diviseur) {
        int reste = divise%diviseur;
        int temp = divise-reste;
        int resultat = temp/diviseur;
        System.out.println("Partie entière de "+ divise +"/" + diviseur + " = "+resultat);
        return resultat;
    }

    static int additioner2entiers(int premierEntier, int secondEntier){
        return premierEntier+secondEntier;
    }
}
