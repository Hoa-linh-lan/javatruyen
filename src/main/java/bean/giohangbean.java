package bean;

public class giohangbean {
	private String matruyen;
	private long gia;
	private long soluong;
	private long thanhtien;
	
	public String getMatruyen() {
		return matruyen;
	}
	public void setMatruyen(String matruyen) {
		this.matruyen = matruyen;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long slt) {
		this.soluong = slt;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public giohangbean(String matruyen, long gia, long soluong, long thanhtien) {
		super();
		this.matruyen = matruyen;
		this.gia = gia;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
	}
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
