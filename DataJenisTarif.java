import java.util.ArrayList;
public class DataJenisTarif {
	private String golongan;
	private double tarif;
	private String keterangan;
	public DataJenisTarif(String golongan,double tarif,String keterangan){
		this.golongan = golongan;
		this.tarif = tarif;
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
class AJenisTarif{
	public AJenisTarif(){
		
	}
	public AJenisTarif(ArrayList<DataJenisTarif> data){
		DataJenisTarif m = new DataJenisTarif("R-1/450",415,"Subsidi");
		data.add(m);
		DataJenisTarif m1 = new DataJenisTarif("R-1/900",568,"Subsidi");
		data.add(m1);
		DataJenisTarif m2 = new DataJenisTarif("R-1/900 RTM",1352,"Non Subsidi");
		data.add(m2);
		DataJenisTarif m3 = new DataJenisTarif("R-1/1300",1467.28,"Non Subsidi");
		data.add(m3);
	}
	public void DataTarif(ArrayList<DataJenisTarif> data){
		System.out.println("\n Daftar Tarif");
		System.out.println("====================");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| NO  |   Golongan     | Tarif (Rp/kWh)             | Keterangan  |");
		System.out.println("-------------------------------------------------------------------");
		for(int x = 0; x<data.size(); x++){
			System.out.printf("%-2s%-4s%-4s%-13s%-2s%-27s%-2s%-12s%-1s%n", 
			"|", x+1, "|", data.get(x).getGolongan(), "|", data.get(x).getTarif(), "|" , data.get(x).getKet(), "|");
		}
		System.out.println("-------------------------------------------------------------------");
	}
}