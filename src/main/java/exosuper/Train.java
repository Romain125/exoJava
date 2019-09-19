package exosuper;

public class Train extends Vehicule {

    public Train() {
        super(100);
    }

    @Override
    public void presenter() {
        super.presenter();
        System.out.println("Choo ! Choo !");
    }
}
