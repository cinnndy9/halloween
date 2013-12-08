package com.assignment.halloween.witch;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.assignment.halloween.R;
import com.assignment.halloween.core.MenuActivity;
import com.assignment.halloween.core.MoveUtils;
import com.assignment.halloween.core.References;

public class WitchActivity extends Activity {
	private Button btnMenu;
	private Button btnRetry;

	private int curObject;

	private Runnable drop = new Runnable() {
		public void run() {
			Display display = getWindowManager().getDefaultDisplay();
			Point size = new Point();
			display.getSize(size);
			int screen_width = size.x;
			int screen_height = size.y;

			LayoutParams parObj = (LayoutParams) imgObject.getLayoutParams();
			LayoutParams parBas = (LayoutParams) imgBasket.getLayoutParams();

			if (MoveUtils.isStrike(parObj, parBas) && !striked) {
				imgEffect.setVisibility(View.VISIBLE);

				if (curObject == References.OBJECT_PUMPKIN) {
					score += 10;
					imgEffect.setBackgroundResource(R.drawable.scoreplus10);
				}
				if (curObject == References.OBJECT_BOMB) {
					score = 0;
					imgEffect.setBackgroundResource(R.drawable.explosion);
				}
				if (curObject == References.OBJECT_BOOT) {
					score += 1;
					imgEffect.setBackgroundResource(R.drawable.scoreplus1);
				}
				if (curObject == References.OBJECT_CANDLE) {
					score -= 1;
					score = (score < 0) ? 0 : score;
					imgEffect.setBackgroundResource(R.drawable.scoreminus1);
				}
				if (curObject == References.OBJECT_HAT) {
					score += 1;
					imgEffect.setBackgroundResource(R.drawable.scoreplus1);
				}
				if (curObject == References.OBJECT_MONEYBAG) {
					score += 5;
					imgEffect.setBackgroundResource(R.drawable.scoreplus5);
				}
				if (curObject == References.OBJECT_RUBY) {
					score += 2;
					imgEffect.setBackgroundResource(R.drawable.scoreplus2);
				}
				TextView tvScore = (TextView) findViewById(R.id.tvScore);
				tvScore.setText(Integer.toString(score));
				striked = true;
			} else if (parObj.topMargin >= screen_height - parObj.height - 150) {
				striked = false;
				imgEffect.setVisibility(View.GONE);

				parObj.topMargin = 0;
				Random myRandom = new Random();
				parObj.leftMargin += myRandom.nextInt(screen_width - parObj.width - 150) - parObj.leftMargin;
				imgObject.setLayoutParams(parObj);
				curObject = myRandom.nextInt(7);

				switch (curObject) {
				case References.OBJECT_PUMPKIN:
					imgObject.setImageResource(R.drawable.pumpkin);
					break;
				case References.OBJECT_BOMB:
					imgObject.setImageResource(R.drawable.bomb);
					break;
				case References.OBJECT_BOOT:
					imgObject.setImageResource(R.drawable.boot);
					break;
				case References.OBJECT_CANDLE:
					imgObject.setImageResource(R.drawable.candle);
					break;
				case References.OBJECT_HAT:
					imgObject.setImageResource(R.drawable.hat);
					break;
				case References.OBJECT_MONEYBAG:
					imgObject.setImageResource(R.drawable.moneybag);
					break;
				case References.OBJECT_RUBY:
					imgObject.setImageResource(R.drawable.ruby);
					break;
				}
			} else if (parObj.topMargin >= 0) {
				parObj.topMargin += 5;
				imgObject.setLayoutParams(parObj);
			}
			handler.postDelayed(this, 10);
		}
	};

	private Handler handler;

	private ImageView imgBasket;
	private ImageView imgEffect;
	private ImageView imgObject;
	private Long minutes;

	private int score;
	private Long seconds;
	private Long spentTime;
	private Long startTime;
	private int state;

	private boolean striked;

	private Runnable timer = new Runnable() {
		public void run() {
			final TextView time = (TextView) findViewById(R.id.tvTimer);
			spentTime = System.currentTimeMillis() - startTime;

			if ((state == References.LEVEL_WITCH) && (spentTime >= 1000 * 60)) {
				// (minutes == 0) && (seconds == 1)) {

				Intent myIntent = new Intent(imgBasket.getContext(), GameoverActivity.class);
				myIntent.putExtra("score", Integer.toString(score));
				startActivityForResult(myIntent, 0);

				state = References.LEVEL_WITCH_OVER;
			}
			minutes = (long) 0;
			long sec = 60 - (spentTime / 1000) % 60;
			seconds = (sec == 60) ? 0 : sec;
			time.setText(minutes + ":" + seconds);
			handler.postDelayed(this, 1000);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_witch);
		super.onCreate(savedInstanceState);

		startTime = System.currentTimeMillis();
		spentTime = (long) 0;
		score = 0;
		minutes = (long) 1;
		seconds = (long) 0;
		striked = false;
		state = References.LEVEL_WITCH;
		curObject = References.OBJECT_PUMPKIN;

		handler = new Handler();
		handler.removeCallbacks(timer);
		handler.postDelayed(timer, 1000);

		handler.removeCallbacks(drop);
		handler.postDelayed(drop, 10);

		imgEffect = (ImageView) findViewById(R.id.imgEffect);
		imgObject = (ImageView) findViewById(R.id.imgObject);

		imgBasket = (ImageView) findViewById(R.id.imgBasket);
		imgBasket.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				LayoutParams parBas = (LayoutParams) imgBasket.getLayoutParams();
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					break;
				case MotionEvent.ACTION_MOVE:
					int x_cord = (int) event.getRawX();
					Display display = getWindowManager().getDefaultDisplay();
					Point size = new Point();
					display.getSize(size);
					int screen_width = size.x;
					if (x_cord > screen_width) {
						x_cord = screen_width;
					}
					parBas.leftMargin = x_cord - parBas.width / 2;
					imgBasket.setLayoutParams(parBas);
					break;
				default:
					break;
				}
				return true;
			}
		});

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
				Intent myIntent = new Intent(v.getContext(), WitchActivity.class);
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
