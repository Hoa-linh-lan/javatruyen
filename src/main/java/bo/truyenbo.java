package bo;

import java.util.ArrayList;


import bean.truyenbean;

import dao.truyendao;

public class truyenbo {
	truyendao tdao = new truyendao();
	ArrayList<truyenbean> ds;
	public ArrayList<truyenbean> gettruyen() throws Exception{
		ds = tdao.gettruyen();
		return ds;
	}
	public ArrayList<truyenbean> timma(String maloai) {
		ArrayList<truyenbean> tam = new ArrayList<truyenbean>();//nghỉ cơm nước cái nhé //pp
		// pai
		for (truyenbean truyen:ds)
		{
			if(truyen.getMaloai().toLowerCase().contains(maloai.toLowerCase()))
			{
				tam.add(truyen);
			}
		}
		return tam;
	}
	public ArrayList<truyenbean> tim(String key) {
		ArrayList<truyenbean> tam = new ArrayList<truyenbean>();
		for (truyenbean truyen:ds)
		{
			if (truyen.getTentruyen().toLowerCase()
					.contains(key.toLowerCase())/*
												 * || truyen.getTacgia().toLowerCase().contains(key.toLowerCase())
												 */)
			{
				tam.add(truyen);
			}
		}
		return tam;
	}
	
	public ArrayList<truyenbean> ND(String matruyen) throws Exception{
		ArrayList<truyenbean> tam = new ArrayList<truyenbean>();
		for(truyenbean s : ds)
			if(s.getMatruyen().equals(matruyen))
				tam.add(s);
		return tam;
	}
	public int them(String matruyen, String tentruyen, String tacgia, long gia, long soluong, long sochuong,
			String anh, String maloai, String vanan) throws Exception {
		return tdao.them(matruyen, tentruyen, tacgia, gia, soluong, sochuong, anh, maloai, vanan);
	}
	
	public int capnhat(String matruyen, String tentruyen, String tacgia, long gia, long soluong, long sochuong,
			String anh, String maloai, String vanan) throws Exception {
		return tdao.capnhat(matruyen, tentruyen, tacgia, gia, soluong, sochuong, anh, maloai, vanan);
	}
	
	public int Xoa(String matruyen) throws Exception {
		return tdao.Xoa(matruyen);
	}
}
