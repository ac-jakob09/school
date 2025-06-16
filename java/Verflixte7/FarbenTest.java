public class FarbenTest {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        System.out.println(RED + "Das ist roter Text." + RESET);
        System.out.println(GREEN + "Das ist grüner Text." + RESET);
        System.out.println(YELLOW + "Das ist gelber Text." + RESET);
        System.out.println(BLUE + "Das ist blauer Text." + RESET);
    }
}
