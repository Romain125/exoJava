package exoconstructeur;

public class Enfant {

    int age;
    String nom;
    String prenom;
    Enfant amoureux;

    public Enfant(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Enfant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = 0;
    }

    String getPrenom(){
        return this.prenom;
    }

    void jouerAuBallon(Enfant ami){
        System.out.println(this.prenom+" joue au ballon avec "+ami.getPrenom());
    }

    void presenter(){
        System.out.println("Bonjour, je suis : "+nom+" "+prenom+" et j'ai "+age+" ans");
    }

    void feterAnniversaire(){
        if(age>17) {
            System.out.println("erreur");
        }else{
            age++;
        }
    }

    void tomberAmoureux(Enfant amoureux){
        this.amoureux = amoureux;
    }

    boolean isAmoureux(){
        return amoureux != null;
    }
}
