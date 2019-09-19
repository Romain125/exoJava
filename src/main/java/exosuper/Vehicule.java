package exosuper;

public class Vehicule {

    int nombreRoues;

    public Vehicule(int nombreRoues) {
        this.nombreRoues = nombreRoues;
    }

    public void presenter(){
        System.out.println("Bonjour, je suis un véhicule avec "+nombreRoues+" roues");
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "nombreRoues=" + nombreRoues +
                '}';
    }
}
