package com.example.shuoming;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
 
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.Toast;


public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    private SingleScrollGallery gallery;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = (SingleScrollGallery)findViewById(R.id.gallery);
        gallery.setAdapter((SpinnerAdapter) new ImageAdapter(this));//设置图片适配器
        //设置监听器
        gallery.setAnimationDuration(0);
        gallery.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,    long arg3) {
                if (arg2==24) {
                	 Toast.makeText(MainActivity.this, "已到尾页", Toast.LENGTH_SHORT).show();
				}
                
                
            }
        });
        Toast.makeText(MainActivity.this, "向右滑动翻页", Toast.LENGTH_SHORT).show();
    }
}

class ImageAdapter extends BaseAdapter{
    private Context context;
    //图片源数组
    private Integer[] imageInteger={
            R.drawable.part1,
            R.drawable.part2,
            R.drawable.part3,
            R.drawable.part4,
            R.drawable.part5,
            R.drawable.part6,
            R.drawable.part7,
            R.drawable.part8,
			R.drawable.part9,
			R.drawable.part10,
			R.drawable.part11,
			R.drawable.part12,
			R.drawable.part13, 
			R.drawable.part14, 
			R.drawable.part15, 
			R.drawable.part16,
			R.drawable.part17, 
			R.drawable.part18,
			R.drawable.part19,
			R.drawable.part20,
			R.drawable.part21,
			R.drawable.part22,
			R.drawable.part23,
			R.drawable.part24,
			R.drawable.part25,
			
			
    };
    public ImageAdapter(Context c){
        context = c;
    }
    @Override
    public int getCount() {
        return imageInteger.length;
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageInteger[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new SingleScrollGallery.LayoutParams(640, 960));
        return imageView;
    }
    
     
     
    
    }
