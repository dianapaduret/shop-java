import java.util.*;

public class AplicatieMagazin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventar inventar = new Inventar();
        DiscountManager discountManager = new DiscountManager();

        while (true) {
            System.out.println("\n--- MENIU ---");
            System.out.println("1. Adauga produs");
            System.out.println("2. Sterge produs");
            System.out.println("3. Modifica produs");
            System.out.println("4. Aplica discount");
            System.out.println("5. Afiseaza produse dupa categorie");
            System.out.println("6. Filtrare produse");
            System.out.println("7. Afiseaza toate produsele");
            System.out.println("0. Iesire");
            System.out.print("Alege optiunea: ");

            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1 -> {
                    System.out.print("Nume: ");
                    String nume = scanner.nextLine();
                    System.out.print("Pret: ");
                    double pret = scanner.nextDouble();
                    System.out.print("Marime (XS/S/M/L/XL): ");
                    Marime marime = Marime.valueOf(scanner.next().toUpperCase());
                    System.out.print("Culoare: ");
                    String culoare = scanner.next();
                    System.out.print("Cantitate: ");
                    int cantitate = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Tip produs (ex: Tricou, Hanorac): ");
                    String tip = scanner.nextLine();

                    Produs produs = switch (tip.toLowerCase()) {
                        case "tricou" -> new Tricou(nume, pret, marime, culoare, cantitate);
                        case "hanorac" -> new Hanorac(nume, pret, marime, culoare, cantitate);
                        case "pantalonilungi" -> new PantaloniLungi(nume, pret, marime, culoare, cantitate);
                        case "pantaloniscurti" -> new PantaloniScurti(nume, pret, marime, culoare, cantitate);
                        case "maiou" -> new Maiou(nume, pret, marime, culoare, cantitate);
                        case "incaltaminteesport" -> new IncaltaminteSport(nume, pret, marime, culoare, cantitate);
                        case "incaltaminteeleganta" -> new IncaltaminteEleganta(nume, pret, marime, culoare, cantitate);
                        default -> {
                            System.out.println("Tip necunoscut.");
                            yield null;
                        }
                    };

                    if (produs != null) {
                        inventar.adaugaProdus(produs);
                        System.out.println("Produs adaugat.");
                    }
                }
                case 2 -> {
                    System.out.print("Nume produs: ");
                    String nume = scanner.nextLine();
                    inventar.stergeProdus(nume);
                }
                case 3 -> {
                    System.out.print("Nume produs: ");
                    String nume = scanner.nextLine();
                    System.out.print("Nou pret: ");
                    double pret = scanner.nextDouble();
                    System.out.print("Noua cantitate: ");
                    int cantitate = scanner.nextInt();
                    scanner.nextLine();
                    inventar.modificaProdus(nume, pret, cantitate);
                }
                case 4 -> {
                    discountManager.aplicaDiscountStocRedus(inventar.raporteazaPeCategorie("Tricou"));
                    System.out.println("Discount aplicat.");
                }
                case 5 -> {
                    System.out.print("Categorie (ex: Tricou): ");
                    String categorie = scanner.nextLine();
                    List<Produs> produse = inventar.raporteazaPeCategorie(categorie);
                    produse.forEach(Produs::afiseazaInfo);
                }
                case 6 -> {
                    System.out.print("Filtru nume (sau ENTER): ");
                    String nume = scanner.nextLine();
                    if (nume.isBlank()) nume = null;

                    System.out.print("Pret (sau -1): ");
                    double pret = scanner.nextDouble();

                    System.out.print("Culoare (sau ENTER): ");
                    scanner.nextLine();
                    String culoare = scanner.nextLine();
                    if (culoare.isBlank()) culoare = null;

                    System.out.print("Marime (sau ENTER): ");
                    String marimeStr = scanner.nextLine();
                    Marime marime = marimeStr.isBlank() ? null : Marime.valueOf(marimeStr.toUpperCase());

                    System.out.print("Cantitate (sau -1): ");
                    int cantitate = scanner.nextInt();
                    scanner.nextLine();

                    List<Produs> filtrate = inventar.filtreaza(nume, pret, culoare, marime, cantitate);
                    filtrate.forEach(Produs::afiseazaInfo);
                }
                case 7 -> {
                    for (Produs p : inventar.getToateProdusele()) {
                        p.afiseazaInfo();
                    }
                }
                case 0 -> {
                    System.out.println("La revedere!");
                    return;
                }
                default -> System.out.println("Optiune invalida.");
            }
        }
    }
}
