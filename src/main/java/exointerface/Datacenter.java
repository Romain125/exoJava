package exointerface;

public class Datacenter implements AvecClimatisation {

    int temperature = 50; //il fait chaud sans clim !

    public void refroidir() {
        this.temperature = 20;
    }

    public void afficherTemperature(){
        System.out.println("Il fait "+temperature+" degrés dans mon datacenter");
    }
}
