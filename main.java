import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {

    
    public static double hitungGaji(double jamKerja, double tarifPerJam) {
        double gaji;
        if (jamKerja <= 40) {
          
            gaji = jamKerja * tarifPerJam;
        } else {
            
            double jamLembur = jamKerja - 40;
            gaji = (40 * tarifPerJam) + (jamLembur * tarifPerJam * 1.5);
        }
        return gaji;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
        String tanggalwaktu = now.format(formatter);

       
        System.out.print("Masukkan jumlah karyawan: ");
        int jumlahKaryawan = input.nextInt();
        input.nextLine();

        String[] namaKaryawan = new String[jumlahKaryawan];
        double[] jamKerjaKaryawan = new double[jumlahKaryawan];
        double[] tarifPerJamKaryawan = new double[jumlahKaryawan];
        double[] gajiKaryawan = new double[jumlahKaryawan];
        String[] jabatan = new String[jumlahKaryawan];

        for (int i = 0; i < jumlahKaryawan; i++) {
            System.out.println("\nData Karyawan " + (i + 1) + ":");
            System.out.print("Nama: ");
            namaKaryawan[i] = input.nextLine();
            System.out.print("Jabatan: ");
            jabatan[i] = input.nextLine();
            System.out.print("Jam kerja: ");
            jamKerjaKaryawan[i] = input.nextDouble();
            System.out.print("Tarif per jam: ");
            tarifPerJamKaryawan[i] = input.nextDouble();
            input.nextLine();

            
            gajiKaryawan[i] = hitungGaji(jamKerjaKaryawan[i], tarifPerJamKaryawan[i]);
        }

       
        System.out.println("\n=== Laporan Gaji Karyawan ===");
        System.out.println(tanggalwaktu);
        System.out.println("----------------------------");
        for (int i = 0; i < jumlahKaryawan; i++) {
            System.out.printf("Nama: %s\n", namaKaryawan[i]);
            System.out.printf("Jabatan: %s\n", jabatan[i]);
            System.out.printf("Jam Kerja: %.2f\n", jamKerjaKaryawan[i]);
            System.out.printf("Tarif per Jam: Rp %.2f\n", tarifPerJamKaryawan[i]);
            System.out.printf("Gaji Bersih: Rp %.2f\n", gajiKaryawan[i]);
            System.out.println("----------------------------");
        }

       
    }
}
