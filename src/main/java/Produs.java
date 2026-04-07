public abstract class Produs {
    protected String nume;
    protected double pret;
    protected Marime marime;
    protected String culoare;
    protected int cantitate;
    protected double pretInitial;
    public Produs(String nume, double pret, Marime marime, String culoare, int cantitate) {
        if (nume == null || nume.isEmpty() || pret < 0 || cantitate < 0) {
            throw new IllegalArgumentException("Date invalide pentru produs.");
        }
        this.nume = nume;
        this.pret = pret;
        this.pretInitial = pret;
        this.marime = marime;
        this.culoare = culoare;
        this.cantitate = cantitate;
    }

    public void aplicaDiscount(double procent) {
        pret -= pret * procent / 100;
    }

    public double getPretInitial() {
        return pretInitial;
    }

    public boolean poateFiRedus(double nouPret) {
        return nouPret >= (pretInitial / 2);
    }

    public void afiseazaInfo() {
        System.out.println(this);
    }

    public String getNume() { return nume; }
    public double getPret() { return pret; }
    public Marime getMarime() { return marime; }
    public String getCuloare() { return culoare; }
    public int getCantitate() { return cantitate; }
    public double getPretInitialOriginal() { return pretInitial; }

    public void setPret(double pret) { this.pret = pret; }
    public void setCantitate(int cantitate) { this.cantitate = cantitate; }

    @Override
    public String toString() {
        return nume + " - " + pret + " RON, " + marime + ", " + culoare + ", Cantitate: " + cantitate;
    }
}


