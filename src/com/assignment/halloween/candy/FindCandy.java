package com.assignment.halloween.candy;

import java.util.ArrayList;

import com.assignment.halloween.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class FindCandy extends Activity{
	ImageButton img_switch1, img_switch2, img_candy1, img_candy2, img_pumpkin, img_back;
	ImageView img_blackghost,img_role, img_findcandy1, img_findcandy2, img_hint;
	TextView tv_outcome;
	Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
	Button btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20;
	Button btn21,btn22,btn23,btn24,btn25;
//	ArrayList<Tile> tileList= new ArrayList<Tile>();
	int initialTopmargin, initialLeftmargin, defaultWidth, defaultHeight;
//	Boolean btn5Visible = false, btn23Visible = false;
	Boolean candy1Find=false, candy2Find=false;
	
	BlackghostHelper blackghostHelper;
	RoleHelper roleHelper;
	Handler handler = new Handler();
	
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.candyactivity);

	        setViews();
	       // constructHelper();
	      //  setInitialmargin();
	        blackghostHelper.updateBlackghost(btn8, btn12, btn18, btn22);
	        imgbtnClick();
	        getClickbtn();
	        
	        roleHelper.setBtn(btn1);
			Runnable move1 = new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					roleHelper.setCollision(img_blackghost);
					roleHelper.move();
					handler.postDelayed(this, 60);
				}	
			};
			handler.removeCallbacks(move1);
			handler.postDelayed(move1,60);	
	 }
	 
	 void setViews(){
		 btn1 = (Button)findViewById(R.id.btn_1);
		 btn2 = (Button)findViewById(R.id.btn_2);
		 btn3 = (Button)findViewById(R.id.btn_3);
		 btn4 = (Button)findViewById(R.id.btn_4);
		 btn5 = (Button)findViewById(R.id.btn_5);
		 btn6 = (Button)findViewById(R.id.btn_6);
		 btn7 = (Button)findViewById(R.id.btn_7);
		 btn8 = (Button)findViewById(R.id.btn_8);
		 btn9 = (Button)findViewById(R.id.btn_9);
		 btn10 = (Button)findViewById(R.id.btn_10);
		 btn11 = (Button)findViewById(R.id.btn_11);
		 btn12 = (Button)findViewById(R.id.btn_12);
		 btn13 = (Button)findViewById(R.id.btn_13);
		 btn14 = (Button)findViewById(R.id.btn_14);
		 btn15 = (Button)findViewById(R.id.btn_15);
		 btn16 = (Button)findViewById(R.id.btn_16);
		 btn17 = (Button)findViewById(R.id.btn_17);
		 btn18 = (Button)findViewById(R.id.btn_18);
		 btn19 = (Button)findViewById(R.id.btn_19);
		 btn20 = (Button)findViewById(R.id.btn_20);
		 btn21 = (Button)findViewById(R.id.btn_21);
		 btn22 = (Button)findViewById(R.id.btn_22);
		 btn23 = (Button)findViewById(R.id.btn_23);
		 btn24 = (Button)findViewById(R.id.btn_24);
		 btn25 = (Button)findViewById(R.id.btn_25);
		 img_switch1 = (ImageButton)findViewById(R.id.imgbtn_switch1);
	     img_switch2 = (ImageButton)findViewById(R.id.imgbtn_switch2);
	     img_candy1 = (ImageButton)findViewById(R.id.candy1);
	     img_candy2 = (ImageButton)findViewById(R.id.candy2);
	     img_blackghost = (ImageView)findViewById(R.id.blackghost);
	     img_role = (ImageView)findViewById(R.id.role);
	     img_pumpkin = (ImageButton) findViewById(R.id.pumpkin);
	     tv_outcome = (TextView)findViewById(R.id.txtoutcome);
	     img_findcandy1 = (ImageView)findViewById(R.id.img_findcandy1);
	     img_findcandy2 = (ImageView)findViewById(R.id.img_findcandy2);
	     img_hint = (ImageView)findViewById(R.id.hint);
	     img_back = (ImageButton)findViewById(R.id.img_tomain);
	     
		 roleHelper = new RoleHelper(img_role);
		 blackghostHelper = new BlackghostHelper(img_blackghost);
	 } 
	 
	/* void constructHelper(){
		 Tile tile1 = new Tile(btn1,0,0,0);
		 Tile tile2 = new Tile(btn2,1,0,1);
		 Tile tile3 = new Tile(btn3,2,0,2);
		 Tile tile4 = new Tile(btn4,3,0,3);
		 Tile tile5 = new Tile(btn5,4,0,4);
		 Tile tile6 = new Tile(btn6,4,1,5);
		 Tile tile7 = new Tile(btn7,4,2,6);
		 Tile tile8 = new Tile(btn8,0,3,7);
		 Tile tile9 = new Tile(btn9,1,3,8);
		 Tile tile10 = new Tile(btn1,2,3,9);
		 Tile tile11 = new Tile(btn11,3,3,10);
		 Tile tile12 = new Tile(btn12,4,3,11);
		 Tile tile13 = new Tile(btn13,5,3,12);
		 Tile tile14 = new Tile(btn14,0,4,13);
		 Tile tile15 = new Tile(btn15,4,4,14);
		 Tile tile16 = new Tile(btn16,0,5,15);
		 Tile tile17 = new Tile(btn17,4,5,16);
		 Tile tile18 = new Tile(btn18,0,6,17);
		 Tile tile19 = new Tile(btn19,1,6,18);
		 Tile tile20 = new Tile(btn20,2,6,19);
		 Tile tile21 = new Tile(btn21,3,6,20);
		 Tile tile22 = new Tile(btn22,4,6,21);
		 Tile tile23 = new Tile(btn23,5,6,22);
		 Tile tile24 = new Tile(btn24,6,6,23);
		 Tile tile25 = new Tile(btn25,7,7,24);
		 tileList.add(tile1);
		 tileList.add(tile2);
		 tileList.add(tile3);
		 tileList.add(tile4);
		 tileList.add(tile5);
		 tileList.add(tile6);
		 tileList.add(tile7);
		 tileList.add(tile8);
		 tileList.add(tile9);
		 tileList.add(tile10);
		 tileList.add(tile11);
		 tileList.add(tile12);
		 tileList.add(tile13);
		 tileList.add(tile14);
		 tileList.add(tile15);
		 tileList.add(tile16);
		 tileList.add(tile17);
		 tileList.add(tile18);
		 tileList.add(tile19);
		 tileList.add(tile20);
		 tileList.add(tile21);
		 tileList.add(tile22);
		 tileList.add(tile23);
		 tileList.add(tile24);
		 tileList.add(tile25);
		 roleHelper = new RoleHelper(img_role);
		 blackghostHelper = new BlackghostHelper(img_blackghost);
	 }
	 
	 ArrayList<Tile> getTileList(){
		 return tileList;
	 }*/
	 
	 void imgbtnClick(){
		 img_switch1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					LayoutParams par = (LayoutParams)img_role.getLayoutParams();
					int[] location =new int[2];
					btn3.getLocationOnScreen(location);
					if(par.topMargin == btn3.getTop() && par.leftMargin == location[0]){
						btn5.setVisibility(View.VISIBLE);	
					//	btn5Visible = true;
					}
				}
			});
	        img_switch2.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					LayoutParams par = (LayoutParams)img_role.getLayoutParams();
					int[] location =new int[2];
					btn18.getLocationOnScreen(location);
					if(par.topMargin == btn18.getTop() && par.leftMargin == location[0]){
						btn23.setVisibility(View.VISIBLE);
					//	btn23Visible = true;						
					}
				}
			});  
	        img_candy1.setOnClickListener(new View.OnClickListener() {
	        	
				@Override
				public void onClick(View v) {
					//only white is nearby can be clicked
					LayoutParams par = (LayoutParams)img_role.getLayoutParams();
					int[] location =new int[2];
					btn13.getLocationOnScreen(location);
					if(par.topMargin == btn13.getTop() && par.leftMargin == location[0]){
						img_candy1.setImageDrawable(getResources().getDrawable(R.drawable.candy_none));	
						candy1Find = true;
						tv_outcome.setText("Good job! find candy! ");
						img_findcandy1.setVisibility(View.VISIBLE);
					}
					if(candy1Find==true && candy2Find==true){
						img_hint.setVisibility(View.VISIBLE);
					}
				}
			});
	        img_candy2.setOnClickListener(new View.OnClickListener() {			
				@Override
				public void onClick(View v) {
					//add condition, only white is near can be clicked
					LayoutParams par = (LayoutParams)img_role.getLayoutParams();
					int[] location =new int[2];
					btn24.getLocationOnScreen(location);
					if(par.topMargin == btn24.getTop() && par.leftMargin == location[0]){
						img_candy2.setImageDrawable(getResources().getDrawable(R.drawable.candy_none));		
						candy2Find = true;
						tv_outcome.setText("Good job! find candy! ");
						img_findcandy2.setVisibility(View.VISIBLE);				
					}
					if(candy1Find==true && candy2Find==true){
						img_hint.setVisibility(View.VISIBLE);
					}
				}
			});
	        img_pumpkin.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LayoutParams par = (LayoutParams)img_role.getLayoutParams();
					int[] location =new int[2];
					btn25.getLocationOnScreen(location);
					if(par.topMargin == btn25.getTop() && par.leftMargin == location[0]){
						if(candy1Find == true && candy2Find == true){
							tv_outcome.setText("Good Job! You got 2 candies!");
							Intent myIntent = new Intent(v.getContext(),Level2Success.class);
							startActivity(myIntent);
						}
					}
					else{
						tv_outcome.setText("Go on find more candy!");
					}
				}
			});
	        img_back.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent myIntent = new Intent(v.getContext(),StartCandyActivity.class);
					startActivity(myIntent);
				}
			});
	 }
	 
	/* void setInitialmargin(){
		 Tile tile0 = tileList.get(0);
		 LayoutParams par = (LayoutParams)(tile0.getButton()).getLayoutParams();
		 initialTopmargin = par.height; ;
		 initialLeftmargin = par.topMargin;
		 defaultWidth = par.width;
		 defaultHeight = par.height;
	 }
	 
	
	Boolean getBtn5Visiblility(){
		 return btn5Visible;
	 }
	Boolean getBtn23Visibility(){
		return btn23Visible;
	}*/
	
	void getClickbtn(){	
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {			
				roleHelper.setBtn(btn1);
				/*Runnable move1 = new Runnable(){
					@Override
					public void run() {
						roleHelper.setCollision(img_blackghost);
						roleHelper.move();
						handler.postDelayed(this, 60);
					}	
				};
				handler.removeCallbacks(move1);
				handler.postDelayed(move1,60);	*/
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn2);
				//roleHelper.move();
			}
		});
		btn3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn3);
			//	setCollision();
				roleHelper.move();
			}
		});
		btn4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn4);
			//	setCollision();
				roleHelper.move();
			}
		});
		btn5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn5);
			//	setCollision();
				roleHelper.move();
			}
		});
		btn6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn6);
			//	setCollision();
				roleHelper.move();
			}
		});
		btn7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn7);
				//setCollision();
				roleHelper.move();
			}
		});
		btn8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn8);
			//	setCollision();
				roleHelper.move();
			}
		});
		btn9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn9);
			//	setCollision();
				roleHelper.move();
			}
		});
		btn10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn10);
			//	setCollision();
				roleHelper.move();
			}
		});
		btn11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn11);
			//	setCollision();
				roleHelper.move();
			}
		});
		btn12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn12);
				//setCollision();
				roleHelper.move();
			}
		});
		btn13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn13);
				//setCollision();
				roleHelper.move();
			}
		});
		btn14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn14);
			//	setCollision();
				roleHelper.move();
			}
		});
		btn15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn15);
			//	setCollision();
				roleHelper.move();
			}
		});
		btn16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn16);
			//	setCollision();
				roleHelper.move();
			}
		});
		btn17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn17);
				roleHelper.move();
			}
		});
		btn18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn18);
				roleHelper.move();
			}
		});
		btn19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn19);
				roleHelper.move();
			}
		});
		btn20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn20);
				roleHelper.move();
			}
		});
		btn21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn21);
				roleHelper.move();
			}
		});
		btn22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn22);
				roleHelper.move();
			}
		});
		btn23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn23);
				roleHelper.move();
			}
		});
		btn24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn24);
				roleHelper.move();
			}
		});
		btn25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				roleHelper.setBtn(btn25);
				roleHelper.move();
			}
		});
	}	
}
