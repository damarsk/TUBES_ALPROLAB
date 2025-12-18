import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Patient[] data = new Patient[100];
        int jumlahPasien = 0;
        Scanner sc = new Scanner(System.in);
        do {
            Menu.CLI();
            int pilihan = sc.nextInt();
            sc.nextLine();
            if (pilihan >= 1 && pilihan <= 6) {
                if (pilihan == 1) {
                    PatientManager.menuDaftarPasien(data, jumlahPasien);
                } else if (pilihan == 2) {
                    jumlahPasien = PatientManager.menuRegistrasiPasienBaru(data, jumlahPasien, sc);
                } else if (pilihan == 3) {
                    PatientManager.menuEditPasien(data, jumlahPasien, sc);
                } else if (pilihan == 4) {
                    jumlahPasien = PatientManager.menuHapusPasien(data, jumlahPasien, sc);
                } else if (pilihan == 5) {
                    PatientManager.menuCariPasienByScreening(data, jumlahPasien, sc);
                } else if (pilihan == 6) {
                    Helper.msgFormat("Terimakasih!!");
                    System.exit(0);
                }
            } else {
                Helper.msgFormat("Pilih yang sesuai!");
            }
        } while (true);
    }
}
