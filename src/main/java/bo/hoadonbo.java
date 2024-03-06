package bo;

import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao = new hoadondao();
	public int them (Long makh) throws Exception{
		return hddao.them(makh);
	}
	public long getmaxhd () throws Exception{
		return hddao.getmaxhd();
	}
}
