package bean;

public class truyenbean {
	private	String matruyen;
	private String tentruyen;
	private String tacgia;
	private long gia;
	private long soluong;
	private long sochuong;
	private String anh;
	private String maloai;
	private String vanan;
	public truyenbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public truyenbean(String matruyen, String tentruyen, String tacgia, long gia, long soluong, long sochuong,
			String anh, String maloai, String vanan) {
		super();
		this.matruyen = matruyen;
		this.tentruyen = tentruyen;
		this.tacgia = tacgia;
		this.gia = gia;
		this.soluong = soluong;
		this.sochuong = sochuong;
		this.anh = anh;
		this.maloai = maloai;
		this.vanan = vanan;
	}
	public String getMatruyen() {
		return matruyen;
	}
	public void setMatruyen(String matruyen) {
		this.matruyen = matruyen;
	}
	public String getTentruyen() {
		return tentruyen;
	}
	public void setTentruyen(String tentruyen) {
		this.tentruyen = tentruyen;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
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
	public long getSochuong() {
		return sochuong;
	}
	public void setSochuong(long sochuong) {
		this.sochuong = sochuong;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getVanan() {
		return vanan;
	}
	public void setVanan(String vanan) {
		this.vanan = vanan;
	}
	
}
