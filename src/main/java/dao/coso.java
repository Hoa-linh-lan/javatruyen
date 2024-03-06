package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class coso {
	public static Connection cn;
	public static void ketnoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("ket noi sqlserver");
			String url =  "jdbc:sqlserver://DESKTOP-FKORRO5\\SA:1433;databaseName=truyen; user=sa; password=123";
			cn = DriverManager.getConnection(url);
			System.out.println("Connect Thanh Cong");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		coso cs= new coso();
		cs.ketnoi();
	}
}
