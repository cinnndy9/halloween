package com.assignment.halloween.core;

import android.widget.RelativeLayout.LayoutParams;

public class MoveUtils {
	public static int getBottom(LayoutParams par) {
		return par.topMargin + par.height;
	}

	public static int getHorizCenter(LayoutParams par) {
		return par.leftMargin + par.width / 2;
	}

	public static int getVertCenter(LayoutParams par) {
		return par.topMargin + par.height / 2;
	}

	public static boolean isStrike(LayoutParams par1, LayoutParams par2) {
		return isStrike(par1, par2, par2.width / 2, par1.height / 2);
	}

	public static boolean isStrike(LayoutParams par1, LayoutParams par2, int horizRange, int vertRange) {
		if ((vertRange >= Math.abs((getVertCenter(par1) - getVertCenter(par2))))
				&& (horizRange >= Math.abs(getHorizCenter(par1) - getHorizCenter(par2)))) {
			return true;
		}
		return false;
	}
}
