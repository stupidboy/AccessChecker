package com.example.accesschecker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.*;;

public class CheckerView extends View {

	public static final int CHECK_RESULT_PASS = 0;

	public static final int CHECK_RESULT_FAILD_WANTS_MORE = 1;

	public static final int CHECK_RESULT_FAILD_INC = 2;

	public CheckerView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public CheckerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	public CheckerView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	public boolean getCheckResult(String value){
		return false;
	}
	
	void genCheckSource(){
    //img,string,int,everything		
		
	}
	

}
