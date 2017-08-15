package jdhe.iyibank.com.iyimeal.util;

import android.util.SparseArray;
import android.view.View;

//通用Holder
public class ViewHolder {
	public static <T extends View> T get(View convertView, int id) {

		SparseArray<View> viewHolder = (SparseArray<View>) convertView.getTag();
		if (viewHolder == null) {
			viewHolder = new SparseArray<View>();
			convertView.setTag(viewHolder);
		}

		View childView = viewHolder.get(id);
		if (childView == null) {
			childView = convertView.findViewById(id);
			viewHolder.put(id, childView);

		}
		return (T) childView;
	}

}
