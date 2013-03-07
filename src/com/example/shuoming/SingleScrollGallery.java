package com.example.shuoming;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Gallery;

public class SingleScrollGallery extends Gallery {

	public SingleScrollGallery(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	 @Override
	 public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
	      int kEvent;
	      if (isScrollingLeft(e1, e2)) {
	          // Check if scrolling left
	          kEvent = KeyEvent.KEYCODE_DPAD_LEFT;
	      } else {
	         // Otherwise scrolling right
			kEvent = KeyEvent.KEYCODE_DPAD_RIGHT;
	      }
	      onKeyDown(kEvent, null);
	      return true; 
		// return false;
	 }
	
	 
	 private boolean isScrollingLeft(MotionEvent e1, MotionEvent e2) {
	      return e2.getX() > e1.getX();
	 }
}
	 

	 
	 

	 


