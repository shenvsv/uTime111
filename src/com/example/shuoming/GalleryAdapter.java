package com.example.shuoming;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;

public class GalleryAdapter extends BaseAdapter {
	private Context context;
	private Integer[] imagesId;// 要显示的图片
	private Bitmap[] nearBitmaps;// 自己所缓存的当前图片附近的图片，当前图片是1，上一张是0，下一张是2
	private int showingIndex;// 正在显示的图片是第几张图片
    
	public GalleryAdapter(Context context, Integer[] imagesId) {
		this.context = context;
		this.imagesId = imagesId;
		nearBitmaps = new Bitmap[5];
		// 最开始的时候，先初始化最开始的3张图片
		BitmapFactory.Options options = new BitmapFactory.Options();
		//options.inSampleSize = 2;
		//nearBitmaps[1] = BitmapFactory.decodeResource(context.getResources(),
		//		imagesId[0], options);
		
		nearBitmaps[2] = BitmapFactory.decodeResource(context.getResources(),
				imagesId[0], options);
		nearBitmaps[3] = BitmapFactory.decodeResource(context.getResources(),
				imagesId[1], options);
		
		nearBitmaps[4] = BitmapFactory.decodeResource(context.getResources(),
				imagesId[2], options);
		 
		 
	}

	public int getCount() {
		return imagesId.length;
	}

	public Object getItem(int position) {
		
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = new ImageView(context);
			convertView.setLayoutParams(new SingleScrollGallery.LayoutParams(
					800, 1280));
		}
		 
			if (position == showingIndex)
				((ImageView) convertView).setImageBitmap(nearBitmaps[2]);
			if (position == showingIndex - 1) {// 说明是向前滑动
				((ImageView) convertView).setImageBitmap(nearBitmaps[1]);
			}
			if (position == showingIndex + 1) {// 说明是向后滑动
				((ImageView) convertView).setImageBitmap(nearBitmaps[3]);
			//}
		}
		
		return convertView;
	}

	public Bitmap[] getNearBitmaps() {
		return nearBitmaps;
	}

	public int getShowingIndex() {
		return showingIndex;
	}

	public void setShowingIndex(int showingIndex) {
		this.showingIndex = showingIndex;
	}

}