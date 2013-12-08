package com.assignment.halloween.bat;

import com.assignment.halloween.R;
import com.assignment.halloween.core.MenuActivity;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartBatActivity extends Activity {
	
	private Button next;
	private Button main_menu;
	private TextView txt1,txt2,txt3;
	private Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_protect_pumpkin);
		
		next=(Button)findViewById(R.id.game);
		main_menu=(Button)findViewById(R.id.main_menu);
		txt1=(TextView)findViewById(R.id.level3txt1);
		txt2=(TextView)findViewById(R.id.level3txt2);
		txt3=(TextView)findViewById(R.id.level3txt3);
		
		txt2.setVisibility(View.INVISIBLE);
		txt3.setVisibility(View.INVISIBLE);
		
		handler.postDelayed(hide_txt1, 4500);
		handler.postDelayed(show_txt2, 4800);
		handler.postDelayed(hide_txt2, 9000);
		handler.postDelayed(show_txt3, 9300);
		
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(arg0.getContext(),GameInterface.class);
				startActivityForResult(myIntent,0);
			}
		});
		
		main_menu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(v.getContext(),MenuActivity.class);
				startActivityForResult(myIntent,0);
			}
		});
	}
	
	
	
	Runnable hide_txt1 = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			txt1.setVisibility(View.INVISIBLE);
		}
		
	};
	
	Runnable show_txt2 = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			txt2.setVisibility(View.VISIBLE);
		}
		
	};
	
	Runnable hide_txt2 = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			txt2.setVisibility(View.INVISIBLE);
		}
		
	};
	
	Runnable show_txt3 = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			txt3.setVisibility(View.VISIBLE);
		}
		
	};
}
