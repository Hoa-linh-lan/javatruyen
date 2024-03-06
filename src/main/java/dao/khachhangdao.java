package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;

public class khachhangdao {
	
	public khachhangbean ktdn(String tendn,String pass) throws Exception{
		coso cs = new coso();
		cs.ketnoi();
		String sql="select * from khachhang where tendn=? and pass=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		cmd.setString(1, tendn);
		cmd.setString(2, pass);
		ResultSet rs= cmd.executeQuery();
		khachhangbean kh=null;
		if(rs.next()) {
			long makh =rs.getLong("makh");
			String hoten=rs.getString("hoten"); 
			String diachi=rs.getString("diachi"); 
			String sodt = rs.getString("sodt"); 
			String email = rs.getString("email"); 
			String tendnn = rs.getString("tendn");  
			String passs = rs.getString("pass"); 
			kh = new khachhangbean(makh, hoten, diachi, sodt, email, tendnn, passs);
		}
		return kh;
	}
	public int dangky(String hoten, String diachi, String sodt, String email, String tendn, String pass) throws Exception {
		//b1: Tao cau lenh sql
		String sql="insert into khachhang(hoten,diachi,sodt,email,tendn,pass) values (?,?,?,?,?,?)";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		cmd.setString(1,hoten);
		cmd.setString(2,diachi);
		cmd.setString(3,sodt);
		cmd.setString(4,email);
		cmd.setString(5,tendn);
		cmd.setString(6,pass);
		//b3: thuc hien cau lenh
		return cmd.executeUpdate();
	}
	public khachhangbean kttk(String tendn) throws Exception{
		coso cs = new coso();
		cs.ketnoi();
		String sql="select * from khachhang where tendn=? ";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		cmd.setString(1, tendn);
		ResultSet rs= cmd.executeQuery();
		khachhangbean kh=null;
		if(rs.next()) {
			long makh =rs.getLong("makh");
			String hoten=rs.getString("hoten"); 
			String diachi=rs.getString("diachi"); 
			String sodt = rs.getString("sodt"); 
			String email = rs.getString("email"); 
			String tendnn = rs.getString("tendn");  
			String passs = rs.getString("pass"); 
			kh = new khachhangbean(makh, hoten, diachi, sodt, email, tendnn, passs);
		}
		return kh;
	}
}
