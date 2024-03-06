package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.truyenbean;

public class truyendao {
	ArrayList<truyenbean> ds=new ArrayList<truyenbean>();
	public ArrayList<truyenbean> gettruyen() throws Exception{
		coso cs = new coso();
		cs.ketnoi();
		String sql="select * from truyen";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			String matruyen=rs.getString("matruyen");
			String tentruyen=rs.getString("tentruyen");
			String tacgia=rs.getString("tacgia");
			Long gia=rs.getLong("gia");	
			Long soluong=rs.getLong("soluong");	
			Long sochuong=rs.getLong("sochuong");	
			String anh=rs.getString("anh");
			String maloai=rs.getString("maloai");
			String vanan=rs.getString("vanan");
			truyenbean truyen = new truyenbean(matruyen, tentruyen, tacgia, gia, soluong, sochuong, anh, maloai, vanan);
			ds.add(truyen);
		}
		rs.close();
		cs.cn.close();
		return ds;
	}
	public int them(String matruyen, String tentruyen, String tacgia, long gia, long soluong, long sochuong,
			String anh, String maloai, String vanan) throws Exception {
		coso cs = new coso();
		cs.ketnoi();
		//b1: Tao cau lenh sql
		String sql="insert into truyen(matruyen, tentruyen, tacgia, gia, soluong,sochuong ,anh, maloai,vanan, ngaynhap) values (?,?,?,?,?,?,?,?,?,?)";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		cmd.setString(1,matruyen);
		cmd.setString(2,tentruyen);
		cmd.setString(3,tacgia);
		cmd.setLong(4,gia);
		cmd.setLong(5,soluong);
		cmd.setLong(6,sochuong);
		cmd.setString(7,anh);
		cmd.setString(8,maloai);
		cmd.setString(9,vanan);
		Date n1 = new Date();//ngay gio hien tai
		SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd");
		String tam= dd.format(n1);
		Date n2=dd.parse(tam);		
		cmd.setDate(10,new java.sql.Date(n2.getTime()));
		//b3: thuc hien cau lenh
		int kq=cmd.executeUpdate();
		cmd.close();
		cs.cn.close();
		return kq;
	}
	public int capnhat(String matruyen, String tentruyen, String tacgia, long gia, long soluong, long sochuong,
			String anh, String maloai, String vanan) throws Exception {
		coso cs = new coso();
		cs.ketnoi();
		//b1: Tao cau lenh sql
		String sql="update truyen set tentruyen=?,tacgia=?, gia=?, soluong=?,sochuong=?, anh=?, maloai=?, vanan=? where matruyen=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		cmd.setString(9,matruyen);
		cmd.setString(1,tentruyen);
		cmd.setString(2,tacgia);
		cmd.setLong(3,gia);
		cmd.setLong(4,soluong);
		cmd.setLong(5,sochuong);
		cmd.setString(6,anh);
		cmd.setString(7,maloai);
		cmd.setString(8,vanan);
		//b3: thuc hien cau lenh
		int kq=cmd.executeUpdate();
		cmd.close();
		cs.cn.close();
		return kq;
	}
	public int Xoa(String matruyen) throws Exception {
		coso cs = new coso();
		cs.ketnoi();
		//b1: Tao cau lenh sql
		String sql="delete from truyen where matruyen=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		cmd.setString(1,matruyen);
		//b3: thuc hien cau lenh
		int kq=cmd.executeUpdate();
		cmd.close();
		cs.cn.close();
		return kq;
	}
	
}
