package com.assignment.halloween.bat;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;


public class Pumpkin extends Activity{
	
	private static int num;
	private ImageView image;
	private static String result;
	
	public void setPumpkin(ImageView ima){
		image=ima;
		num = 4;
		result="unknown";
	}
	
	public void disappear(){
		this.image.setVisibility(View.INVISIBLE);
		if(num>1){
		   num -=1;
		   System.out.println("pumpkin num: "+num);
		}
		else{
			num = 0;
			result="fail";
			System.out.println("PPK num: "+num+"  Result: "+result);
		}
	}
	
	public String GetResult(){
		return result;
	}

	public ImageView getImage() {
		return image;
	}
	
	public int GetNum(){
		return num;
	}

	public void setImage(ImageView image) {
		this.image = image;
	}

}
