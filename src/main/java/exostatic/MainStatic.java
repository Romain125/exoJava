package exostatic;

public class MainStatic {
    public static void main(String[] args) {
        System.out.println(Centaure.population);
        Centaure centaure = new Centaure();
        Centaure centaure1 = new Centaure();
        Centaure centaure2 = new Centaure();
        Centaure centaure3 = new Centaure();
        Centaure centaure4 = new Centaure();
        Centaure c1;
        Centaure c2;
        Centaure c3 = null;
        System.out.println(Centaure.population);

        Dictionnaire monDico = Dictionnaire.getInstance();
        System.out.println(monDico.name);

    }
}














