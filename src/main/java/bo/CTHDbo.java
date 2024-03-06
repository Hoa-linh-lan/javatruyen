package bo;

import java.util.ArrayList;

import bean.adminxacnhanbean;
import dao.CTHDdao;

public class CTHDbo {
	CTHDdao cthddao = new CTHDdao();
	public int them (String masach, int soluong, long mahd) throws Exception{
		return cthddao.them(masach, soluong, mahd);
	}
	
	public int Sua(long maCTHD) throws Exception{
		return cthddao.Sua(maCTHD);
	}
	
	
	  public ArrayList<adminxacnhanbean> getxacnhan() throws Exception {
		  return cthddao.getxacnhan(); 
	  } 
	  
	  public int Xoa(long macthd) throws Exception {
		  return cthddao.Xoa(macthd); 
	}
	 
}
