import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Laporan{
	private static BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
	private String Bulan(String Data){
		String bulan = "";
		if(Data.equals("Januari")) bulan = "01";
		else if(Data.equalsIgnoreCase("Februari")) bulan = "02";
		else if(Data.equalsIgnoreCase("Maret")) bulan = "03";
		else if(Data.equalsIgnoreCase("April")) bulan = "04";
		else if(Data.equalsIgnoreCase("Mei")) bulan = "05";
		else if(Data.equalsIgnoreCase("Juni")) bulan = "06";
		else if(Data.equalsIgnoreCase("Juli")) bulan = "07";
		else if(Data.equalsIgnoreCase("Agustus")) bulan = "08";
		else if(Data.equalsIgnoreCase("Sepetember")) bulan = "09";
		else if(Data.equalsIgnoreCase("Oktober")) bulan = "10";
		else if(Data.equalsIgnoreCase("November")) bulan = "11";
		else if(Data.equalsIgnoreCase("Desember")) bulan = "12";
		else System.out.println("BULAN SALAH !!!");
		return bulan;
	}
	private byte CariPembayaran(String Bulan, String Tahun, ArrayList<DataPembayaran> data){
		byte urutan = -1;
		for(byte i=0;  i < data.size(); i++){
			if(data.get(i).getTanggalBayar().substring(3,5).equalsIgnoreCase(Bulan) &&
			data.get(i).getTanggalBayar().substring(6,10).equalsIgnoreCase(Tahun)){
				urutan = i;
				break;
			}
		}
		return urutan;
	}
	public void LaporanPembayaran(ArrayList<DataPembayaran> data) throws IOException{
		int posisi = -1;
		System.out.print("Masukkan Bulan : ");
		String bulan = in.readLine();
		System.out.print("Masukkan Tahun : ");
		String tahun = in.readLine();
		posisi = CariPembayaran(Bulan(bulan),tahun,data);
		
		if(posisi == -1) System.out.println("DATA TIDAK ADA !!!");
		else{
			System.out.println("\nLaporan Pembayaran Bulan " + bulan + " Tahun " + tahun);
			System.out.println("========================================================\n");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| NO  |   No Pembayaran   | Kode Pelanggan     | Kode Petugas     | Tanggal Pembayaran      | Golongan       | Tarif (kWh) | Total Konsumsi Daya (kWh) | Denda   | Sub Total         | Total Bayar   |");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			for(int x = 0; x<data.size(); x++){
				if (data.get(x).getTanggalBayar().substring(3,5).equals(Bulan(bulan)) && 
					data.get(x).getTanggalBayar().substring(6,10).equals(tahun))
				{
				System.out.printf("%-2s%-4s%-4s%-16s%-2s%-19s%-2s%-17s%-2s%-24s%-2s%-15s%-2s%-12s%-2s%-26s%-2s%-8s%-2s%-18s%-2s%-18s%-1s%n", 
				"|", x+1, "|", data.get(x).getPemabayaran(), "|", data.get(x).getKode(), "|", data.get(x).getKodePetugas(), "|"
				, data.get(x).getTanggalBayar(), "|", data.get(x).getGolongan(), "|", data.get(x).getTarif(), "|", data.get(x).getDaya() / 1000, "|", data.get(x).getDenda(), 
				"|", (data.get(x).getTarif() * (data.get(x).getDaya() / 1000)), "|", ((data.get(x).getTarif() * (data.get(x).getDaya() / 1000)) + data.get(x).getDenda()), "|");
			
				}
			}
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
