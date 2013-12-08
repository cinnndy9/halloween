package com.assignment.halloween.bat;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class Bat extends Activity{
	
	private ImageView image;
	private LayoutParams layout;
	private TextView leftbat;
	private static String result;
	private static int num;
	private int leftMargin;
	private int topMargin;
	private boolean appear=true;
	private boolean catchPPk=false;
	public static Bat instance2 = null;
	
	public void setBat(ImageView img, LayoutParams lay, int left, int top,TextView batNum){
	    image = img;
		layout=lay;
		leftMargin=left;
		topMargin=top;
		leftbat=batNum;
		num=15;
		result="unknown";
		instance2=this;
	}
	
	public void Move(Pumpkin ppk){
    	if(layout.topMargin<310){
    		catchPPk=false;
    		layout.topMargin += 3;
    		image.setLayoutParams(layout);
    	}
    	else if (layout.topMargin<350 && layout.topMargin>=310){  
    		if(catchPPk==false){
    			System.out.println("catch ppk: "+catchPPk);
    		   catchPPk=true;
    		   layout.topMargin=400;
    		   image.setVisibility(View.INVISIBLE);
    		   ppk.disappear();	
    		}
    	}
    }
	
	public void Beaten(LayoutParams bullet_layout){
		if(catchPPk==false){
			if((bullet_layout.topMargin-layout.topMargin)<42 && (bullet_layout.topMargin-layout.topMargin)>0){
    		    if((bullet_layout.leftMargin-layout.leftMargin)>2 &&(bullet_layout.leftMargin-layout.leftMargin)<45){
				   disappear();
				}
    		 }
		}
    }
	
	public void disappear(){
		image.setVisibility(View.INVISIBLE);
		layout.topMargin=400;
		if(num>1 && appear==true){
		   appear=false;
		   num -=1;
		   leftbat.setText(Integer.toString(num));
		   Emerge();
		}
		else if(num==1 && appear==true){
			appear=false;
			result="success";
		}
	}
	
	public void Emerge(){
		final Handler handler = new Handler();
		Runnable emergeTime = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(appear==false && catchPPk==false){
				image.setVisibility(View.VISIBLE);
				layout.leftMargin=leftMargin;
				layout.topMargin=topMargin;
				appear=true;
				}
			}
			
		};
		handler.postDelayed(emergeTime, BatAppearTime(7)*1000);
	}
	
	int BatAppearTime(int time){
		Random ran = new Random();
		time = time + ran.nextInt(4);
		return time;
	}
	
	public String GetResult(){
		return result;
	}
	public String SetResult(){
		result="unknown";
		return result;
	}
	
	public int GetNum(){
		return num;
	}
}
