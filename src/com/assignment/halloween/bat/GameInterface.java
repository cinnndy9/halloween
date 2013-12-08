package com.assignment.halloween.bat;

import java.util.Random;

import com.assignment.halloween.R;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class GameInterface extends Activity {

	int pX, pY;// bullet position pX,pY 
	double Vx,Vy;// bullet speed Vx£¬Vy
	double slopeLeft, slopeRight;// slope
	boolean click = true, run=false;
	TextView leftBatNum;
	String leftPPkNum;
	ImageView bullet,bat1,bat2,bat3,bat4,ghost;
	ImageView ppk1,ppk2,ppk3,ppk4;
	LayoutParams bullet_layout,bat1_layout,bat2_layout,bat3_layout,bat4_layout,ghost_layout;
	public static GameInterface instance = null;
	Bat Bat1 = new Bat();
	Bat Bat2 = new Bat();
	Bat Bat3 = new Bat();
	Bat Bat4 = new Bat();
	Pumpkin PPk1 = new Pumpkin();
	Pumpkin PPk2 = new Pumpkin();
	Pumpkin PPk3 = new Pumpkin();
	Pumpkin PPk4 = new Pumpkin();
	Ghost Gho = new Ghost();
	
	private Handler handler = new Handler();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_interface);
		
		instance=this;
		
        leftBatNum=(TextView) findViewById(R.id.batnum);
		bullet = (ImageView) findViewById(R.id.bullet);
		bat1 = (ImageView) findViewById(R.id.bat11);
		bat2 = (ImageView) findViewById(R.id.bat21);
		bat3 = (ImageView) findViewById(R.id.bat31);
		bat4 = (ImageView) findViewById(R.id.bat41);
		ppk1 = (ImageView) findViewById(R.id.ppk1);
		ppk2 = (ImageView) findViewById(R.id.ppk2);
		ppk3 = (ImageView) findViewById(R.id.ppk3);
		ppk4 = (ImageView) findViewById(R.id.ppk4);
		ghost = (ImageView) findViewById(R.id.ghostleft);
		ghost.setVisibility(View.INVISIBLE);
		
		bullet_layout = (LayoutParams) bullet.getLayoutParams();
		bat1_layout = (LayoutParams) bat1.getLayoutParams();
		bat2_layout = (LayoutParams) bat2.getLayoutParams();
		bat3_layout = (LayoutParams) bat3.getLayoutParams();
		bat4_layout = (LayoutParams) bat4.getLayoutParams();
		ghost_layout = (LayoutParams) ghost.getLayoutParams();
		
		Bat1.setBat(bat1, bat1_layout,72,-30,leftBatNum);
		Bat2.setBat(bat2, bat2_layout,225,-30,leftBatNum);
		Bat3.setBat(bat3, bat3_layout,505,-30,leftBatNum);
		Bat4.setBat(bat4, bat4_layout,658,-30,leftBatNum);
		PPk1.setPumpkin(ppk1);
		PPk2.setPumpkin(ppk2);
		PPk3.setPumpkin(ppk3);
		PPk4.setPumpkin(ppk4);
		Gho.setGhost(ghost, ghost_layout);
		
		handler.postDelayed(bullet_run, 0);
		handler.postDelayed(bat1_run, BatAppearTime(1)*1000);
		handler.postDelayed(bat2_run,BatAppearTime(5)*1000);
        handler.postDelayed(bat3_run,BatAppearTime(2)*1000);
	    handler.postDelayed(bat4_run,BatAppearTime(8)*1000);
	    handler.postDelayed(ghost_run, 25000);
	    
	}
	
	Runnable bullet_run = new Runnable(){

		public void run() {
			// TODO Auto-generated method stub
			
			if(Bat1.GetResult().equals("unknown") && PPk1.GetResult().equals("unknown")){
			    bullet_move();
			    handler.postDelayed(this, 3);    
			}
			
			else{
				Intent intent = new Intent();
				if(Bat1.GetResult().equals("success")){
					leftPPkNum = Integer.toString(PPk1.GetNum());
				    intent.setClass(GameInterface.this, Success.class);
				    intent.putExtra("Name", leftPPkNum);
				    GameInterface.instance.finish();
				    Bat.instance2.finish();
				    startActivity(intent);
				}
				else if(PPk1.GetResult().equals("fail")){
					intent.setClass(GameInterface.this, Fail.class);
					GameInterface.instance.finish();
					Bat.instance2.finish();
					startActivity(intent);
				}
			}
		}
	};
	Runnable bat1_run = new Runnable(){
		public void run(){	
			Bat1.Move(PPk1);
			Bat1.Beaten(bullet_layout);
			handler.postDelayed(this, 50);
		}
	};
	Runnable bat2_run = new Runnable(){
		public void run(){
			Bat2.Move(PPk2);
			Bat2.Beaten(bullet_layout);
			handler.postDelayed(this, 50);
		}
	};
	Runnable bat3_run = new Runnable(){
		public void run(){
			Bat3.Move(PPk3);
			Bat3.Beaten(bullet_layout);
			handler.postDelayed(this, 50);
		}
	};
	Runnable bat4_run = new Runnable(){
		public void run(){
			Bat4.Move(PPk4);
			Bat4.Beaten(bullet_layout);
			handler.postDelayed(this, 50);
		}
	};
	Runnable ghost_run = new Runnable(){
		public void run(){
			Gho.appear();
			Gho.move_left();
			Gho.move_right();
			Gho.CatchBullet(Vx,bullet_layout);
			handler.postDelayed(this, 30);
		}
	};
	// get the position
	public boolean onTouchEvent(MotionEvent event) {
		if (click == true) {
			pX = (int) event.getX();// get position of pX
			pY = (int) event.getY();// get position of pY
			
			// the bullet can move only when 8<pX<470
			if (pX > 5 && pX < 793 && pY>5 && pY<429) {
				click = false;
				bullet_GetSlope(); 
				run=true;
			}
			else{
				run=false;
				click = true;
			}
		}
		return true;
	}

	//get the slope
	void bullet_GetSlope() {
		double xLongth = 0, yLongth = 0;
		yLongth = (double) (438 - pY);
		Gho.SetChange(false);
		if (pX < 383) {
			xLongth = (double) (383 - pX);
			slopeLeft = yLongth / xLongth;
			slopeRight = 0;
			Vx=Math.sqrt(250/(1+slopeLeft*slopeLeft));
			Vy=slopeLeft*Vx;
		} 
		else {
			if (pX == 383) {
				xLongth = (double) 1;
			} 
			else {
				xLongth = (double) (pX - 383);
				slopeRight = yLongth / xLongth;
				slopeLeft = 0;
			}
			Vx=Math.sqrt(250/(1+slopeRight*slopeRight));
			Vy=slopeRight*Vx;
		}
	}
	
	void bullet_move(){
		//move up
		if(slopeLeft!=0 && run==true){
			if(bullet_layout.leftMargin>40 && bullet_layout.topMargin>30){
				bullet_layout.leftMargin -=Vx;
				bullet_layout.topMargin -=Vy;
			}
			else{
				bullet_layout.leftMargin=383;
				bullet_layout.topMargin=340;
				run=false;
				click=true;
			}
		}
		//move down
		else if(slopeRight!=0 && run==true){
			if(bullet_layout.leftMargin<740 && bullet_layout.topMargin>30){
				bullet_layout.leftMargin +=Vx;
				bullet_layout.topMargin -=Vy;
			}
			else{
				bullet_layout.leftMargin=383;
				bullet_layout.topMargin=340;
				run=false;
				click=true;
			}
		}
		bullet.setLayoutParams(bullet_layout);
	}
	
	int BatAppearTime(int time){
		Random ran = new Random();
		time = time + ran.nextInt(5);
		return time;
	}
}
