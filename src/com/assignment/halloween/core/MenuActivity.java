package com.assignment.halloween.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.assignment.halloween.R;
import com.assignment.halloween.bat.StartBatActivity;
import com.assignment.halloween.candy.FindCandy;
import com.assignment.halloween.candy.StartCandyActivity;
import com.assignment.halloween.witch.StartWitchActivity;

public class MenuActivity extends Activity {
	private Button btnHome;
	private Button btnLevelWitch;
	private Button btnLevelCandy;
	private Button btnLevelBat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_menu);
		super.onCreate(savedInstanceState);

		btnHome = (Button) findViewById(R.id.btnHome);
		btnHome.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), MainActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});

		btnLevelWitch = (Button) findViewById(R.id.btnLevelWitch);
		btnLevelWitch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), StartWitchActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});

		btnLevelCandy = (Button) findViewById(R.id.btnLevelCandy);
		btnLevelCandy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), StartCandyActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});

		btnLevelBat = (Button) findViewById(R.id.btnLevelBat);
		btnLevelBat.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), StartBatActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}