package com.assignment.halloween.witch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.assignment.halloween.R;
import com.assignment.halloween.candy.StartCandyActivity;
import com.assignment.halloween.core.MenuActivity;

public class GameoverActivity extends Activity {
	private Button btnRetry;
	private Button btnMenu;
	private Button btnNext;

	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_gameover);
		super.onCreate(savedInstanceState);

		TextView score = (TextView) findViewById(R.id.finalScore);
		score.setText("Your Score is " + this.getIntent().getStringExtra("score") + ".");

		btnMenu = (Button) findViewById(R.id.btnMenu);
		btnMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), MenuActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});

		btnRetry = (Button) findViewById(R.id.btnRetry);
		btnRetry.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent();
				myIntent.setClass(GameoverActivity.this, WitchActivity.class);
				startActivity(myIntent);
			}
		});
		
		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent();
				myIntent.setClass(GameoverActivity.this, StartCandyActivity.class);
				startActivity(myIntent);
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
