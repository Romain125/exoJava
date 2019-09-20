package exocollection;

import java.util.*;

public class MainCollection {

    public static void main(String[] args) {
        List<String> maSuperListeDeString = new ArrayList<>();
        maSuperListeDeString.add("Riri");
        maSuperListeDeString.add("Fifi");
        maSuperListeDeString.add("Loulou");

        afficherListe(maSuperListeDeString);

        Collections.sort(maSuperListeDeString);
        afficherListe(maSuperListeDeString);

        TreeSet<String> collectionTriee = new TreeSet<>();
        collectionTriee.add("3");
        collectionTriee.add("9");
        collectionTriee.add("7");
        collectionTriee.add("1");
        //Ici, grâce au polymorphisme, je peux utiliser la même méthode !
        afficherListe(collectionTriee);

        //Un tableau à 2 dimensions est un tableau de tableau
        List<List<String>> liste2Dimensions = new ArrayList<>();
        List<String> colonne1 = new ArrayList<>();
        colonne1.add("element 0, 0");
        liste2Dimensions.add(colonne1);
        System.out.println(liste2Dimensions.get(0).get(0));

        //Exercice 7
        PriorityQueue<Voyageur> fileDAttente = new PriorityQueue<>(new ComparatorVoyageur());

        fileDAttente.add(new Voyageur(123, "3B", "DUPONT", Classe.PREMIERE));
        fileDAttente.add(new Voyageur(234, "5B", "MARTIN", Classe.ECO));
        fileDAttente.add(new Voyageur(345, "9C", "JOEL", Classe.BUSINESS));
        fileDAttente.add(new Voyageur(456, "1A", "GOMEZ", Classe.PREMIERE));
        fileDAttente.add(new Voyageur(567, "8B", "PIWCOSCOWITC", Classe.ECO));

        System.out.println(fileDAttente);
        Voyageur premierAppelle = fileDAttente.poll();
        System.out.println(premierAppelle); //C'est bien la personne en première avec le premier siège qui est appellé en premier

    }

    private static void afficherListe(Collection<String> maSuperListeDeString) {
        for (String element : maSuperListeDeString) {
            System.out.print(element+" ");
        }
        System.out.println();

        //Ici, System.out.println() fonctionne car l'arraylist implémente la méthode toString
        System.out.println(maSuperListeDeString);

        //On peut aussi utiliser
        String representation = String.join(", ", maSuperListeDeString);
        System.out.println(representation);
    }

}
