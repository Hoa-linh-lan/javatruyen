package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.khachhangbean;

public class hoadondao {
	public int them (Long makh) throws Exception{
		coso cs = new coso();
		cs.ketnoi();
		String sql="insert into hoadon(makh,NgayMua,damua) values (?,?,?)";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		Date n1 = new Date();//ngay gio hien tai
		SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd");
		String tam= dd.format(n1);
		Date n2=dd.parse(tam);		
		cmd.setDate(2,new java.sql.Date(n2.getTime()));
		cmd.setBoolean(3, false);
		int kq=cmd.executeUpdate();
		cmd.close();
		cs.cn.close();
		return kq;
	}
	public long getmaxhd () throws Exception{
		coso cs = new coso();
		cs.ketnoi();
		String sql="select MAX(mahoadon) from hoadon ";
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long max =0;
		if(rs.next())
		{
			max=rs.getLong(1);
		}
		rs.close();
		cs.cn.close();
		return max;
	}
}
