package exoStreams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStreams {

    public static void main(String[] args) {
        System.out.println("=====================Exo1======================");
        exo1();
        System.out.println("=====================Exo2======================");
        exo2();
        System.out.println("=====================Exo3======================");
        exo3();
        System.out.println("=====================Exo4======================");
        exo4();
        System.out.println("=====================Exo5======================");
        exo5();
        System.out.println("=====================Exo6======================");
        exo6();
        System.out.println("=====================Exo7======================");
        exo7();
        System.out.println("=====================Exo8 & 9======================");
        exo8();
        System.out.println("=====================Exo10======================");
        exo10();
    }

    /*
        Exercice 1 : Déclarer une liste de String, en extraire un stream et l'afficher
     */
    private static void exo1() {
        List<String> list = new ArrayList<>();
        list.add("1!");
        list.add("2!");
        list.add("3!");
        list.add("4!");
        list.add("5!");
        list.stream().forEach(element -> System.out.println(element));
//        list.forEach(str -> System.out.println(str)); //Ici équivalent, le forEach sur une liste sous-entend le passage par un stream
//        list.forEach(System.out::println); //On peut également remplacer la lambda par une méthod-référence
    }

    /*
        Exercice 2 : Concaténer le stream d'une liste avec le stream d'un tableau de String
     */
    private static void exo2() {
        List<String> list = new ArrayList<>();
        list.add("1!");
        list.add("2!");
        list.add("3!");
        list.add("4!");
        list.add("5!");
        String[] array = new String[3];
        array[0] = "array[0]";
        array[1] = "array[1]";
        array[2] = "array[2]";
        Stream<String> streamList = list.stream();
        //Il n'y a pas d'API sur le tableau pour en extraire le String, il faut apsser par la classe utilitaire Arrays
        Stream<String> streamArray = Arrays.stream(array);
        //Il n'y a pas d'API non plus sur le Stream pour concaténer deux Streams.
        // Il faut également passer par la classe utilitaire Streams
        Stream.concat(streamList, streamArray).forEach(string -> System.out.println(string));
    }

    /*
    Exercice 3 : Créer un Stream de double générés aléatoirement par la méthode Math.random(), puis les afficher.
     */
    private static void exo3() {
        //La ligne suivante fonctionne ! Elle génère un Stream potentiellement infini, malgré tout, cela ne plante pas...pourquoi?
        //Les lambdas sont dits "lazy", tant qu'on ne cherche pas à les lire, ils ne s'exécutent pas
        Stream<Double> randomStream = Stream.generate(() -> Math.random());

        //Par contre...si on cherche à le lire...
        // randomStream.forEach(doubleVar -> System.out.println(doubleVar)); //boucle infinie !

        //Pour éviter ça, il faut utiliser la méthode limit(x)
        randomStream.limit(1000).forEach(string -> System.out.println(string));
    }


    /*
    Exercice4 : Prendre en entrée un tableau d’entier (+/-) et faire
    A) la somme de tous les nombres
    B) la moyenne des nombres positifs uniquement,

     */
    private static void exo4() {

        //Un peu de zèle pour initialiser un tableau de 100 éléments aléatoires
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*200)-100;
        }


        // La méthode stream de la classe Arrays renvoie un IntStream.
        // C'est un une extension de Stream sur laquelle on retrouve des opérations supplémentaires relatives aux nombres (telles que sum(), min(), max() average() etc...)
        int sum = Arrays.stream(array)
                .sum();
        System.out.println(sum);

        // On utilise la méthode filter pour ne conserver que les éléments positifs.
        // Filter prend en paramètre un prédicat un prédicat prend un élément en paramètre et renvoie un booléen (true = on garde, false = on garde pas)
        OptionalDouble average = Arrays.stream(array)
                .filter(element -> element > 0)
                .average();
        System.out.println(average);

        // Average renvoie un OptionalDouble. Logique, car si le Stream ne contenait pas d'élément, la formule aurait été 0/0
        // Pour transformer le Optional en double, on utilise la méthode orElseGet() qui renvoie 0 au cas où le Optional est vide
        System.out.println(average.orElseGet(() -> 0));

    }

    /*
    Exercice 5 : Transformer une liste de String représentant des entiers en liste d'entiers, puis trouver le max
     */
    private static void exo5() {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("-2");
        list.add("3");
        list.add("-4");
        list.add("5");

        // Ici il faut transformer le stream en IntStream pour pouvoir utiliser la méthode max()
        OptionalInt max = list.stream()
                .mapToInt(string -> Integer.valueOf(string))
                .max();

        // On peut également ne PAS transformer la Stream en IntStream. A ce moment là, il faut conner la méthode de comparaison au max
        // Normal, il ne sait pas comparer les objets ! Il faut donc lui dire comment
        Optional<Integer> max2 = list
                .stream()
                .map(string -> Integer.valueOf(string))
                .max((a,b) -> a.compareTo(b));

        System.out.println(max);
        System.out.println(max2);
    }

    /*
       Exercice 6 : Vérifier qu'un mot contient un caractère présent dans un tableau
    */
    private static void exo6() {
        int[] characters = {'c', 'a', 'b'};
        String word = "HakunaMatata";

        // On utilise la méthode mapToObj() pour transformer enStream d'objet,
        // puis anyMatch() qui s'arrête à la première condition validée trouvée.
        // NB : Ici, on met des blocs d'instruction dans les lambdas, il faut donc mettre des accolades et des return
        boolean isPresent = Arrays.stream(characters)
                .mapToObj(character -> {
                    System.out.println("Je rentre dans le mapToObj avec le paramètre : "+character);
                    return String.valueOf((char)character);
                })
                .anyMatch( character -> {
                    System.out.println("Je rentre dans le anyMatch avec le paramètre : "+character);
                    return word.contains(character);
                });

        System.out.println(isPresent);
    }


    /*
        Exercice 7 : Transformez un Set de String en List de String
         - Ne contenant pas les chaîne qui commencent par ‘P’
         - Tout en minuscule
         - Triée
     */
    private static void exo7() {
        Set<String> set = new HashSet<>();
        set.add("zuLU");
        set.add("TitI");
        set.add("PaPa");
        set.add("LouLou");

        // La méthode pour transformer un Stream en List est .collect(Collectors.toList())
        List<String> list = set.stream()
                .filter(element -> !element.startsWith("P"))
                .map(element -> element.toLowerCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println(list);
    }

    /*
        Exercice 8 : Générer une liste de String (via un Stream) de la forme : String.format("firstName%s;name%s;%s;city%s", i, i, i, i)
        - Transformer cette liste de String en une liste de Person en utilisant le constructeur Person(firstName,Name,Age)
     */
    private static void exo8(){
        String personneFichierPlat = "firstName%s;name%s;%s;city%s";
        List<String> listPersonStrings = Stream.of(
                String.format(personneFichierPlat, "Bastille", "LeChat", "15", "Paris"),
                String.format(personneFichierPlat, "Waterloo", "TheCat", "16", "Londres"),
                String.format(personneFichierPlat, "Dusseldorf", "DieKatze", "18", "Berlin"),
                String.format(personneFichierPlat, "Grenada", "ElGato", "21", "Madrid")
        ).collect(Collectors.toList());

        // Ici j'externalise la fonction pour plus de lisibilité pour la suite
        // NB : Person est défini en dessous de cette classe
        Function<String, Person> stringToPerson = string -> {
            String[] champs = string.split(";");
            String prenom = champs[0].substring(9);
            String nom = champs[1].substring(4);
            int age = Integer.parseInt(champs[2]);
            return new Person(nom, prenom, age);
        };

        //On tronsforme notre liste de String en liste de personnes
        List<Person> toutesPersonnes = listPersonStrings.stream()
                .map(stringToPerson)
                .collect(Collectors.toList());
        System.out.println(toutesPersonnes);

        //Exercice 9-1 : Extraire une liste de personnes dont l'age est > 18 ans
        List<Person> personnesMajeures = listPersonStrings.stream()
                .map(stringToPerson)
                .filter(personne -> personne.getAge() > 18)
                .collect(Collectors.toList());
        System.out.println(personnesMajeures);

        //Exercice 9-2 : Transformer le stream en map dont la clé est le nom de la personne
        Map<String, Person> mapPersonnes = listPersonStrings.stream()
                .map(stringToPerson)
                .collect(Collectors.toMap(personne -> personne.getNom(), personne -> personne));
        System.out.println(personnesMajeures);

        //Exercice 9-3 : Faire les statistiques sur les âges des personnes (somme, max, etc...)
        IntSummaryStatistics stats = listPersonStrings.stream()
                .map(stringToPerson)
                .mapToInt(personne -> personne.getAge())
                .summaryStatistics();
        System.out.println(stats);

    }

    /*
        Exercice 10 : Transformez une liste de liste de String en un seul String contenant toutes les valeurs séparés par des "et"
     */
    private static void exo10() {
        List<String> list = new ArrayList<>();
        list.add("Miaou!");
        list.add("Waf!");
        List<String> list2 = new ArrayList<>();
        list2.add("Cuicui!");
        list2.add("PiouPiou!");
        list2.add("MEUUUUUH!");

        List<List<String>> listOfList = new ArrayList<>();
        listOfList.add(list);
        listOfList.add(list2);

        // L'opération flatMap cherche à transformer un élément en Stream. Le Stream résultat sera la concaténation de tous ces streams
        // On utilise .collect(Collectors.joining()); pour joindre tous les Strings avec le paramètre " et " qui servira de délimiteur.
        String collect = listOfList.stream()
                .flatMap(element -> element.stream())
                .collect(Collectors.joining(" et "));
        System.out.println(collect);
    }


}

class Person{
    private final String nom;
    private final String prenom;
    private final int age;

    public Person(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                '}';
    }
}












