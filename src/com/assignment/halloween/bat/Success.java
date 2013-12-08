package com.assignment.halloween.bat;

import com.assignment.halloween.R;
import com.assignment.halloween.core.MenuActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Success extends Activity{
	
	private Button retry,chooselevel;
	private String num;
	private int ppkLeft;
	private Handler handler = new Handler();
	private ImageView ppk1,ppk2,ppk3,ppk4;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.protectppk_success);
		
		retry=(Button)findViewById(R.id.back_to_proppk);
		chooselevel=(Button)findViewById(R.id.level3_success_chooselevel);
		ppk1=(ImageView)findViewById(R.id.leftppk1);
		ppk2=(ImageView)findViewById(R.id.leftppk2);
		ppk3=(ImageView)findViewById(R.id.leftppk3);
		ppk4=(ImageView)findViewById(R.id.leftppk4);
		ppk1.setVisibility(View.INVISIBLE);
		ppk2.setVisibility(View.INVISIBLE);
		ppk3.setVisibility(View.INVISIBLE);
		ppk4.setVisibility(View.INVISIBLE);
		
		num=this.getIntent().getStringExtra("Name");
		ppkLeft= Integer.parseInt(num);
		handler.postDelayed(show_ppk,2000);
		System.out.println("num: "+num);
		GameInterface.instance.finish();
		
		retry.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Success.this.finish();
				//GameInterface.instance.finish();
				Intent intent = new Intent();
				intent.setClass(Success.this, GameInterface.class);
				startActivity(intent);
			}
		});
		
		chooselevel.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Success.this.finish();
				//GameInterface.instance.finish();
				Intent intent = new Intent();
				intent.setClass(Success.this, MenuActivity.class);
				startActivity(intent);
			}
		});
	}
	Runnable show_ppk = new Runnable(){
		public void run(){
			if(ppkLeft==1){
				ppk1.setVisibility(View.VISIBLE);
			}
			else if (ppkLeft==2){
				ppk2.setVisibility(View.VISIBLE);
				ppk4.setVisibility(View.VISIBLE);
			}
			else if (ppkLeft==3){
				ppk1.setVisibility(View.VISIBLE);
				ppk2.setVisibility(View.VISIBLE);
				ppk4.setVisibility(View.VISIBLE);
			}
			else{
				ppk1.setVisibility(View.VISIBLE);
				ppk2.setVisibility(View.VISIBLE);
				ppk3.setVisibility(View.VISIBLE);
				ppk4.setVisibility(View.VISIBLE);
			}
		}
	};
}
