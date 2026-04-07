import java.util.ArrayList;
import java.util.List;

public class Inventar {
    private List<Produs> produse;

    public Inventar() {
        produse = new ArrayList<>();
    }



    public void adaugaProdus(Produs p) {
        produse.add(p);
    }

    public void stergeProdus(String nume) {
        produse.removeIf(p -> p.nume.equalsIgnoreCase(nume));
    }

    public void modificaProdus(String nume, double nouPret, int nouaCantitate) {
        for (Produs p : produse) {
            if (p.nume.equalsIgnoreCase(nume)) {
                if (nouPret >= 0) p.pret = nouPret;
                if (nouaCantitate >= 0) p.cantitate = nouaCantitate;
                return;
            }
        }
        System.out.println("Produsul nu a fost gasit.");
    }

    public Produs cautaProdus(String nume) {
        for (Produs p : produse) {
            if (p.nume.equalsIgnoreCase(nume)) {
                return p;
            }
        }
        System.out.println("Produs inexistent.");
        return null;
    }

    public List<Produs> filtreaza(String nume, double pret, String culoare, Marime marime, int cantitate) {
        List<Produs> filtrate = new ArrayList<>();
        for (Produs p : produse) {
            if ((nume == null || p.nume.equalsIgnoreCase(nume)) &&
                    (pret < 0 || p.pret == pret) &&
                    (culoare == null || p.culoare.equalsIgnoreCase(culoare)) &&
                    (marime == null || p.marime == marime) &&
                    (cantitate < 0 || p.cantitate == cantitate)) {
                filtrate.add(p);
            }
        }
        return filtrate;
    }

    public List<Produs> raporteazaPeCategorie(String tip) {
        List<Produs> rezultat = new ArrayList<>();
        for (Produs p : produse) {
            if (tip == null || tip.isEmpty() || p.getClass().getSimpleName().equalsIgnoreCase(tip)) {
                rezultat.add(p);
            }
        }
        return rezultat;
    }

    public List<Produs> getToateProdusele() {
        return produse;
    }

}
