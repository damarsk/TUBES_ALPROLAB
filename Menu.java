import java.util.Scanner;

public class Menu {
    public static void main (String[] args) {
        Patient[] data = new Patient[100];
        int jumlahPasien = 0;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Screening COVID-19");
            System.out.println("=======================");
            System.out.println("1.Daftar Seluruh Pasien");
            System.out.println("2.Registrasi Pasien Baru & Input Gejala");
            System.out.println("3.Edit Data Pasien");
            System.out.println("4.Hapus Data Pasien");
            System.out.println("5.Cari Berdasarkan Hasil");
            System.out.println("6.Keluar");
            System.out.print("Pilih : ");

            int pilihan = sc.nextInt();
            sc.nextLine();

            if (pilihan >= 1 && pilihan <= 7) {
                if (pilihan == 1) {
                    PatientManager.daftarPasien(data, jumlahPasien);
                } else if (pilihan == 2) {
                    Patient p = new Patient();
                    System.out.println();
                    System.out.println("Pendaftaran Pasien Baru");
                    System.out.println("=======================");
                    p.nama = Helper.inputString(sc, "Nama lengkap: ");
                    p.notelp = Helper.inputString(sc, "No Telp: ");
                    p.alamat = Helper.inputString(sc, "Alamat Lengkap: ");
                    p.email = Helper.inputString(sc, "Email: ");

                    Gejala g = new Gejala();
                    System.out.println();
                    System.out.println("Input Gejala Pasien");
                    System.out.println("=======================");
                    g.demam = Helper.inputYN(sc, "Demam (y/n): ");
                    g.batuk = Helper.inputYN(sc, "Batuk (y/n): ");
                    g.sesak = Helper.inputYN(sc, "Sesak Napas (y/n): ");
                    g.sakitKepala = Helper.inputYN(sc, "Sakit Kepala (y/n): ");
                    g.sakitTenggorokan = Helper.inputYN(sc, "Sakit Tenggorokan (y/n): ");
                    g.mudahLelah = Helper.inputYN(sc, "Mudah Lelah (y/n): ");
                    g.pernahKontak = Helper.inputYN(sc, "Pernah Kontak Kasus Positif (y/n): ");

                    p.gejala = g;
                    p.hasil = Patient.screening(p);

                    data[jumlahPasien] = p;
                    jumlahPasien++;

                    System.out.println();
                    System.out.println("Pasien berhasil didaftarkan.");
                } else if (pilihan == 3) {
                    System.out.println();
                    System.out.println("Edit Data Pasien");
                    System.out.println("=======================");
                    System.out.print("Nama lengkap pasien: ");
                    String cariNama = sc.nextLine();

                    int idx = PatientManager.cariIndex(data, jumlahPasien, cariNama);

                    if (idx == -1) {
                        System.out.println("Pasien tidak ditemukan");
                    } else {
                        System.out.println("=======================");
                        System.out.println("Mau Edit Apa?");
                        System.out.println("1. Data Pasien");
                        System.out.println("2. Gejala");
                        System.out.println("3. Kembali");
                        System.out.println("=======================");
                        System.out.print("Pilih: ");

                        int editPilih;
                        try {
                            editPilih = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("Input tidak valid!");
                            continue;
                        }

                        if (editPilih == 1) {
                            Patient p = data[idx];

                            System.out.println();
                            System.out.println("Edit Data Pasien");
                            System.out.println("=======================");
                            System.out.println("Kosongkan jika tidak ingin mengubah");

                            System.out.print("Nama (" + p.nama + "): ");
                            String baru = sc.nextLine();
                            if (!baru.isEmpty()) p.nama = baru;

                            System.out.print("Nomor Telp (" + p.notelp + "): ");
                            baru = sc.nextLine();
                            if (!baru.isEmpty()) p.notelp = baru;

                            System.out.print("Alamat (" + p.alamat + "): ");
                            baru = sc.nextLine();
                            if (!baru.isEmpty()) p.alamat = baru;

                            System.out.print("Email (" + p.email + "): ");
                            baru = sc.nextLine();
                            if (!baru.isEmpty()) p.email = baru;

                            System.out.println("Data pasien berhasil diperbarui.");
                        }

                        else if (editPilih == 2) {
                            Patient p = data[idx];
                            Gejala g = p.gejala;

                            System.out.println();
                            System.out.println("Edit Gejala Pasien");
                            System.out.println("=======================");

                            g.demam = Helper.inputYN(sc, "Demam (y/n): ");
                            g.batuk = Helper.inputYN(sc, "Batuk (y/n): ");
                            g.sesak = Helper.inputYN(sc, "Sesak napas (y/n): ");
                            g.sakitKepala = Helper.inputYN(sc, "Sakit kepala (y/n): ");
                            g.sakitTenggorokan = Helper.inputYN(sc, "Sakit tenggorokan (y/n): ");
                            g.mudahLelah = Helper.inputYN(sc, "Mudah lelah (y/n): ");
                            g.pernahKontak = Helper.inputYN(sc, "Pernah kontak kasus positif (y/n): ");
                            p.hasil = Patient.screening(p);

                            System.out.println("Gejala berhasil diperbarui.");
                        }

                        else if (editPilih == 3) {
                            continue;
                        }

                        else {
                            System.out.println("Pilihan tidak sesuai!");
                        }
                    }
                } else if (pilihan == 4) {
                    System.out.println("\nHapus Data Pasien");
                    System.out.println("=======================");
                    System.out.print("Masukkan nama lengkap pasien: ");
                    String cariNama = sc.nextLine();

                    int idx = PatientManager.cariIndex(data, jumlahPasien, cariNama);

                    if (idx == -1) {
                        System.out.println("Pasien tidak ditemukan");
                    } else {
                        for (int i = idx; i < jumlahPasien - 1; i++) {
                            data[i] = data[i + 1];
                        }
                        jumlahPasien--;

                        System.out.println("Data berhasil dihapus");
                    }
                } else if (pilihan == 5) {
                    System.out.println();
                    System.out.println("Cari Pasien Berdasarkan Hasil Screening");
                    System.out.println("=======================");
                    System.out.println("1. Probable");
                    System.out.println("2. Suspect");
                    System.out.println("3. Kontak Erat");
                    System.out.println("4. Terkonfirmasi");
                    System.out.println("5. Kembali");
                    System.out.print("Pilih : ");
                    int hasilPilih = sc.nextInt();
                    sc.nextLine();
                    if (hasilPilih >= 1 && hasilPilih <= 4) {
                        if (hasilPilih == 1) {
                            PatientManager.daftarPasienByScreening(data, jumlahPasien, "Probable");
                        } else if (hasilPilih == 2) {
                            PatientManager.daftarPasienByScreening(data, jumlahPasien, "Suspect");
                        } else if (hasilPilih == 3) {
                            PatientManager.daftarPasienByScreening(data, jumlahPasien, "Kontak Erat");
                        } else if (hasilPilih == 4) {
                            PatientManager.daftarPasienByScreening(data, jumlahPasien, "Terkonfirmasi");
                        }
                    } else {
                        System.out.println();
                        System.out.println("=======================");
                        System.out.println("Pilih yang sesuai!");
                        System.out.println("=======================");
                    }
                } else if (pilihan == 6) {
                    System.out.println("=======================");
                    System.out.println("Terimakasih!");
                    System.out.println("=======================");
                    System.exit(0);
                }
            } else {
                System.out.println();
                System.out.println("=======================");
                System.out.println("Pilih yang sesuai!");
                System.out.println("=======================");
            }
        } while (true);
    }
}
