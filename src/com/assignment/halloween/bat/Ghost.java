package com.assignment.halloween.bat;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

public class Ghost extends Activity {
	
	private ImageView image;
	private LayoutParams layout;
	private boolean left=true, change=false;

	
	public void setGhost(ImageView ima, LayoutParams lay){
		image=ima;
		layout=lay;	
	}
	
	public void appear(){
		image.setVisibility(View.VISIBLE);	
	}
	
	public void CatchBullet(double vx, LayoutParams bullet_layout){
		if((bullet_layout.topMargin-layout.topMargin)<48 && (bullet_layout.topMargin-layout.topMargin)>0){
		    if((bullet_layout.leftMargin-layout.leftMargin)>0 &&(bullet_layout.leftMargin-layout.leftMargin)<54){
		    	if(change==false) 
				  {
		    		 bullet_layout.leftMargin=383;
				     bullet_layout.topMargin=340;
		    		change=true;
				  }
			}
		 }
	}
	
	public void move_left(){
		if(layout.leftMargin>70 && left==true){
			layout.leftMargin -=5;
		}
		else{
			left=false;
		}
	}
	
	public void move_right(){
		if(layout.leftMargin<680 && left==false){
			layout.leftMargin +=5;
		}
		else{
			left=true;
		}
	}
	public void SetChange(boolean a){
		change=a;
	}
}
