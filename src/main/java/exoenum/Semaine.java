package exoenum;

public enum Semaine {

    LUNDI(true, ":'("),
    MARDI(true, ":("),
    MERCREDI(true, ":/"),
    JEUDI(true, ":|"),
    VENDREDI(true, ":)") ,
    SAMEDI(false, ":D"),
    DIMANCHE(false, "8D");

    private boolean onBosse;
    private String humeur;

    Semaine(boolean onBosse, String humeur) {
        this.onBosse = onBosse;
        this.humeur = humeur;
    }

    public boolean isOnBosse() {
        return onBosse;
    }

    public String getHumeur() {
        return humeur;
    }

    @Override
    public String toString() {
        return "Semaine{" +
                "jour=" + name() +
                ", onBosse=" + onBosse +
                ", humeur='" + humeur + '\'' +
                '}';
    }
}
