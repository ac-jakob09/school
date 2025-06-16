public class Wuerfel {
    private int augen;

    public Wuerfel() {
        augen = 0;
    }

    public int wuerfeln() {
        augen = (int) (Math.random() * 6) + 1;
        return augen;
    }
}
