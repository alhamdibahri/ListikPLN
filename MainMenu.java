import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MainMenu {
	private static BufferedReader data=new BufferedReader(new InputStreamReader(System.in));
	
	private static ArrayList<DataPelanggan> DataPelanggan = new ArrayList<DataPelanggan>();
	private static Pelanggan Pelanggan = new Pelanggan();
	
	private static ArrayList<DataPetugas> DataPetugas = new ArrayList<DataPetugas>();
	private static Petugas Petugas = new Petugas();
	
	private static ArrayList<DataJenisTarif> DataTarif = new ArrayList<DataJenisTarif>();
	private static AJenisTarif AJenisTarif = new AJenisTarif(DataTarif);
	
	private static ArrayList<PilihTarif> PilihTarif = new ArrayList<PilihTarif>();
	private static APilihTarif APilihTarif = new APilihTarif();
	
	private static ArrayList<DataPembayaran> DataPembayaran = new ArrayList<DataPembayaran>();
	private static Pembayaran Pembayaran = new Pembayaran();
	
	private static Laporan laporan = new Laporan();
	
public static void main(String[] args) throws IOException {
		
		String pilih, pilihsub = "";
		
		do {            
            System.out.println();            
            System.out.println("_________________________________");            
            System.out.println("  SISTEM PEMBAYARAN LISTRIK ");       
            System.out.println("__________________________________");
            System.out.println("1 - Petugas");            
            System.out.println("2 - Pelanggan");            
            System.out.println("3 - Tarif Dan jenis");            
            System.out.println("4 - Pilih Tarif Listrik"); 
            System.out.println("5 - Pembayaran Listrik"); 
            System.out.println("6 - Laporan"); 
            System.out.println("7 - Keluar"); 
            System.out.println("_____________________________________");             
            System.out.print("Masukkan Pilihan : "); 
           
            pilih = data.readLine();
            
            do {
            	switch(pilih) {            
            	case "1" :      
	            	System.out.println();            
	                System.out.println("---------------------------");            
	                System.out.println("  SUB MENU PETUGAS");       
	                System.out.println("---------------------------");
	                System.out.println("1 - Input Petugas");  
	                System.out.println("2 - Update Petugas");
	                System.out.println("3 - Delete Petugas");
	                System.out.println("4 - Data Petugas");                        
	                System.out.println("5 - kembali");            
	                System.out.println("---------------------------");             
	                break;
            	case "2" : 
	            	System.out.println();            
	                System.out.println("---------------------------");            
	                System.out.println(" SUB MENU PELANGGAN");       
	                System.out.println("---------------------------");
	                System.out.println("1 - Input Pelanggan");            
	                System.out.println("2 - Update Pelanggan");
	                System.out.println("3 - Delete Pelanggan");
	                System.out.println("4 - Data Pelanggan");                        
	                System.out.println("5 - kembali");            
	                System.out.println("---------------------------");
	                break;
            	case "3" :
            		AJenisTarif.DataTarif(DataTarif);
            		break;
            	case "4" :
	            	System.out.println();            
	                System.out.println("--------------------");            
	                System.out.println("   SUB MENU Tarif");       
	                System.out.println("--------------------");
	                System.out.println("1 - Input Tarif");            
	                System.out.println("2 - Update Tarif");
	                System.out.println("3 - Delete Tarif");
	                System.out.println("4 - Data Tarif");                        
	                System.out.println("5 - kembali");            
	                System.out.println("--------------------");
	                break;
                case "5" :
	            	System.out.println();            
	                System.out.println("--------------------");            
	                System.out.println("   SUB MENU Pembayaran");       
	                System.out.println("--------------------");
	                System.out.println("1 - Input Pembayaran");            
	                System.out.println("2 - Update Pembayaran");
	                System.out.println("3 - Delete Pembayaran");
	                System.out.println("4 - Data Pembayaran");
	                System.out.println("5 - kembali");            
	                System.out.println("--------------------");
	                break;
                case "6" :
                	laporan.LaporanPembayaran(DataPembayaran);
                	break;
            	case "7" :
            		System.out.println("Anda Keluar");
            		break;
            	default:                
            		System.out.println("-----------");                
            		System.out.println("Salah Pilih");                
            		System.out.println("-----------");        
            	}
            
            	if (pilih.equals("1") | pilih.equals("2")  | pilih.equals("4") | pilih.equals("5"))  {
            		System.out.print("Masukkan Pilihan : "); 
            		pilihsub = data.readLine();
            		pilihmenu(pilih, pilihsub);
            	}
            	else pilihsub = "5";
            } while (!pilihsub.equals("5"));
            
        } while (!pilih.equals("7"));
	}
	
	private static void pilihmenu(String pil, String pilsub) throws IOException {
        if (pil.equals("1")) {
        	switch(pilsub) {            
            case "1" :      
            	Petugas.inputData(DataPetugas, DataPetugas.size() + 1);;
                break;
            case "2" :      
            	if (DataPetugas.size() != 0) Petugas.updateData(DataPetugas);
    			else System.out.print("Data Kosong ..... !!!");
            	break;
            case "3" :      
            	if (DataPetugas.size() != 0) Petugas.deleteData(DataPetugas);
    			else System.out.print("Data Kosong ..... !!!");
            	break;
            case "4" :      
            	if (DataPetugas.size() != 0) Petugas.DataPetugas(DataPetugas);
    			else System.out.print("Data Kosong ..... !!!");
            	break;
            case "5":                
                System.out.println("Anda Kembali");            
                break;             
            default:                
                System.out.println("-----------");                
                System.out.println("Salah Pilih");                
                System.out.println("-----------");        
        	}
        }
        else if (pil.equals("2")) {
        	switch(pilsub) {            
            case "1" :      
            	Pelanggan.inputData(DataPelanggan, DataPelanggan.size() + 1);;
                break;
            case "2" :      
            	if (DataPelanggan.size() != 0) Pelanggan.updateData(DataPelanggan);
    			else System.out.print("Data Kosong ..... !!!");
            	break;
            case "3" :      
            	if (DataPelanggan.size() != 0) Pelanggan.deleteData(DataPelanggan);
    			else System.out.print("Data Kosong ..... !!!");
            	break;
            case "4" :      
            	if (DataPelanggan.size() != 0) Pelanggan.DataPelanggan(DataPelanggan);
    			else System.out.print("Data Kosong ..... !!!");
            	break;
            case "5":                
                System.out.println("Anda Kembali");            
                break;             
            default:                
                System.out.println("-----------");                
                System.out.println("Salah Pilih");                
                System.out.println("-----------");        
        	}
                 
        }
	 else if (pil.equals("4")) {
		 switch(pilsub) {            
         case "1" :      
        	 APilihTarif.inputData(DataPelanggan, DataTarif, PilihTarif, PilihTarif.size() + 1);
             break;
         case "2" :      
         	if (PilihTarif.size() != 0) APilihTarif.UpdateData(PilihTarif, DataTarif);
 			else System.out.print("Data Kosong ..... !!!");
         	break;
         case "3" :      
         	if (PilihTarif.size() != 0) APilihTarif.DeleteData(PilihTarif);
 			else System.out.print("Data Kosong ..... !!!");
         	break;
         case "4" :      
         	if (PilihTarif.size() != 0) APilihTarif.DataPilihTarif(PilihTarif);
 			else System.out.print("Data Kosong ..... !!!");
         	break;
         case "5":                
             System.out.println("Anda Kembali");            
             break;             
         default:                
             System.out.println("-----------");                
             System.out.println("Salah Pilih");                
             System.out.println("-----------");        
     	}
       }
	 else if (pil.equals("5")) {
		 switch(pilsub) {            
         case "1" :      
        	 Pembayaran.InputPembayaran(PilihTarif, DataPetugas, DataPembayaran, DataPembayaran.size() + 1);
             break;
         case "2" :      
         	if (DataPembayaran.size() != 0) Pembayaran.UpdatePembayaran(DataPembayaran);
 			else System.out.print("Data Kosong ..... !!!");
         	break;
         case "3" :      
         	if (DataPembayaran.size() != 0) Pembayaran.DeletePembayaran(DataPembayaran);
 			else System.out.print("Data Kosong ..... !!!");
         	break;
         case "4" :      
          	if (DataPembayaran.size() != 0) Pembayaran.DataPembayaran(DataPembayaran);
  			else System.out.print("Data Kosong ..... !!!");
          	break;
         case "5":                
             System.out.println("Anda Kembali");
             break;
         default:                
             System.out.println("-----------");                
             System.out.println("Salah Pilih");                
             System.out.println("-----------");        
     	}
       }
	}
	}

