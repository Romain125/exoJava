package exointerface;

public class MainInterface {

    public static void main(String[] args) {
        Maison petiteMaisonDansLaPrairie = new Maison();
        petiteMaisonDansLaPrairie.afficherTemperature();
        petiteMaisonDansLaPrairie.chauffer();
        petiteMaisonDansLaPrairie.chauffer();
        petiteMaisonDansLaPrairie.chauffer();
        petiteMaisonDansLaPrairie.chauffer();
        petiteMaisonDansLaPrairie.afficherTemperature();
        petiteMaisonDansLaPrairie.refroidir();
        petiteMaisonDansLaPrairie.refroidir();
        petiteMaisonDansLaPrairie.refroidir();
        petiteMaisonDansLaPrairie.afficherTemperature();

        Datacenter marneNord = new Datacenter();
        marneNord.afficherTemperature();
        marneNord.refroidir();
        marneNord.refroidir();
        marneNord.refroidir();
        marneNord.afficherTemperature();
    }

}
