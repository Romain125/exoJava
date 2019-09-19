package exosuper;

public class MainSuper {
    public static void main(String[] args) {
        Velo vtt = new Velo();
        vtt.presenter();
        Train transsiberien = new Train();
        transsiberien.presenter();

        System.out.println(vtt);
        System.out.println(transsiberien);
    }
}
