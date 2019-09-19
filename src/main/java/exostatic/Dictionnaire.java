package exostatic;

public class Dictionnaire {

    public static final String name = "Larousse";

    private static final Dictionnaire DICO = new Dictionnaire();

    private Dictionnaire() {}

    public static Dictionnaire getInstance(){
        return DICO;
    }

}
