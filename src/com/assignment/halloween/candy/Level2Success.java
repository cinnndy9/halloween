package com.assignment.halloween.candy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.assignment.halloween.R;
import com.assignment.halloween.bat.StartBatActivity;
import com.assignment.halloween.core.MenuActivity;

public class Level2Success extends Activity{
	Button level2_next,menu;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.levelsuccess);
		
		level2_next = (Button)findViewById(R.id.level2_next);
		menu=(Button)findViewById(R.id.level2_menu);
		
		level2_next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(v.getContext(),StartBatActivity.class);
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
