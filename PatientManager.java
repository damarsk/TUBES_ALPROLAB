public class PatientManager {
    static int cariIndex(Patient[] data, int jumlah, String nama) {
        for (int i = 0; i < jumlah; i++) {
            if (data[i].nama.equalsIgnoreCase(nama)) {
                return i;
            }
        }
        return -1;
    }

    static void daftarPasien(Patient[] data, int jumlahPasien) {
        System.out.println();
        System.out.println("+------+----------------------+----------------------+----------------------+----------------------+");
        System.out.printf("| %-4s | %-20s | %-20s | %-20s | %-20s |\n", 
        "No", "Nama", "Nomor Telp", "Alamat", "Email");
        System.out.println("+------+----------------------+----------------------+----------------------+----------------------+");
        if (jumlahPasien > 0) {
            for (int i = 0; i < jumlahPasien; i++) {
                System.out.printf("| %-4d | %-20s | %-20s | %-20s | %-20s |\n",
                (i + 1),
                data[i].nama,
                data[i].notelp,
                data[i].alamat,
                data[i].email
                );
            }
        } else {
            String teks = "Data Kosong!";
            System.out.printf("| %-96s |\n", 
                String.format("%" + ((94 + teks.length()) / 2) + "s", teks)
            );
        }
        System.out.println("+------+----------------------+----------------------+----------------------+----------------------+");
    }

    static void daftarPasienByScreening(Patient[] data, int jumlahPasien, String hasilScreening) {
        System.out.println();
        System.out.println("+------+----------------------+----------------------+----------------------+----------------------+----------------------+");
        System.out.printf("| %-4s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", 
        "No", "Nama", "Nomor Telp", "Alamat", "Email", "Hasil Screening");
        System.out.println("+------+----------------------+----------------------+----------------------+----------------------+----------------------+");
        boolean found = false;
        for (int i = 0; i < jumlahPasien; i++) {
            if (data[i].hasil.equals(hasilScreening)) {
                found = true;
                System.out.printf("| %-4d | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                (i + 1),
                data[i].nama,
                data[i].notelp,
                data[i].alamat,
                data[i].email,
                data[i].hasil
                );
            }
        }
        if (!found) {
            String teks = "Data Kosong!";
            System.out.printf("| %-116s |\n", 
                String.format("%" + ((114 + teks.length()) / 2) + "s", teks)
            );
        }
        System.out.println("+------+----------------------+----------------------+----------------------+----------------------+----------------------+");
    }
}