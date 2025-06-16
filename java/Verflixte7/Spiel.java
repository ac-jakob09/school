import java.util.Scanner;

public class Spiel {
    private Wuerfel wuerfel1;
    private Wuerfel wuerfel2;
    private Spieler spieler1;
    private Spieler spieler2;
    private Spieler aktiverSpieler;
    private int anzahlGespielterRunden;
    private int anzahlLetzteZuege;
    private Topf topf;
    private int lokalerTopf;
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";


    public Spiel(Wuerfel wuerfel1, Wuerfel wuerfel2, Spieler spieler1, Spieler spieler2, Spieler aktiverSpieler) {
        this.wuerfel1 = wuerfel1;
        this.wuerfel2 = wuerfel2;
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
        this.aktiverSpieler = aktiverSpieler;
        anzahlGespielterRunden = 0;
        anzahlLetzteZuege = 0;
        topf = new Topf();
        lokalerTopf = 0;
    }

    public Spieler getAktiverSpieler() {
        return aktiverSpieler;
    }

    public void setAktiverSpieler(Spieler spieler) {
        this.aktiverSpieler = spieler;
    }

    public int getTopfInhalt() {
        return topf.getTotalPunkte();
    }

    public void spielzug(Spieler spieler) {
        if (spieler != aktiverSpieler) {
            System.out.println("Spieler Error (nicht aktiver Spieler hat .spielzug versucht)");
            return;
        }

        boolean weiter = true;
        Scanner scanner = new Scanner(System.in);

        while (weiter) {
            int ergebnis1 = wuerfel1.wuerfeln();
            int ergebnis2 = wuerfel2.wuerfeln();
            int ergebnis = ergebnis1 + ergebnis2;

            System.out.println(GREEN + "\n||| ERGEBNISSE: WÜRFEL |||" + RESET);
            System.out.println("Würfel 1: " + ergebnis1 + "\nWürfel 2: " + ergebnis2);

            spieler.addSpielzug();

            if (ergebnis == 7) {
                System.out.println(RED + "Verloren :(, Verflixte 7!" + RESET);
                lokalerTopf = 0;
                anzahlGespielterRunden++;
                return;
            } else {
                lokalerTopf += ergebnis;
                System.out.print("Möchtest du weiter spielen? (Ja/Nein): ");
                String weiterInput = scanner.nextLine();
                if (weiterInput.equals("nein".toLowerCase())) {
                    topf.punkteHinzufuegen(lokalerTopf);
                    aktiverSpieler.punkteHinzufuegen(lokalerTopf);
                    lokalerTopf = 0;
                    weiter = false;
                }
            }
            anzahlGespielterRunden++;
        }
    }
}
