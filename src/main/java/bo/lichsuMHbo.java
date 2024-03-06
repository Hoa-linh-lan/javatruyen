package bo;

import java.util.ArrayList;

import bean.lichsuMHbean;
import dao.lichsuMHdao;

public class lichsuMHbo {
	
	ArrayList<lichsuMHbean> ds=new ArrayList<lichsuMHbean>();
	lichsuMHdao lichsu = new lichsuMHdao();
	public ArrayList<lichsuMHbean> getlichsu(Long makh) throws Exception{
		ds=lichsu.getlichsu(makh);
		return ds;
	}
}
