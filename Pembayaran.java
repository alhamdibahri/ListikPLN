import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Pembayaran {
	private static BufferedReader data =new BufferedReader(new InputStreamReader(System.in));
	private byte CariTarifP(String kodePelanggan, ArrayList<PilihTarif> Tjenis) {        
		byte urutan = -1;
		for (byte i = 0; i < Tjenis.size(); i++) {
			if (Tjenis.get(i).getKode().equalsIgnoreCase(kodePelanggan)) {
				urutan = i;
				break;
			}	
		}
		return urutan;
    }
	private byte CariPetugas(String kodePetugas, ArrayList<DataPetugas> dataPetugas) {        
		byte urutan = -1;
		for (byte i = 0; i < dataPetugas.size(); i++) {
			if (dataPetugas.get(i).getNama().equalsIgnoreCase(kodePetugas)) {
				urutan = i;
				break;
			}
		}
		return urutan;
    }
	
	private byte CariTgl(String TglBayar, ArrayList<DataPembayaran> DataPembayaran, String KodePelanggan) {        
		byte urutan = -1;
		for (byte i = 0; i < DataPembayaran.size(); i++) {
			if (DataPembayaran.get(i).getTanggalBayar().substring(3,10).equalsIgnoreCase(TglBayar.substring(3,10))
				&& DataPembayaran.get(i).getKode().equals(KodePelanggan)) {
				urutan = i;
				break;
			}
		}
		return urutan;
    }
	private byte CariPembayaran(String NoPembayaran, ArrayList<DataPembayaran> DataPembayaran) {        
		byte urutan = -1;
		for (byte i = 0; i < DataPembayaran.size(); i++) {
			if (DataPembayaran.get(i).getPemabayaran().equalsIgnoreCase(NoPembayaran)) {
				urutan = i;
				break;
			}
		}
		return urutan;
    }
	public void InputPembayaran(ArrayList<PilihTarif> DataTarif,ArrayList<DataPetugas> dataPetugas,ArrayList<DataPembayaran> dataBayar, int urutan) throws IOException{
		int posisiPelanggan = -1;
		int posisiPetugas = -1;
		int posisiTanggal = -1;
		String NoPembayaran;
		
		System.out.println("Pembayaran Listrik PLN  ");
		DataPembayaran bayar = new DataPembayaran();
		DataPetugas petugas = new DataPetugas();
		PilihTarif pilihTarif = new PilihTarif();
		System.out.print(urutan +". No Pembayaran                    : ");
		NoPembayaran = data.readLine();
		bayar.setNoBayar(NoPembayaran);
		if(!bayar.getPemabayaran().equals("")){
			System.out.print("   Nama Petugas                     : ");
			petugas.setNama(data.readLine());
			posisiPetugas = CariPetugas(petugas.getNama(), dataPetugas);
			if(posisiPetugas == -1) System.out.println("   Nama Petugas tidak ditemukan !!\n");
			else{
				System.out.print("   Kode Pelanggan                   : ");
				bayar.setkodePelanggan(data.readLine());
				posisiPelanggan = CariTarifP(bayar.getKode(),DataTarif);
				if(posisiPelanggan == -1) System.out.println("   Data Pelanggan Tidak di temukan !\n");
				else{
					System.out.println("   Nama                             : " + DataTarif.get(posisiPelanggan).getNama());
					System.out.println("   Jenis Kelamin                    : " + pilihTarif.JenisKelamin(DataTarif.get(posisiPelanggan).getJk()));
					System.out.println("   Tanggal Lahir                    : " + DataTarif.get(posisiPelanggan).getTglLahir());
					System.out.println("   Alamat                           : " + DataTarif.get(posisiPelanggan).getAlamat());
					System.out.println("   Agama                            : " + DataTarif.get(posisiPelanggan).getAgama());
					System.out.println("   Handphone                        : " + DataTarif.get(posisiPelanggan).getHp());
					System.out.println("   Golongan Tarif                   : " + DataTarif.get(posisiPelanggan).getGolongan());
					System.out.println("   Tarif (Rp/kWh)                   : " + DataTarif.get(posisiPelanggan).getTarif());
					System.out.println("   Keterangan                       : " + DataTarif.get(posisiPelanggan).getKet());
					bayar.setKodePetugas(dataPetugas.get(posisiPetugas).getKode());
					bayar.setNamaPetugas(dataPetugas.get(posisiPetugas).getNama());
					bayar.setkodePelanggan(DataTarif.get(posisiPelanggan).getKode());
					bayar.setNama(DataTarif.get(posisiPelanggan).getNama());
					bayar.setJk(DataTarif.get(posisiPelanggan).getJk());
					bayar.setTglLahir(DataTarif.get(posisiPelanggan).getTglLahir());
					bayar.setAlamat(DataTarif.get(posisiPelanggan).getAlamat());
					bayar.setAgama(DataTarif.get(posisiPelanggan).getAgama());
					bayar.setHp(DataTarif.get(posisiPelanggan).getHp());
					bayar.setGolongan(DataTarif.get(posisiPelanggan).getGolongan());
					bayar.setTarif(DataTarif.get(posisiPelanggan).getTarif());
					bayar.setKet(DataTarif.get(posisiPelanggan).getKet());
							
					System.out.print("   Tanggal Bayar                    : ");
					bayar.setTanggalBayar(data.readLine());
					posisiTanggal = CariTgl(bayar.getTanggalBayar(), dataBayar, bayar.getKode());
					if(posisiTanggal != -1) System.out.println("   Pelanggan Sudah melakukan pembayaran");
					else{
						System.out.print("   Daya yang di hasilkan watt/bulan : ");
						bayar.setDaya(Integer.parseInt(data.readLine()));
						bayar.setDenda(bayar.HitungDenda(bayar.getTanggalBayar(),bayar.getGolongan()));
						dataBayar.add(bayar);
						System.out.println("   Pembayaran Berhasil di lakukan ");
						
						System.out.print("\n   Apakah Anda ingin mencetak struk pembayaran <Y/N> : ");
						String input = data.readLine();
						if (input.equalsIgnoreCase("Y")) {
							System.out.println("   ========================================================================");
							System.out.println("                               STRUK PEMBAYARAN");
							System.out.println("   ========================================================================");
							System.out.println("   No Pembayaran             : " + bayar.getPemabayaran());
							System.out.println("   Tanggal Pembayaran        : " + bayar.getTanggalBayar());
							System.out.println("   Total Konsumsi Daya (W)   : " + bayar.getDaya());
							System.out.println("   Total Konsumsi Daya (kWh) : " + (bayar.getDaya() / 1000));
							System.out.println("   ========================================================================");
							System.out.println("   DATA PELANGGAN                                                        ");
							System.out.println("   ========================================================================");
							System.out.println("   Nama                      : " + bayar.getNama());
							System.out.println("   Jenis Kelamin             : " + pilihTarif.JenisKelamin(bayar.getJk()));
							System.out.println("   Alamat                    : " + bayar.getAlamat());
							System.out.println("   ========================================================================");
							System.out.println("   DATA GOLONGAN TARIF                                                  ");
							System.out.println("   ========================================================================");
							System.out.println("   Golongan                  : " + bayar.getGolongan());
							System.out.println("   Tarif                     : " + bayar.getTarif() + " (Rp/kWh)");
							System.out.println("   Keterangan                : " + bayar.getKet());
							System.out.println("   ========================================================================");
							System.out.println("                                  Tarif Konsumsi Daya : Rp. " + (bayar.getTarif() * (bayar.getDaya() / 1000)));
							System.out.println("                                  Denda               : Rp. " + bayar.getDenda());
							System.out.println("                                  Total Bayar         : Rp. " + ((bayar.getTarif() * (bayar.getDaya() / 1000)) + bayar.getDenda()));
							System.out.println("   ========================================================================\n");
						} 
						else System.out.println("Struk Pembayaran batal di cetak");
					}
				}
			}
		}
	}
	public void UpdatePembayaran(ArrayList<DataPembayaran> Data) throws IOException{
		DataPembayaran DataPembayaran = new DataPembayaran();
		int posisi = -1;
		
		System.out.println("\nMetode Merubah Data Pembayaran");
		System.out.print("Masukkan No. Pembayaran          : ");
		DataPembayaran.setNoBayar(data.readLine());
		posisi = CariPembayaran(DataPembayaran.getPemabayaran(), Data);
		if(posisi == -1) System.out.println("No Pembayaran tidak di temukan !");
		else{
			System.out.println("Nama                             : " + Data.get(posisi).getNama());
			System.out.println("Jenis Kelamin                    : " + DataPembayaran.JenisKelamin(Data.get(posisi).getJk()));
			System.out.println("Tanggal Lahir                    : " + Data.get(posisi).getTglLahir());
			System.out.println("Alamat                           : " + Data.get(posisi).getAlamat());
			System.out.println("Agama                            : " + Data.get(posisi).getAgama());
			System.out.println("Handphone                        : " + Data.get(posisi).getHp());
			System.out.println("Golongan Tarif                   : " + Data.get(posisi).getGolongan());
			System.out.println("Tarif (Rp/kWh)                   : " + Data.get(posisi).getTarif());
			System.out.println("Keterangan                       : " + Data.get(posisi).getKet());
			System.out.println("Tanggal Bayar                    : " + Data.get(posisi).getTanggalBayar());
			System.out.println("Besar Daya                       : " + Data.get(posisi).getDaya());
			System.out.println("Denda                            : " + Data.get(posisi).getDenda());
			
			System.out.println("\nDATA PERUBAHAN");
			System.out.print("Tanggal Bayar                    : ");
			DataPembayaran.setTanggalBayar(data.readLine());
			
			if(DataPembayaran.getTanggalBayar().equals("")){
				DataPembayaran.setTanggalBayar(Data.get(posisi).getTanggalBayar());
				System.out.println("Tanggal Bayar                    : " + DataPembayaran.getTanggalBayar());
				System.out.print("Daya yang di hasilkan watt/bulan : ");
			}
			else System.out.print("Daya yang di hasilkan watt/bulan : ");
			DataPembayaran.setDaya(Integer.parseInt(data.readLine()));
			if(DataPembayaran.getDaya() == 0){
				DataPembayaran.setDaya(Data.get(posisi).getDaya());
				System.out.println("Daya yang di hasilkan watt/bulan : " + DataPembayaran.getDaya());
			}
			DataPembayaran.setKodePetugas(Data.get(posisi).getKode());
			DataPembayaran.setNamaPetugas(Data.get(posisi).getNama());
			DataPembayaran.setkodePelanggan(Data.get(posisi).getKode());
			DataPembayaran.setNama(Data.get(posisi).getNama());
			DataPembayaran.setJk(Data.get(posisi).getJk());
			DataPembayaran.setTglLahir(Data.get(posisi).getTglLahir());
			DataPembayaran.setAlamat(Data.get(posisi).getAlamat());
			DataPembayaran.setAgama(Data.get(posisi).getAgama());
			DataPembayaran.setHp(Data.get(posisi).getHp());
			DataPembayaran.setGolongan(Data.get(posisi).getGolongan());
			DataPembayaran.setTarif(Data.get(posisi).getTarif());
			DataPembayaran.setKet(Data.get(posisi).getKet());
			DataPembayaran.setDenda(DataPembayaran.HitungDenda(DataPembayaran.getTanggalBayar(),Data.get(posisi).getGolongan()));
			Data.set(posisi, DataPembayaran);
			System.out.println("Data Berhasil Di update");
				
			System.out.print("\n   Apakah Anda ingin mencetak ulang struk pembayaran <Y/N> : ");
			String input = data.readLine();
			if (input.equalsIgnoreCase("Y")) {
				System.out.println("   ========================================================================");
				System.out.println("                               STRUK PEMBAYARAN");
				System.out.println("   ========================================================================");
				System.out.println("   No Pembayaran             : " + DataPembayaran.getPemabayaran());
				System.out.println("   Tanggal Pembayaran        : " + DataPembayaran.getTanggalBayar());
				System.out.println("   Total Konsumsi Daya (W)   : " + DataPembayaran.getDaya());
				System.out.println("   Total Konsumsi Daya (kWh) : " + (DataPembayaran.getDaya() / 1000));
				System.out.println("   ========================================================================");
				System.out.println("   DATA PELANGGAN                                                        ");
				System.out.println("   ========================================================================");
				System.out.println("   Nama                      : " + DataPembayaran.getNama());
				System.out.println("   Jenis Kelamin             : " + DataPembayaran.JenisKelamin(DataPembayaran.getJk()));
				System.out.println("   Alamat                    : " + DataPembayaran.getAlamat());
				System.out.println("   ========================================================================");
				System.out.println("   DATA GOLONGAN TARIF                                                  ");
				System.out.println("   ========================================================================");
				System.out.println("   Golongan                  : " + DataPembayaran.getGolongan());
				System.out.println("   Tarif                     : " + DataPembayaran.getTarif() + " (Rp/kWh)");
				System.out.println("   Keterangan                : " + DataPembayaran.getKet());
				System.out.println("   ========================================================================");
				System.out.println("                                  Tarif Konsumsi Daya : Rp. " + (DataPembayaran.getTarif() * (DataPembayaran.getDaya() / 1000)));
				System.out.println("                                  Denda               : Rp. " + DataPembayaran.getDenda());
				System.out.println("                                  Total Bayar         : Rp. " + ((DataPembayaran.getTarif() * (DataPembayaran.getDaya() / 1000)) + DataPembayaran.getDenda()));
				System.out.println("   ========================================================================\n");
			}
		}
	}
	public void DeletePembayaran(ArrayList<DataPembayaran> DataPembayaran) throws IOException{
		DataPembayaran Pembayaran = new DataPembayaran();
		String input;
		int posisi;
		System.out.print("Masukkan No Pembayaran : ");
		Pembayaran.setNoBayar(data.readLine());
		posisi = CariPembayaran(Pembayaran.getPemabayaran(), DataPembayaran);
		if(posisi == -1) System.out.println("Data yang akan di hapus tidak ditemukan ");
		else{
			System.out.println("Nama                             : " + DataPembayaran.get(posisi).getNama());
			System.out.println("Jenis Kelamin                    : " + Pembayaran.JenisKelamin(DataPembayaran.get(posisi).getJk()));
			System.out.println("Tanggal Lahir                    : " + DataPembayaran.get(posisi).getTglLahir());
			System.out.println("Alamat                           : " + DataPembayaran.get(posisi).getAlamat());
			System.out.println("Agama                            : " + DataPembayaran.get(posisi).getAgama());
			System.out.println("Handphone                        : " + DataPembayaran.get(posisi).getHp());
			System.out.println("Golongan Tarif                   : " + DataPembayaran.get(posisi).getGolongan());
			System.out.println("Tarif (Rp/kWh)                   : " + DataPembayaran.get(posisi).getTarif());
			System.out.println("Keterangan                       : " + DataPembayaran.get(posisi).getKet());
			System.out.println("Tanggal Bayar                    : " + DataPembayaran.get(posisi).getTanggalBayar());
			System.out.println("Besar Daya                       : " + DataPembayaran.get(posisi).getDaya());
			System.out.println("Denda                            : " + DataPembayaran.get(posisi).getDenda());
			System.out.println("Total Bayar                      : Rp. " + ((DataPembayaran.get(posisi).getTarif() * (DataPembayaran.get(posisi).getDaya() / 1000)) + DataPembayaran.get(posisi).getDenda()));
			
			System.out.print("\nApakah yakin akan menghapus data Pembayaran? <Y/N> : ");
			input = data.readLine();
			if (input.equalsIgnoreCase("Y")) {
				DataPembayaran.remove(posisi);
				System.out.println("Data Pembayaran Pelanggan telah berhasil dihapus");
			} else System.out.println("Data Pembayaran Pelanggan batal dihapus");
		}
	}
	public void DataPembayaran(ArrayList<DataPembayaran> data) throws IOException{
			System.out.println("\nData Pembayaran");
			System.out.println("========================================================\n");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| NO  |   No Pembayaran   | Kode Pelanggan     | Kode Petugas     | Tanggal Pembayaran      | Golongan       | Tarif (kWh) | Total Konsumsi Daya (kWh) | Denda   | Sub Total         | Total Bayar   |");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			for(int x = 0; x<data.size(); x++){
				System.out.printf("%-2s%-4s%-4s%-16s%-2s%-19s%-2s%-17s%-2s%-24s%-2s%-15s%-2s%-12s%-2s%-26s%-2s%-8s%-2s%-18s%-2s%-18s%-1s%n", 
				"|", x+1, "|", data.get(x).getPemabayaran(), "|", data.get(x).getKode(), "|", data.get(x).getKodePetugas(), "|"
				, data.get(x).getTanggalBayar(), "|", data.get(x).getGolongan(), "|", data.get(x).getTarif(), "|", data.get(x).getDaya() / 1000, "|", data.get(x).getDenda(), 
				"|", (data.get(x).getTarif() * (data.get(x).getDaya() / 1000)), "|", ((data.get(x).getTarif() * (data.get(x).getDaya() / 1000)) + data.get(x).getDenda()), "|");
			
			}
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
	}
}
