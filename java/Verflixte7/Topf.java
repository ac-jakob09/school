public class Topf {
    private int totalPunkte;

    public Topf() {
        totalPunkte = 0;
    }

    public int getTotalPunkte() {
        return totalPunkte;
    }

    public void punkteHinzufuegen(int punkte) {
        totalPunkte =+ punkte;
    }
}
