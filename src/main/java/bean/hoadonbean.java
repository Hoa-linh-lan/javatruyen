package bean;

import java.util.Date;

public class hoadonbean {
	private long mahd;
	private long makh;
	private Date ngaymua;
	private boolean damua;
	public long getMahd() {
		return mahd;
	}
	public void setMahd(long mahd) {
		this.mahd = mahd;
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
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public hoadonbean(long mahd, long makh, Date ngaymua, boolean damua) {
		super();
		this.mahd = mahd;
		this.makh = makh;
		this.ngaymua = ngaymua;
		this.damua = damua;
	}
	public hoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
