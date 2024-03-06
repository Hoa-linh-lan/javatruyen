package bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import bean.khachhangbean;
import dao.khachhangdao;


public class khachhangbo {
	
	khachhangdao khdao = new khachhangdao();
	khachhangbean kh;
	public khachhangbean dangnhap (String tendn, String pass) throws Exception{
		return khdao.ktdn(tendn, pass);
	}
	public int dangky(String hoten, String diachi, String sodt, String email, String tendn, String pass,String pass1) throws Exception{
		kh=khdao.kttk(tendn);
		if(kh==null)
		{
			if(pass.equals(pass1))
			{
				khdao.dangky(hoten, diachi, sodt, email, tendn, pass);
				return 1;
			}
			else return 2;
		}
		return 0;
	}
}
