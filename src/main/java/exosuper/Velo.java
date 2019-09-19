package exosuper;

public class Velo extends Vehicule{

    public Velo() {
        super(2);
    }

    @Override
    public void presenter() {
        super.presenter();
    }


    @Override
    public String toString() {
        return "Velo{" +
                "nombreRoues=" + nombreRoues +
                '}';
    }
//    @Override
//    public String toString() {
//        return "Je suis une vélo à "+nombreRoues+ " roues";
//    }

}
