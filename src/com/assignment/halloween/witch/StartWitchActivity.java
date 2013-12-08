package com.assignment.halloween.witch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.assignment.halloween.R;

public class StartWitchActivity extends Activity {
	private Button btnPlay;
	private Button btnBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_startwitch);
		super.onCreate(savedInstanceState);

		btnPlay = (Button) findViewById(R.id.btnPlay);
		btnPlay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), WitchActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});

		btnBack = (Button) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				setResult(RESULT_OK, intent);
				finish();
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