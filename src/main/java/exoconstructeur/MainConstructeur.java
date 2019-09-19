package exoconstructeur;

public class MainConstructeur {
    public static void main(String[] args) {
        Enfant charlotte = new Enfant("DUPOND", "Charlotte");
        Enfant olivier = new Enfant("MARTIN", "Olivier");
        charlotte.presenter();
        olivier.presenter();

        charlotte.feterAnniversaire();
        charlotte.feterAnniversaire();
        charlotte.feterAnniversaire();
        olivier.feterAnniversaire();
        olivier.feterAnniversaire();
        olivier.feterAnniversaire();
        olivier.feterAnniversaire();
        charlotte.presenter();
        olivier.presenter();

        charlotte.jouerAuBallon(olivier);

        System.out.println(charlotte.isAmoureux());
        System.out.println(olivier.isAmoureux());
        charlotte.tomberAmoureux(olivier);
        olivier.tomberAmoureux(charlotte);
        System.out.println(charlotte.isAmoureux());
        System.out.println(olivier.isAmoureux());
    }
}
