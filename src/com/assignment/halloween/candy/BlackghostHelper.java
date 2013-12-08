package com.assignment.halloween.candy;

import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

public class BlackghostHelper {
	ImageView img_blackghost;
	int topmargin, leftmargin;
	
	BlackghostHelper(ImageView img){
		this.img_blackghost = img;
	}
	
	void setImageview(ImageView img){
		img_blackghost = img;
	}
	ImageView getImageview(){
		return img_blackghost;
	}
	
	int getTopmaring(){
		return topmargin;
	}
	int getLeftmargin(){
		return leftmargin;
	}

	/**
	 * Move image around the four buttons continuously
	 * @param image
	 * @param btnLeftup
	 * @param btnRightup
	 * @param btnLeftbottom
	 * @param btnRightbottom
	 */
	public void updateBlackghost(Button btnLeftup, Button btnRightup, Button btnLeftbottom, Button btnRightbottom){
		final Handler handler = new Handler();

		final Button btn1 = btnLeftup,btn2 = btnRightup, btn3 = btnLeftbottom, btn4 = btnRightbottom; 
		
		Runnable moveblackghost = new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				move(btn1,btn2,btn3,btn4);
				handler.postDelayed(this, 60);
			}	
		};
		
		handler.removeCallbacks(moveblackghost);
		handler.postDelayed(moveblackghost,60);
	}

	/**
	 * get location
	 * @param btn
	 * @return
	 */
	int[] getBtnLocation(Button btn){
		int[] location =new int[2];
		btn.getLocationOnScreen(location);
		int btnX = location[0];
		int btnY = btn.getTop();
		
		int[] btnLocation = new int[2];
		btnLocation[0]=btnX;
		btnLocation[1]=btnY;
		return btnLocation;
	}
	
	/**
	 * Action to be done in run above
	 * @param image
	 * @param btnLeftup
	 * @param btnRightup
	 * @param btnLeftbottom
	 * @param btnRightbottom
	 */
	void move(Button btnLeftup, Button btnRightup, Button btnLeftbottom, Button btnRightbottom){
		LayoutParams par = (LayoutParams)img_blackghost.getLayoutParams();
		int[] locationLeftup = getBtnLocation(btnLeftup);
		int[] locationRightup = getBtnLocation(btnRightup);
		int[] locationLeftButtom = getBtnLocation(btnLeftbottom);
		int[] locationRightButtom = getBtnLocation(btnRightbottom);

		if(par.leftMargin<locationRightup[0]  && par.topMargin<=locationRightup[1]){
			par.leftMargin +=5;
		}
		else if(par.topMargin<locationRightButtom[1] && par.leftMargin>=locationRightup[0]){
			par.topMargin +=5;
		}
		else if(par.topMargin>=locationRightButtom[1] && par.leftMargin>locationLeftButtom[0]){
			par.leftMargin -=5;
		}
		else {par.topMargin -=5;}	
		img_blackghost.setLayoutParams(par);
	}
	
}
