public class Spieler {
    protected String name;
    protected int punkte;
    protected int anzahlZuege;

    public Spieler() {
        name = "Fritz";
        punkte = 0;
        anzahlZuege = 0;
    }

    public Spieler(String name) {
        this.name = name;
        punkte = 0;
        anzahlZuege = 0;
    }

    public int getAnzahlZuege() {
        return anzahlZuege;
    }

    public void addSpielzug() {
        anzahlZuege++;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public void punkteHinzufuegen(int punkte) {
        this.punkte =+ punkte;
    }
}