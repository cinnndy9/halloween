package com.assignment.halloween.bat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.assignment.halloween.R;
import com.assignment.halloween.core.MenuActivity;

public class StartBatActivity extends Activity {
	
	private Button next;
	private Button main_menu;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_protect_pumpkin);
		
		next=(Button)findViewById(R.id.game);
		main_menu=(Button)findViewById(R.id.main_menu);
		
		
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
}
