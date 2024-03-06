package bean;

public class adminxacnhanbean {
	private	long maCTHD;
	private String hoten;
	private String tensach;
	private long soluongmua;
	private long gia;
	private long thanhtien;
	private boolean damua;
	public adminxacnhanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public adminxacnhanbean(long maCTHD, String hoten, String tensach, long soluongmua, long gia, long thanhtien,
			boolean damua) {
		super();
		this.maCTHD = maCTHD;
		this.hoten = hoten;
		this.tensach = tensach;
		this.soluongmua = soluongmua;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.damua = damua;
	}
	public long getMaCTHD() {
		return maCTHD;
	}
	public void setMaCTHD(long maCTHD) {
		this.maCTHD = maCTHD;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
	
	
}
