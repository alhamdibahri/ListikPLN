import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Petugas {
	private static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	private byte CariKode(String kodePetugas, ArrayList<DataPetugas> data){
		byte urutan = -1;
		for(byte i=0;  i < data.size(); i++){
			if(data.get(i).getKode().equals(kodePetugas)){
				urutan = i;
				break;
			}
		}
		return urutan;
	}
	public void inputData(ArrayList<DataPetugas> data, int urut) throws IOException{
		String kodePetugas;
		System.out.println("Tambah Data Petugas ");
		do{
			DataPetugas p = new DataPetugas();
			System.out.print(urut + ". Kode Petugas       : ");
			kodePetugas = in.readLine();
			p.setKodePetugas(kodePetugas);
			if(!p.getKode().equals("")){
				System.out.print("   Nama               : ");
				p.setNama(in.readLine());
				System.out.print("   Jenis Kelamin (L/P): ");
				p.setJk(in.readLine());
				System.out.print("   Tanggal Lahir      : ");
				p.setTglLahir(in.readLine());
				System.out.print("   Alamat             : ");
				p.setAlamat(in.readLine());
				System.out.print("   Agama              : ");
				p.setAgama(in.readLine());
				System.out.print("   No Handphone       : ");
				p.setHp(in.readLine());
				data.add(p);
				urut++;
			}
		}while(!kodePetugas.equals(""));
	}
	public void updateData(ArrayList<DataPetugas> data) throws IOException{
		DataPetugas p = new DataPetugas();
		int posisi = -1;
		System.out.println("\nMetode Merubah Data Pelanggan");
		System.out.println("-------------------------------");
		System.out.print("Masukkan Kode Petugas   : ");
		p.setKodePetugas(in.readLine());
		posisi = CariKode(p.getKode(),data);
		if(posisi == -1){
			System.out.println("\nData yang akan dirubah tidak ditemukan");
		}
		else{
			System.out.println("\nDATA DITEMUKAN\n");
			System.out.println("Nama Petugas   : " + data.get(posisi).getNama());
			System.out.println("Jenis Kelamin  : " + p.JenisKelamin(data.get(posisi).getJk()));
			System.out.println("Tanggal Lahir  : " + data.get(posisi).getTglLahir());
			System.out.println("Alamat         : " + data.get(posisi).getAlamat());
			System.out.println("Agama          : " + data.get(posisi).getAgama());
			System.out.println("No Handphone   : " + data.get(posisi).getHp());
				 
			System.out.println("\nDATA PERUBAHAN");
			System.out.print("Nama Petugas        : ");
			p.setNama(in.readLine());
			if(p.getNama().equals("")){
				p.setNama(data.get(posisi).getNama());
				System.out.println("                    : " + p.getNama());
				System.out.print("Jenis Kelamin (L/P) : ");
			}
			else System.out.print("Jenis Kelamin (L/P) : ");
			p.setJk(in.readLine());
			if(p.getJk().equals("")){
				p.setJk(data.get(posisi).getJk());
				System.out.println("                    : " + p.JenisKelamin(p.getJk()));
				System.out.print("Tanggal Lahir       : ");
			}
			else System.out.print("Tanggal Lahir       : ");
			p.setTglLahir(in.readLine());
			if(p.getTglLahir().equals("")){
				p.setTglLahir(data.get(posisi).getTglLahir());
				System.out.println("                    : " + p.getTglLahir());
				System.out.print("Alamat              : ");
			}
			else System.out.print("Alamat              : ");
			p.setAlamat(in.readLine());
			if(p.getAlamat().equals("")){
				p.setAlamat(data.get(posisi).getAlamat());
				System.out.println("                    : " + p.getAlamat());
				System.out.print("Agama               : ");
			}
			else System.out.print("Agama               : ");
			p.setAgama(in.readLine());
			if(p.getAgama().equals("")){
				p.setAgama(data.get(posisi).getAgama());
				System.out.println("                    : " + p.getAgama());
				System.out.print("No Handphone        : ");
			}
			else System.out.print("No Handphone        : ");
			p.setHp(in.readLine());
			if(p.getHp().equals("")){
				p.setHp(data.get(posisi).getHp());
				System.out.println("                    : " + p.getHp());
			}
			data.set(posisi, p);
			System.out.println("Data Petugas Berhasil Di ubah");
		}
	}
	public void deleteData(ArrayList<DataPetugas> data) throws IOException{
		DataPetugas p = new DataPetugas();
		int posisi = -1;
		String input;
		System.out.println("\nMetode Menghapus Data Petugas");
		System.out.println("-------------------------------");
		System.out.print("Masukkan Kode Petugas : ");
		p.setKodePetugas(in.readLine());
		posisi = CariKode(p.getKode(),data);
		if(posisi == -1){
			System.out.println("\nData yang akan dirubah tidak ditemukan");
		}
		else{
			System.out.println("\nDATA DITEMUKAN\n");
			System.out.println("Nama Petugas   : " + data.get(posisi).getNama());
			System.out.println("Jenis Kelamin  : " + p.JenisKelamin(data.get(posisi).getJk()));
			System.out.println("Tanggal Lahir  : " + data.get(posisi).getTglLahir());
			System.out.println("Alamat         : " + data.get(posisi).getAlamat());
			System.out.println("Agama          : " + data.get(posisi).getAgama());
			System.out.println("No Handphone   : " + data.get(posisi).getHp());
			
			System.out.print("\nApakah yakin akan menghapus data Petugas <Y/N> : ");
			input = in.readLine();
			if (input.equalsIgnoreCase("Y")){
				data.remove(posisi);
				System.out.println("Data Petugas telah berhasil dihapus");
			} else System.out.println("Data Petugas batal dihapus");
		}
		
	}
	public void DataPetugas(ArrayList<DataPetugas> data){
		DataPetugas p = new DataPetugas();
		System.out.println("\n Daftar Petugas");
		System.out.println("====================\n");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("| NO  |   Kode Petugas   | Nama Pelanggan             | Jenis Kelamin  | Tanggal Lahir      | Alamat                            | Agama   | No Handphone |");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int x = 0; x<data.size(); x++){
			System.out.printf("%-2s%-4s%-4s%-15s%-2s%-27s%-2s%-15s%-2s%-19s%-2s%-34s%-2s%-8s%-2s%-13s%-1s%n", 
			"|", x+1, "|", data.get(x).getKode(), "|", data.get(x).getNama(), "|", p.JenisKelamin(data.get(x).getJk()), "|"
			, data.get(x).getTglLahir(), "|", data.get(x).getAlamat(), "|", data.get(x).getAgama(), "|", data.get(x).getHp(), "|");
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
}
