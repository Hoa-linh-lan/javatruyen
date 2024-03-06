package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.lichsuMHbean;



public class lichsuMHdao {
	ArrayList<lichsuMHbean> ds=new ArrayList<lichsuMHbean>();
	public ArrayList<lichsuMHbean> getlichsu(Long makh) throws Exception{
		coso cs = new coso();
		cs.ketnoi();
		String sql="select * from vhuhu where makh=? ORDER BY NgayMua DESC";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= coso.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		cmd.setLong(1, makh);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			String matruyen= rs.getString("matruyen");
			String tentruyen=rs.getString("tentruyen");
			long gia=rs.getLong("gia"); 
			Long soluong=rs.getLong("SoLuongMua");	
			boolean damua =rs.getBoolean("damua");
			long thanhtien=rs.getLong("thanhtien"); 		
			Date ngaymua = rs.getDate("NgayMua");
			String anh=rs.getString("anh");
			lichsuMHbean lichsu = new lichsuMHbean(matruyen, tentruyen, gia, soluong, damua, thanhtien, makh, ngaymua,anh);
			ds.add(lichsu);
		}
		rs.close();
		cs.cn.close();
		return ds;
	}
}
