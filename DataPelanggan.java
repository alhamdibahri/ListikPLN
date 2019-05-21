public class DataPelanggan {
	private String kodePelanggan;
	private String nama;
	private String jk;
	private String tgl_lahir;
	private String alamat;
	private String agama;
	private String nohp;
	
	public void setkodePelanggan(String kodePelanggan){
		this.kodePelanggan = kodePelanggan;
	}
	public void setNama(String nama){
		this.nama = nama;
	}
	public void setJk(String jk){
		this.jk = jk;
	}
	public void setTglLahir(String tgl_lahir){
		this.tgl_lahir = tgl_lahir;
	}
	public void setAlamat(String alamat){
		this.alamat = alamat;
	}
	public void setAgama(String agama){
		this.agama = agama;
	}
	public void setHp(String nohp){
		this.nohp = nohp;
	}
	public String getKode(){
		return kodePelanggan;
	}
	public String getNama(){
		return nama;
	}
	public String getJk(){
		return jk;
	}
	public String getTglLahir(){
		return tgl_lahir;
	}
	public String getAlamat(){
		return alamat;
	}
	public String getAgama(){
		return agama;
	}
	public String getHp(){
		return nohp;
	}
	public String JenisKelamin(String data){
		String jk;
		if(data.equalsIgnoreCase("L"))
			jk = "Laki-Laki";
		else if(data.equalsIgnoreCase("P"))
			jk = "Perempuan";
		else
			jk = "-";
		return jk;
	}
}
