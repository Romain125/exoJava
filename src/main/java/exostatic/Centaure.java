package exostatic;

public class Centaure {

    public static final int NOMBRE_PATTES = 4;
    public static final int NOMBRE_BRAS = 2;

    private int nombrePattesActuel = 4;
    private int nombreBrasActuel = 2;

    public static int population = 0;

    public Centaure() {
        population++;
    }

    public boolean manquetilunepatteamoncentaure(){
        return nombrePattesActuel!=NOMBRE_PATTES;
    }

}
