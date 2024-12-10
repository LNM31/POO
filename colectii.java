import java.util.ArrayList;
import java.util.Iterator;

abstract class Tip {
    public abstract String getTip();

    @Override
    public abstract String toString();
}

class Intreg extends Tip {
    private int valoare;

    public Intreg(int valoare) {
        this.valoare = valoare;
    }

    @Override
    public String getTip() {
        return "Tip: Intreg";
    }

    @Override
    public String toString() {
        return String.valueOf(valoare);
    }
}

class Sir extends Tip {
    private String valoare;

    public Sir(String valoare) {
        this.valoare = valoare;
    }

    @Override
    public String getTip() {
        return "Tip: Sir";
    }

    @Override
    public String toString() {
        return valoare;
    }
}

class Colectie extends Tip {
    private ArrayList<Tip> elemente;

    public Colectie() {
        this.elemente = new ArrayList<>();
    }

    public void adaugaElement(Tip element) {
        elemente.add(element);
    }

    @Override
    public String getTip() {
        return "Tip: Colectie";
    }

    @Override
    public String toString() {
        StringBuilder rezultat = new StringBuilder("(");
        Iterator<Tip> iterator = elemente.iterator();
        while (iterator.hasNext()) {
            rezultat.append(iterator.next().toString());
            if (iterator.hasNext()) {
                rezultat.append(", ");
            }
        }
        rezultat.append(")");
        return rezultat.toString();
    }

    public boolean esteEgalCu(Colectie altaColectie) {
        if (this.elemente.size() != altaColectie.elemente.size()) {
            return false;
        }

        Iterator<Tip> thisIterator = this.elemente.iterator();
        Iterator<Tip> otherIterator = altaColectie.elemente.iterator();

        while (thisIterator.hasNext()) {
            if (!thisIterator.next().toString().equals(otherIterator.next().toString())) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        // Colectie principală
        Colectie colectiePrincipala = new Colectie();
        colectiePrincipala.adaugaElement(new Intreg(7));
        colectiePrincipala.adaugaElement(new Intreg(4));
        colectiePrincipala.adaugaElement(new Sir("Eu"));
        colectiePrincipala.adaugaElement(new Intreg(12));

        // Colectie secundară
        Colectie colectieSecundara = new Colectie();
        colectieSecundara.adaugaElement(new Intreg(2));
        colectieSecundara.adaugaElement(new Intreg(8));

        // Adăugarea colectiei secundare în colectia principală
        colectiePrincipala.adaugaElement(colectieSecundara);

        // Afisare colectii
        System.out.println("Colectie principala: " + colectiePrincipala.toString());
        System.out.println("Colectie secundara: " + colectieSecundara.toString());

        // Testare egalitate colectii
        Colectie altaColectie = new Colectie();
        altaColectie.adaugaElement(new Intreg(7));
        altaColectie.adaugaElement(new Intreg(4));
        altaColectie.adaugaElement(new Sir("Eu"));
        altaColectie.adaugaElement(new Intreg(12));
        altaColectie.adaugaElement(colectieSecundara);

        System.out.println("Colectiile principale și alta colectie sunt egale? " + colectiePrincipala.esteEgalCu(altaColectie));
    }
}