package com.assignment.halloween.candy;

import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

public class RoleHelper extends Activity{
	int topmargin, leftmargin;
	ImageView img_role;
	boolean moveLeft=false, moveRight=false, moveUp=false, moveDown=false;
	boolean moveTurn = false;
	boolean isCollision = false;
	Button connectbtn;
	FindCandy bgtest = new FindCandy();
	
	RoleHelper(ImageView img){
		this.img_role = img;
	}
	
	void setImageview(ImageView img){
		img_role = img;
	}
	ImageView getImageview(){
		return img_role;
	}
	
	void setBtn(Button btn){
		connectbtn = btn;
	}
	
	Button getBtn(){
		return connectbtn;
	}
	
	void setTopmarginAndLeftmargin(){
		LayoutParams par = (LayoutParams)img_role.getLayoutParams();
		topmargin = par.topMargin;
		leftmargin = par.leftMargin;
	}
	
	int getTopmaring(){
		return topmargin;
	}
	int getLeftmargin(){
		return leftmargin;
	}
	
	void setDefaultDirc(){
		moveLeft=false;
		moveRight=false;
		moveUp=false;
		moveDown=false;
		moveTurn=false;
	}

	void move(){	
				setDefaultDirc();
				setMovedirection(connectbtn);
				if(isCollision == true) {
					collisionHappen();
				}
				else if(moveLeft==true){
					moveleft(connectbtn);
				} 
				else if(moveRight==true){
					moveright(connectbtn);
				}
				else if(moveDown==true){
					movedown(connectbtn);
				}
				else if(moveUp==true){
					moveup(connectbtn);
				}
	}
	
	
	/**
	 * decide which direction to move
	 * @param btn
	 */
	void setMovedirection(Button btn){
		setTopmarginAndLeftmargin();
		int[] location =new int[2];
		btn.getLocationOnScreen(location);
		if(leftmargin < location[0] && topmargin == btn.getTop()){
			moveRight = true;
		}
		else if(leftmargin > location[0] && topmargin == btn.getTop()){
			moveLeft = true;
		}
		else if(leftmargin==location[0] && topmargin<btn.getTop()){
			if((leftmargin == 255)){
				moveDown = true;
			}
			else if(leftmargin==75 && topmargin >100){
				moveDown = true;
			}
			else if(leftmargin >=345){
				moveDown = true;
			}
			else moveDown = false;
		}
		else if(leftmargin==location[0] && topmargin>btn.getTop()){
			if((topmargin>=75 && leftmargin == 255)|| (leftmargin==75 && topmargin>75) || leftmargin >=345 )
			moveUp = true;
		}	
	}
	
	/**
	 * move image right
	 * @param btnRight
	 */
	void moveright(Button btnRight){
		LayoutParams par = (LayoutParams)img_role.getLayoutParams();
		int[] location =new int[2];
		btnRight.getLocationOnScreen(location);
		
		if(par.leftMargin<location[0] && par.topMargin == btnRight.getTop()){
			par.leftMargin +=5;
		}
		img_role.setLayoutParams(par);
	}
	
	/**
	 * move image left
	 * @param btnLeft
	 */
	 void moveleft(Button btnLeft){
		 LayoutParams par = (LayoutParams)img_role.getLayoutParams();
			int[] location =new int[2];
			btnLeft.getLocationOnScreen(location);
			
			if(par.leftMargin>location[0] && par.topMargin == btnLeft.getTop()){
				par.leftMargin -=5;
			}
			img_role.setLayoutParams(par);
	 }
	 
	 /**
	  * move image up
	  * @param btnUp
	  */
	 void moveup(Button btnUp){
		 LayoutParams par = (LayoutParams)img_role.getLayoutParams();
		 int[] location =new int[2];
		 btnUp.getLocationOnScreen(location);
			
			if(par.leftMargin==location[0] && par.topMargin>btnUp.getTop()){
				par.topMargin -=5;
			}
			img_role.setLayoutParams(par);
	 }
	 
	 /**
	  * move image down
	  * @param btnDown
	  */
	 void movedown(Button btnDown){
		 LayoutParams par = (LayoutParams)img_role.getLayoutParams();
		 int[] location =new int[2];
		 btnDown.getLocationOnScreen(location);
			if(par.leftMargin==location[0] && par.topMargin<btnDown.getTop()){
				par.topMargin +=5;
			}
			img_role.setLayoutParams(par);
	 }
	 
	/**
	 * check whether collision
	 * @param imgCollision
	 */
	void setCollision(ImageView imgCollision){
			//System.out.println("collision: " + isCollision);
			isCollision = false;
			LayoutParams par1 = (LayoutParams)img_role.getLayoutParams();
			LayoutParams par2 = (LayoutParams)imgCollision.getLayoutParams();
			if(par1.topMargin == par2.topMargin){
				if(Math.abs(par1.leftMargin-par2.leftMargin)<par1.width){
					isCollision = true;
				}
			}
			else if(par1.leftMargin == par2.leftMargin){
				if(Math.abs(par1.topMargin-par2.topMargin)<par1.height){
					isCollision = true;
				}
			}
		}
	
	/**
	 * things to be done when collision happened
	 */
	void collisionHappen(){
		//System.out.println("collision: " + isCollision);
		LayoutParams par = (LayoutParams)img_role.getLayoutParams();
		par.leftMargin = 75;
		par.topMargin = 75;
		img_role.setLayoutParams(par);
	}
}
