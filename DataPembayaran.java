public class DataPembayaran extends PilihTarif{
	private String NoPembayaran;
	private String KodePetugas;
	private String NamaPetugas;
	private String TanggalBayar;
	private int Daya;
	private double Denda;
	
	public void setNoBayar(String NoPembayaran){
		this.NoPembayaran = NoPembayaran;
	}
	public String getPemabayaran(){
		return this.NoPembayaran;
	}
	public void setKodePetugas(String KodePetugas){
		this.KodePetugas = KodePetugas;
	}
	public String getKodePetugas(){
		return this.KodePetugas;
	}
	public void setNamaPetugas(String NamaPetugas){
		this.NamaPetugas = NamaPetugas;
	}
	public String getNamaPetugas(){
		return this.NamaPetugas;
	}
	public void setTanggalBayar(String TanggalBayar){
		this.TanggalBayar = TanggalBayar;
	}
	public String getTanggalBayar(){
		return this.TanggalBayar;
	}
	public void setDenda(double Denda){
		this.Denda = Denda;
	}
	public double getDenda(){
		return this.Denda;
	}
	public void setDaya(int Daya){
		this.Daya = Daya;
	}
	public int getDaya(){
		return this.Daya;
	}
	public double HitungDenda(String Date1, String golongan) {
		int tglPatokan = 20;
		int tglbayar = Integer.parseInt(Date1.substring(0,2));
		double denda = 0;
		if(tglbayar > tglPatokan){
			if(golongan.equalsIgnoreCase("R-1/450") || golongan.equalsIgnoreCase("R-1/900")
			|| golongan.equalsIgnoreCase("R-1/900 RTM")) denda = 3000;
			else if(golongan.equalsIgnoreCase("R-1/1300")) denda = 5000;
		}
		else{
			denda = 0;
		}
		return denda;
	}
}
