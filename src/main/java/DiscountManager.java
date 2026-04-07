import java.util.List;

public class DiscountManager {

    public void aplicaDiscountStocRedus(List<Produs> produse) {
        for (Produs p : produse) {
            if (p.cantitate < 30) {
                p.aplicaDiscount(10);
                if (p.cantitate < 10 && p.poateFiRedus(p.pret * 0.9)) {
                    p.aplicaDiscount(10);
                }
            }
        }
    }
    public double calculeazaPretRedus(Produs p, double procent) {
        return p.pret - (p.pret * procent / 100);
    }
}
