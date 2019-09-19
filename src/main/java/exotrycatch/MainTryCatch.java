package exotrycatch;

public class MainTryCatch {
    public static void main(String[] args) {
        try {
            System.out.println(factorielle(2));
            factorielle(30);
            factorielle(-30);

        } catch (DepassementDeMemoireException e) {
            //Gestion d'un dépassement dé mémoire
            System.out.println("Cette méthode n'est pas faite pour fonctionner avec un nomber supérieur à 14");
            System.out.println(e.getMessage());
        } catch (NegativeNumberException e){
            //Gestion d'un nombre négatif
            e.printStackTrace();
        } catch (FactoException e){
            //Gestion de tout autre FactoException, qui n'est ni un dépassement ni un nombre négatif
            System.out.println("Erreur !!");
        }
    }

    private static int factorielle(int i){
        if(i>14){
            throw new DepassementDeMemoireException("Dépassement de mémoire !");
        }
        if(i<0){
            throw new NegativeNumberException("Nombre Negatif en entrée!");
        }
        //Code de factorielle
        return 0;
    }
}
