package jdhe.iyibank.com.iyimeal.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
	private List<Fragment> listmVp;
	private Context context;
	
	public FragmentAdapter(FragmentManager fm, List<Fragment> listmVp, Context context) {
		super(fm);
		this.listmVp = listmVp;
		this.context = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listmVp.size();
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return listmVp.get(arg0);
	}
}
