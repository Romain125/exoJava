package exocollection;

import java.util.Objects;

public class ObjectHashCode {

    private String nom;
    private int age;

    public ObjectHashCode(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        ObjectHashCode that = (ObjectHashCode) o;
        return this.age == that.age &&
                this.nom.equals(that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, age);
    }
}
