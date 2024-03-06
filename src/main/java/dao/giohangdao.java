package dao;

import java.util.ArrayList;

import bean.giohangbean;
import bean.loaibean;


public class giohangdao {
	ArrayList<giohangbean> ds=new ArrayList<giohangbean>();	
	public ArrayList<giohangbean> getgiohang() throws Exception{		
		return ds;
	}
	
}
