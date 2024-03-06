package bean;

import java.util.Date;

public class lichsuMHbean {
	private	String masach;
	private String tensach;
	private long gia;
	private long soluong;
	private boolean damua;
	private long thanhtien;
	private	long makh;
	private Date ngaymua;
	private String anh;
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public lichsuMHbean(String masach, String tensach, long gia, long soluong, boolean damua, long thanhtien, long makh,
			Date ngaymua, String anh) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.gia = gia;
		this.soluong = soluong;
		this.damua = damua;
		this.thanhtien = thanhtien;
		this.makh = makh;
		this.ngaymua = ngaymua;
		this.anh = anh;
	}
	public lichsuMHbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
