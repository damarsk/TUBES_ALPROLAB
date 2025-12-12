public class Patient {
    String nama;
    String notelp;
    String alamat;
    String email;
    Gejala gejala;
    String hasil;
    boolean isolasi;

    static String screening(Patient p) {
        Gejala g = p.gejala;

        int jumlahGejala = 0;
        if (g.demam) jumlahGejala++;
        if (g.batuk) jumlahGejala++;
        if (g.sesak) jumlahGejala++;
        if (g.sakitKepala) jumlahGejala++;
        if (g.sakitTenggorokan) jumlahGejala++;
        if (g.mudahLelah) jumlahGejala++;

        if (g.demam && g.batuk && g.sesak && g.pernahKontak) {
            p.isolasi = true;
            return "Terkonfirmasi";
        }
        if (g.pernahKontak) {
            return "Kontak Erat";
        }
        if (g.pernahKontak && (g.demam || g.batuk || g.sesak)) {
            return "Probable";
        }
        if (jumlahGejala >= 3) {
            return "Suspect";
        }
        if (jumlahGejala == 0) {
            return "Negatif";
        }

        return "Suspect"; 
    }
}
