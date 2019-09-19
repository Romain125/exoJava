package exostructureconditionnelle;

public class MainIf {

    public static void main(String[] args) {
        int a = 13;
        int b = 3;
        int resultat = diviser(a, b);
    }

    private static int diviser(int a, int b) {
        if(b == 0){
            System.out.println("Ne peut pas diviser par zéro");
        }
        return a/b; //Ici une division par zéro va lancer une exception mais avec un message en premier lieu
    }

}
