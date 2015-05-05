package com.example.accesschecker;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

public class SimpleCheckerView extends CheckerView {
	Context mContext = null;
	String mRamdomResult = null;
	private static final int CONFIG_BITS = 4;
	private static final int CONFIG_TYPE_INT = 0;
	private static final int CONFIG_TYPE_CHAR = 1;
	private static final int CONFIG_TYPE_MIX = 2;

	int mType = 0;
    Paint mPaint ;
    void init(Context context){
    	
		mContext = context;
		mType = CONFIG_TYPE_CHAR;
		genCheckSource();
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setTextSize(30);
		mPaint.setStrokeWidth(3);
    	
    }
	public SimpleCheckerView(Context context) {
		
		super(context);
		init(context);
	}

	public SimpleCheckerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
		// TODO Auto-generated constructor stub
	}

	public SimpleCheckerView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean getCheckResult(String value) {
		if (value != null) {
			return value.equals(mRamdomResult);
		}
		return false;
	}

	char getNextChar() {
		Random r = new Random();
		boolean lowerCase =  r.nextInt(2) == 1 ;
		Log.e("xx","case..."+lowerCase);
		if (lowerCase) {
			return (char) (r.nextInt(26) + 65);
		} else {
			return (char) (r.nextInt(26) + 97);
		}
	}

	int getNextInt() {
		Random r = new Random();
		return r.nextInt(10);
	}

	@Override
	void genCheckSource() {
		// gen Check Source ramdom int;
		Log.d("xx","gen.....");
		mRamdomResult= "";
		switch (mType) {
		case CONFIG_TYPE_INT:
			for (int i = 0; i < CONFIG_BITS; i++) {
				mRamdomResult += getNextInt();
			}
			break;
		case CONFIG_TYPE_CHAR:
			for (int i = 0; i < CONFIG_BITS; i++) {
				mRamdomResult += getNextChar();
			}
			break;
		case CONFIG_TYPE_MIX:
			Random r = new Random();
			if (r.nextInt(2) == 1) {
				mRamdomResult += getNextInt();
			} else {
				mRamdomResult += getNextChar();
			}
			break;
		default:
			break;
		}
		Log.d("xx","gen.....done  "+mRamdomResult);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLUE);
		int height = this.getHeight();
		int width = this.getWidth();
		
		//--------------------------------
		//--A---B---C---D---E---F--------
		//-------------------------------
		//
		if(mRamdomResult == null){
			genCheckSource();
		}
		char[] random= mRamdomResult.toCharArray();
		for(int i = 0 ;i<CONFIG_BITS;i++){
		    Log.e("xx","draw...."+random[i]);
		   canvas.drawText(""+random[i], 10+60*(i),60/* -2*getNextInt()*/, mPaint);
		}
	}

}
