package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Penghasilan Tidak Kena Pajak:
	 * - Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * - Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * - Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	 public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        int tax = 0;

        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        // Maksimum 3 anak yang diperhitungkan untuk pajak
        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }

        // Hitung pajak berdasarkan aturan yang telah dijelaskan
        int nonTaxableIncome = 54000000;
        if (isMarried) {
            nonTaxableIncome += 4500000;
        }

        // Tambahkan Rp 4.500.000 per anak hingga anak ketiga
        for (int i = 0; i < numberOfChildren && i < 3; i++) {
            nonTaxableIncome += 4500000;
        }

        tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - nonTaxableIncome));

        if (tax < 0) {
            return 0;
        } else {
            return tax;
        }

    }
	
}
