package cn.fjnu.edu.paint.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cn.fjnu.edu.paint.R;
import cn.fjnu.edu.ui.activity.PaintMainActivity;
/**
 * 
 * @author GaoFei
 * 贴图适配器
 */
public class PastePhotoAdapter extends BaseAdapter{

	private Context context;
	private List<Integer> photoId=new ArrayList<>();
	private int resId;
	public PastePhotoAdapter(PaintMainActivity mainActivity){
		context=mainActivity;
		for(int i=0;i<319;i++){
				resId=mainActivity.getResources().getIdentifier("p"+i,"drawable", context.getPackageName());
				photoId.add(resId);
		}
	}
	@Override
	public int getCount() {
		return photoId.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return photoId.get(position);
	}

	@Override
	public View getView(int position, View contentView, ViewGroup parentView) {
		boolean isFirstCreate = false;
		if(contentView == null){
			isFirstCreate = true;
			contentView = LayoutInflater.from(context).inflate(R.layout.paste_img_layout, parentView, false);
		}
		ImageView imageView=(ImageView) contentView.findViewById(R.id.displaygridphoto);
		if(isFirstCreate){
			imageView.setScaleType(ScaleType.CENTER_INSIDE);
			imageView.setLayoutParams(new LinearLayout.LayoutParams(PaintMainActivity.screenWidth/10, PaintMainActivity.screenWidth/10));
		}
		imageView.setImageResource(photoId.get(position));
		return contentView;
	}

}
