package bean;

public class CTHDbean {
	private long maCTHD;
	private String masach;
	private int soluong;
	private long mahd;
	private boolean damua;
	public long getMaCTHD() {
		return maCTHD;
	}
	public void setMaCTHD(long maCTHD) {
		this.maCTHD = maCTHD;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public long getMahd() {
		return mahd;
	}
	public void setMahd(long mahd) {
		this.mahd = mahd;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public CTHDbean(long maCTHD, String masach, int soluong, long mahd, boolean damua) {
		super();
		this.maCTHD = maCTHD;
		this.masach = masach;
		this.soluong = soluong;
		this.mahd = mahd;
		this.damua = damua;
	}
	public CTHDbean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
