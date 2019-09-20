package exocollection;

import java.util.Comparator;

public class ComparatorVoyageur implements Comparator<Voyageur> {

    @Override
    public int compare(Voyageur voyageur1, Voyageur voyageur2) {
        int comparaisonDeClasse = voyageur1.getClasse().compareTo(voyageur2.getClasse());
        if( comparaisonDeClasse==0 ){
            return voyageur1.getSiege().compareTo(voyageur2.getSiege());
        }else{ //le else ici n'est pas forcément nécessaire
            return comparaisonDeClasse;
        }
    }

}
