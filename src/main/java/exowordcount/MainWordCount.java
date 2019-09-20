package exowordcount;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class MainWordCount {

    public static void main(String[] args) throws IOException {
        Path fichier = Paths.get("src/main/java/exowordcount/fichier.txt");
        List<String> lignes = Files.readAllLines(fichier, Charset.forName("CP1252"));

        Map<String, Integer> occurences = new HashMap<>();

        for (String ligne : lignes) {
            ligne = ligne.replaceAll("\\.|-|,|'|\\(|\\)", " ");
            String[] mots = ligne.split(" ");
            for (String mot : mots) {
                mot = mot.toLowerCase();
                if(!mot.isEmpty()){
                    int nombreOccurence = occurences.getOrDefault(mot, 0)+1;
                    occurences.put(mot, nombreOccurence);
                }
            }
        }

        System.out.println(occurences);

        Path fichierResultat = Paths.get("src/main/java/exowordcount/resultat.txt");
        ArrayList<String> lignesAEcrire = new ArrayList<>();
        for (Map.Entry<String, Integer> entreeOccurence : occurences.entrySet()) {
            lignesAEcrire.add(entreeOccurence.getKey()+ " : "+entreeOccurence.getValue());
        }
        Files.write(fichierResultat, lignesAEcrire, Charset.forName("CP1252"));

        int total = 0;
        for (Integer value : occurences.values()) {
            total += value;
        }
        //On peut utiliser une méthode de la classe collections pour créer un liste à un seul élément
        Set<String> ligneTotal = Collections.singleton("Nombre total de mots : "+ total);
        Files.write(fichierResultat, ligneTotal, Charset.forName("CP1252"), StandardOpenOption.APPEND);

        //Exercice 5
        ArrayList<String> motsLesPlusPresents = new ArrayList<>();
        int max = 0;
        for (Map.Entry<String, Integer> motsPresents : occurences.entrySet()) {
            if(motsPresents.getValue()>max){
                max = motsPresents.getValue();
                motsLesPlusPresents.clear();
                motsLesPlusPresents.add(motsPresents.getKey());
            }else if(motsPresents.getValue()==max){
                motsLesPlusPresents.add(motsPresents.getKey());
            }
        }
        System.out.println(motsLesPlusPresents);
    }

}
