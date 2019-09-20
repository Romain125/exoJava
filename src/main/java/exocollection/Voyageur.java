package exocollection;

public class Voyageur {

    private int numero;
    private String siege;
    private String nom;
    private Classe classe;

    public Voyageur(int numero, String siege, String nom, Classe classe) {
        this.numero = numero;
        this.siege = siege;
        this.nom = nom;
        this.classe = classe;
    }

    public String getSiege() {
        return siege;
    }

    public Classe getClasse() {
        return classe;
    }

    @Override
    public String toString() {
        return "Voyageur {" +
                "numero=" + numero +
                ", siege='" + siege + '\'' +
                ", nom='" + nom + '\'' +
                ", classe=" + classe +
                '}';
    }
}
