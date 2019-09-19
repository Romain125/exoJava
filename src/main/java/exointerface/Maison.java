package exointerface;

public class Maison implements AvecChauffage, AvecClimatisation {

    private int temperature = 24;

    public void chauffer() {
        temperature++;
    }

    public void refroidir() {
        temperature--;
    }

    public void afficherTemperature(){
        System.out.println("Il fait "+temperature+" degrés dans ma maison");
    }
}
