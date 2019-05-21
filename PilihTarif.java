import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PilihTarif extends DataPelanggan{
	private String golongan;
	private double tarif;
	private String keterangan;
	
	public void setGolongan(String golongan){
		this.golongan = golongan;
	}
	public void setTarif(double tarif){
		this.tarif = tarif;
	}
	public void setKet(String keterangan){
		this.keterangan = keterangan;
	}
	public String getGolongan(){
		return this.golongan;
	}
	public double getTarif(){
		return this.tarif;
	}
	public String getKet(){
		return this.keterangan;
	}
}
class APilihTarif{
	private static BufferedReader data =new BufferedReader(new InputStreamReader(System.in));
	private byte CariPelanggan(String kodePelanggan, ArrayList<DataPelanggan> Pelanggan) {        
		byte urutan = -1;
		for (byte i = 0; i < Pelanggan.size(); i++) {
			if (Pelanggan.get(i).getKode().equalsIgnoreCase(kodePelanggan)) {
				urutan = i;
				break;
			}
		}
		return urutan;
    }
	private byte CariTarif(String Golongan, ArrayList<DataJenisTarif> Mjenis) {        
		byte urutan = -1;
		for (byte i = 0; i < Mjenis.size(); i++) {
			if (Mjenis.get(i).getGolongan().equalsIgnoreCase(Golongan)) {
				urutan = i;
				break;
			}	
		}
		return urutan;
    }
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
	public void inputData(ArrayList<DataPelanggan> dataPelanggan,ArrayList<DataJenisTarif> Mjenis, ArrayList<PilihTarif> dataTarif, int Urutan) throws IOException{
		int posisi = -1;
		int posisiJenis = -1;
		int posisiTarif = -1;
		String KodePelanggan;
		System.out.println("Masukkan Data Pelanggan ");
		do {
			PilihTarif pilihTarif = new PilihTarif();
			AJenisTarif jenis = new AJenisTarif();
			System.out.print(Urutan + ". Kode Pelanggan      : ");
			KodePelanggan = data.readLine();
			pilihTarif.setkodePelanggan(KodePelanggan);
			posisi = CariPelanggan(pilihTarif.getKode(), dataPelanggan);
			if(!pilihTarif.getKode().equals("")){
				if (posisi == -1)
					System.out.println("   Data Pelanggan tidak ada !!!");
				else {
					posisiTarif = CariTarifP(pilihTarif.getKode(), dataTarif);
					if (posisiTarif != -1) System.out.println("Pelanggan sudah mempunyai Tarif Listrik");
					else{
						System.out.println("   Nama                : " + dataPelanggan.get(posisi).getNama());
						System.out.println("   Jenis Kelamin       : " + pilihTarif.JenisKelamin(dataPelanggan.get(posisi).getJk()));
						System.out.println("   Tanggal Lahir       : " + dataPelanggan.get(posisi).getTglLahir());
						System.out.println("   Alamat              : " + dataPelanggan.get(posisi).getAlamat());
						System.out.println("   Agama               : " + dataPelanggan.get(posisi).getAgama());
						System.out.println("   Handphone           : " + dataPelanggan.get(posisi).getHp());
						pilihTarif.setNama(dataPelanggan.get(posisi).getNama());
						pilihTarif.setJk(dataPelanggan.get(posisi).getJk());
						pilihTarif.setTglLahir(dataPelanggan.get(posisi).getTglLahir());
						pilihTarif.setAlamat(dataPelanggan.get(posisi).getAlamat());
						pilihTarif.setAgama(dataPelanggan.get(posisi).getAgama());
						pilihTarif.setHp(dataPelanggan.get(posisi).getHp());
						
						jenis.DataTarif(Mjenis);
						System.out.print("Pilih Golongan Tarif   : ");
						pilihTarif.setGolongan(data.readLine());
						posisiJenis = CariTarif(pilihTarif.getGolongan(), Mjenis);
						if (posisiJenis == -1) System.out.println("Maaf Golongan Tarif Tidak tersedia !!!");
						else{
							pilihTarif.setTarif(Mjenis.get(posisiJenis).getTarif());
							System.out.println("Tarif                  : " + pilihTarif.getTarif());
							pilihTarif.setKet(Mjenis.get(posisiJenis).getKet());
							System.out.println("Keterangan             : " + pilihTarif.getKet());
							dataTarif.add(pilihTarif);
							System.out.println("\nData Berhasil di simpan !!!");
							Urutan++;
						}
					}
				}
			}
		} while (!KodePelanggan.equals(""));
	}
	public void UpdateData(ArrayList<PilihTarif> dataTarif, ArrayList<DataJenisTarif> Mjenis) throws IOException {	
		PilihTarif tarif = new PilihTarif();
		int posisi = -1;
		int posisiTarif = -1;
		
		System.out.println("\nMetode merubah data Golongan tarif pelanggan");
		System.out.print("Masukkan Kode Pelanggan : ");
		tarif.setkodePelanggan(data.readLine());
		posisi = CariTarifP(tarif.getKode(), dataTarif);
		if(posisi == -1) System.out.println("Data yang akan	 dirubah tidak ditemukan ");
		else{
			AJenisTarif a = new AJenisTarif();
			System.out.println("Kode Pelanggan : " + dataTarif.get(posisi).getKode());
			System.out.println("Nama Pelanggan : " + dataTarif.get(posisi).getNama());
			System.out.println("Jenis Kelamin  : " + tarif.JenisKelamin(dataTarif.get(posisi).getJk()));
			System.out.println("Tanggal Lahir  : " + dataTarif.get(posisi).getTglLahir());
			System.out.println("Alamat         : " + dataTarif.get(posisi).getAlamat());
			System.out.println("Agama          : " + dataTarif.get(posisi).getAgama());
			System.out.println("No Handphone   : " + dataTarif.get(posisi).getHp());
			System.out.println("Golongan Tarif : " + dataTarif.get(posisi).getGolongan());
			System.out.println("Tarif          : " + dataTarif.get(posisi).getTarif());
			System.out.println("Keterangan     : " + dataTarif.get(posisi).getKet());
			
			a.DataTarif(Mjenis);
			System.out.println("\nDATA PERUBAHAN");
			System.out.print("Golongan Tarif : ");
			tarif.setGolongan(data.readLine());
			posisiTarif = CariTarif(tarif.getGolongan(), Mjenis);
			if(posisiTarif == -1) System.out.println("Golongan Tarif tidak tersedia !");
			else
			{
				if(tarif.getGolongan().equals("")){
					tarif.setGolongan(dataTarif.get(posisi).getGolongan());
					tarif.setTarif(dataTarif.get(posisi).getTarif());
					tarif.setKet(dataTarif.get(posisi).getKet());
					System.out.println("Golongan Tarif : " + tarif.getGolongan());
					System.out.println("Tarif          : " + tarif.getTarif());
					System.out.println("Keterangan     : " + tarif.getKet());
				}
				else{
					tarif.setkodePelanggan(dataTarif.get(posisi).getKode());
					tarif.setNama(dataTarif.get(posisi).getNama());
					tarif.setJk(dataTarif.get(posisi).getJk());
					tarif.setTglLahir(dataTarif.get(posisi).getTglLahir());
					tarif.setAlamat(dataTarif.get(posisi).getAlamat());
					tarif.setAgama(dataTarif.get(posisi).getAgama());
					tarif.setHp(dataTarif.get(posisi).getHp());
					tarif.setTarif(Mjenis.get(posisiTarif).getTarif());
					tarif.setKet(Mjenis.get(posisiTarif).getKet());
					dataTarif.set(posisi, tarif);
					System.out.println("Data berhasil di ubah ");	
				}
			}
		}
	}
	public void DeleteData(ArrayList<PilihTarif> dataTarif) throws IOException{
		PilihTarif tarif = new PilihTarif();
		String input;
		int posisi;
		System.out.print("Masukkan Kode Pelanggan : ");
		tarif.setkodePelanggan(data.readLine());
		posisi = CariTarifP(tarif.getKode(), dataTarif);
		if(posisi == -1) System.out.println("Data yang akan di hapus tidak ditemukan ");
		else{
			System.out.println("Kode Pelanggan : " + dataTarif.get(posisi).getKode());
			System.out.println("Nama Pelanggan : " + dataTarif.get(posisi).getNama());
			System.out.println("Jenis Kelamin  : " + tarif.JenisKelamin(dataTarif.get(posisi).getJk()));
			System.out.println("Tanggal Lahir  : " + dataTarif.get(posisi).getTglLahir());
			System.out.println("Alamat         : " + dataTarif.get(posisi).getAlamat());
			System.out.println("Agama          : " + dataTarif.get(posisi).getAgama());
			System.out.println("No Handphone   : " + dataTarif.get(posisi).getHp());
			System.out.println("Golongan Tarif : " + dataTarif.get(posisi).getGolongan());
			System.out.println("Tarif          : " + dataTarif.get(posisi).getTarif());
			System.out.println("Keterangan     : " + dataTarif.get(posisi).getKet());
			
			System.out.print("\nApakah yakin akan menghapus data tarif pelanggan? <Y/N> ");
			input = data.readLine();
			if (input.equalsIgnoreCase("Y")) {
				dataTarif.remove(posisi);
				System.out.print("Data Tarif Pelanggan telah berhasil dihapus");
			} else System.out.println("Data Tarif Pelanggan batal dihapus");
		}
		
	}
	public void DataPilihTarif(ArrayList<PilihTarif> data){
		System.out.println("\nDaftar Pelanggan Beserta Golongan Tarif");
		System.out.println("==============================================\n");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println("| NO  | Nama                       | Alamat                            | Golongan       | Tarif (Rp/kWh) | Keterangan  |");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		for(int x = 0; x<data.size(); x++){
			System.out.printf("%-2s%-4s%-2s%-27s%-2s%-34s%-2s%-15s%-2s%-15s%-2s%-12s%-1s%n", 
			"|", x+1, "|", data.get(x).getNama(), "|", data.get(x).getAlamat(), "|" , 
			data.get(x).getGolongan(), "|", data.get(x).getTarif(), "|", data.get(x).getKet(), "|");
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
	}
}
