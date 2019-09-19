package exoenum;

public class MainEnum {
    public static void main(String[] args) {
        Semaine[] semaine = Semaine.values();

        for (int i = 0; i < semaine.length; i++) {
            System.out.println(semaine[i]/*.toString()*/);
        }

        System.out.println(Semaine.JEUDI.compareTo(Semaine.DIMANCHE));

    }
}
