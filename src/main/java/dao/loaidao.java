package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	
	public ArrayList<loaibean> getloai() throws Exception{
		ArrayList<loaibean> ds=new ArrayList<loaibean>();
		coso cs = new coso();
		cs.ketnoi();
		String sql="select * from loai";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			String maloai=rs.getString("maloai");
			String tenloai=rs.getString("tenloai");
			loaibean loai = new loaibean(maloai, tenloai);
			ds.add(loai);		
		}
		rs.close();
		cs.cn.close();
		return ds;
	}
	
	public int them(String maloai ,String tenloai) throws Exception{
		coso cs = new coso();
		cs.ketnoi();
		String sql="insert into loai(maloai,tenloai) values (?,?)";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		int kq=cmd.executeUpdate();
		cmd.close();
		cs.cn.close();
		return kq;
	}
	
	public int xoa(String maloai) throws Exception{
		coso cs = new coso();
		cs.ketnoi();
		String sql="delete from loai where maloai=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		int kq=cmd.executeUpdate();
		cmd.close();
		cs.cn.close();
		return kq;
	}
	
	
	public int sua(String maloai ,String tenloai) throws Exception{
		coso cs = new coso();
		cs.ketnoi();
		String sql="update loai set tenloai=? where maloai=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		cmd.setString(2, maloai);
		cmd.setString(1, tenloai);
		int kq=cmd.executeUpdate();
		cmd.close();
		cs.cn.close();
		return kq;
	}
	
}
