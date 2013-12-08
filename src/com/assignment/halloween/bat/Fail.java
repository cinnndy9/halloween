package com.assignment.halloween.bat;

import com.assignment.halloween.R;
import com.assignment.halloween.core.MenuActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fail extends Activity {
	
	private Button retry,chooselevel;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.protectppk_fail);
		
		retry=(Button)findViewById(R.id.try_again_proppk);
		chooselevel=(Button)findViewById(R.id.level3_fail_chooselevel);
		
		retry.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fail.this.finish();
				GameInterface.instance.finish();
				Intent intent = new Intent();
				intent.setClass(Fail.this, GameInterface.class);
				startActivity(intent);
			}
		});
		
		chooselevel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fail.this.finish();
				GameInterface.instance.finish();
				Intent intent = new Intent();
				intent.setClass(Fail.this, MenuActivity.class);
				startActivity(intent);
			}
		});
	}

}
