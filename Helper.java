import java.util.Scanner;

public class Helper {
    public static boolean inputYN(Scanner sc, String pesan) {
        while (true) {
            System.out.print(pesan);
            String in = sc.nextLine().trim().toLowerCase();

            if (in.equals("y")) return true;
            if (in.equals("n")) return false;

            System.out.println("Input hanya boleh y atau n.");
        }
    }

    public static String inputString(Scanner sc, String pesan) {
        while (true) {
            System.out.print(pesan);
            String in = sc.nextLine().trim();

            if (!in.isEmpty()) return in;

            System.out.println("Input tidak boleh kosong.");
        }
    }
}