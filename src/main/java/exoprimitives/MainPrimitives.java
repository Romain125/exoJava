package exoprimitives;

public class MainPrimitives {

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        System.out.println("Valeur de A : "+a);
        System.out.println("Valeur de B : "+b);
        System.out.println("Permutation !");
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Valeur de A : "+a);
        System.out.println("Valeur de B : "+b);

        //Partie entière
        int a1 = 43;
        int b1 = 2;
        int reste = a1%b1;
        int temp1 = a1-reste;
        System.out.println("Partie entière de "+ a1 +"/" + b1 + " = "+temp1/b1);
        System.out.println(a1/b1);//fonctionne aussi car ce sont des entiers en java !

        //Divisible par (3 et 5) ou 7
        boolean divisiblePar3et5 = ((a1%3==0)&&(a1%5==0));
        boolean divisiblePar7 = (a1%7==0);
        System.out.println(a1 + "est-il divisible par 3 et 5 ou 7 ?"+(divisiblePar3et5||divisiblePar7));

        //Tableaux
        String[] tab = new String[3];
        tab[0] = "Riri";
        tab[1] = "Fifi";
        tab[2] = "Loulou";
        System.out.println(tab[0]+tab[1]+tab[2]);


        String[][][] tab2 = new String[2][2][2];
        tab2[0][0][0] = "1";
        tab2[0][0][1] = "1";
        tab2[0][1][0] = "1";
        tab2[0][1][1] = "1";
        //etc...


    }

}
