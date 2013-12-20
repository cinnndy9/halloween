package com.assignment.halloween.candy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.assignment.halloween.R;
import com.assignment.halloween.core.MenuActivity;

public class StartCandyActivity extends Activity{
	
	private Button begin;
	private Button menu;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level2_start);
		
		begin=(Button)findViewById(R.id.level2_begingame);
		menu=(Button)findViewById(R.id.level2_gotomenu);
		
		begin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(v.getContext(),FindCandy.class);
				startActivityForResult(myIntent,0);
			}
		});
		
        menu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(v.getContext(),MenuActivity.class);
				startActivityForResult(myIntent,0);
			}
		});
	}
}
