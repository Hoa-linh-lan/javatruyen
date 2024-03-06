package bo;

import java.util.ArrayList;
import java.util.Iterator;

import bean.giohangbean;
import bean.loaibean;
import dao.giohangdao;
import dao.loaidao;

public class giohangbo {
	public int a=0;
	giohangdao ghdao = new giohangdao();
	public ArrayList<giohangbean> ds= new ArrayList<giohangbean>();
	public ArrayList<giohangbean> getgiohang() throws Exception{
		ds = ghdao.getgiohang();
		return ds;
	}
	public void Them(String matruyen, long gia, long sl){
		a++;
		long tt = sl*gia;
		int n=ds.size();
		for(int i=0;i<n;i++){
			if(ds.get(i).getMatruyen().toLowerCase().trim().equals(matruyen.toLowerCase().trim())){
				long slt=ds.get(i).getSoluong()+sl;
				ds.get(i).setSoluong(slt);
				long g= ds.get(i).getGia();
				tt= slt*g;
				ds.get(i).setThanhtien(tt);
				a--;
			return;
			}
		}
		giohangbean h= new giohangbean(matruyen, gia, sl, tt);
		ds.add(h);
		}
	public long Tongtien(){
		int n=ds.size();
		long s=0;
		for(int i=0;i<n;i++){
		s=s+ds.get(i).getThanhtien();
		}
			return s;
		}
	public void Sua(String th,int sl){
		for(giohangbean dv: ds)
			if(dv.getMatruyen().equals(th)) {
				dv.setSoluong(sl);
				long tt;
				tt=dv.getGia()*sl;
				dv.setThanhtien(tt);
			}
	}
	public void Xoa(String th){
		Iterator<giohangbean> iterator = ds.iterator();
		while (iterator.hasNext()) {
	        giohangbean dv = iterator.next();
	        
	        if (dv.getMatruyen().equals(th)) {
	            iterator.remove();
	        }
		}
	}
	public void xoahet(){
		Iterator<giohangbean> iterator = ds.iterator();
		while (iterator.hasNext()) {
	        giohangbean dv = iterator.next();
	            iterator.remove();
	        }	
	}
	public void Xoadachon(int so){
		int n=ds.size();
		for(int i=1;i<=n;i++){
			if(i==so) ds.remove(i);
		}
	}
	public int a() {
		return a;
	}
}
