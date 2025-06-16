import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Wuerfel wuerfel1 = new Wuerfel();
        Wuerfel wuerfel2 = new Wuerfel();
        Spieler spieler1;
        Spieler spieler2;

        Scanner sc = new Scanner(System.in);
        System.out.print("Möchtest du eigene Spieler erstellen? (Ja/Nein)");
        String customPlayerInput = sc.next();

        if(customPlayerInput.equals("nein".toLowerCase())) {
            spieler1 = new Spieler();
            spieler2 = new Spieler();
        } else {
            System.out.println(BLUE + "|||||||| SPIELER 1 ||||||||" + RESET);
            System.out.print("Gebe einen Namen ein: ");
            String nameInput1 = sc.next();

            spieler1 = new Spieler(nameInput1);

            System.out.println(BLUE + "|||||||| SPIELER 2 ||||||||" + RESET);
            System.out.print("Gebe einen Namen ein: ");
            String nameInput2 = sc.next();

            spieler2 = new Spieler(nameInput2);
        }

        Spieler aktiverSpieler = spieler1;
        Spiel spiel = new Spiel(wuerfel1, wuerfel2, spieler1, spieler2, aktiverSpieler);

        boolean weiter = true;
        while (weiter) {
            System.out.println("Am Zug: " + aktiverSpieler.name);
            spiel.spielzug(aktiverSpieler);

            aktiverSpieler = spiel.getAktiverSpieler();
            spiel.setAktiverSpieler(aktiverSpieler);

            System.out.println(YELLOW + "\n|||||||| ZUSAMMENFASSUNG ||||||||" + RESET + "\nPunkte im Topf: " + spiel.getTopfInhalt() + "\nAnzahl deiner Punkte: " + aktiverSpieler.getPunkte());
            System.out.print("Möchtet ihr weiterspielen? (Ja/Nein): ");
            String input = sc.next();
            if (input.equalsIgnoreCase("nein")) {
                weiter = false;
            }
        }

        System.out.println("Spiel beendet!");
        System.out.println(spieler1.name + " hat " + spieler1.getPunkte() + " Punkte.");
        System.out.println(spieler2.name + " hat " + spieler2.getPunkte() + " Punkte.");
    }
}
