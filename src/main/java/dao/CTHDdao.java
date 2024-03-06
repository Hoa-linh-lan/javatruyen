package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import bean.adminxacnhanbean;

public class CTHDdao {
	public int them(String matruyen, int soluong, long mahd) throws Exception {
		coso cs = new coso();
		cs.ketnoi();
		String sql = "insert into cthd (matruyen,soluongmua,mahoadon,damua) values(?,?,?,?)";
		// b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd = coso.cn.prepareStatement(sql);
		cmd.setString(1, matruyen);
		cmd.setInt(2, soluong);
		cmd.setLong(3, mahd);
		cmd.setBoolean(4, false);
		int kq = cmd.executeUpdate();
		cmd.close();
		cs.cn.close();
		return kq;
	}

	public int Sua(long maCTHD) throws Exception {
		coso cs = new coso();
		cs.ketnoi();
		String sql = "update cthd set damua = 1 where macthd = ?";
		// b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd = coso.cn.prepareStatement(sql);
		cmd.setLong(1, maCTHD);
		int kq = cmd.executeUpdate();
		cmd.close();
		cs.cn.close();
		return kq;
	}

	public ArrayList<adminxacnhanbean> getxacnhan() throws Exception {
		ArrayList<adminxacnhanbean> ds=new ArrayList<adminxacnhanbean>();
		coso cs = new coso();
		cs.ketnoi();
		String sql="select * from vAdminXacNhan";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			 long maCTHD=rs.getLong("macthd");
			 String hoten=rs.getString("hoten");
			 String tensach=rs.getString("tentruyen");
			 long soluongmua=rs.getLong("soluongmua");
			 long gia=rs.getLong("gia");
			 long thanhtien=rs.getLong("thanhtien");
			 boolean damua =rs.getBoolean("damua");
		  ds.add(new adminxacnhanbean(maCTHD, hoten, tensach, soluongmua, gia, thanhtien, damua));
					
		}
		rs.close();
		cs.cn.close();
		return ds;
	}
	public int Xoa(long macthd) throws Exception {
		coso cs = new coso();
		cs.ketnoi();
		//b1: Tao cau lenh sql
		String sql="delete from cthd where macthd=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		cmd.setLong(1,macthd);
		//b3: thuc hien cau lenh
		return cmd.executeUpdate();
	}
}
