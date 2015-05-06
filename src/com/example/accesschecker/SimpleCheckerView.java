package com.example.accesschecker;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Toast;

public class SimpleCheckerView extends CheckerView {
	Context mContext = null;
	String mRamdomResult = null;
	private static final int CONFIG_BITS = 4;
	private static final int CONFIG_TYPE_INT = 0;
	private static final int CONFIG_TYPE_CHAR = 1;
	private static final int CONFIG_TYPE_MIX = 2;
	private static final int CONFIG_LINES = 2;
	private static final int CONFIG_POINTS = 40;
	private static final int CONFIG_CASE = 0;
	int mType ,mCaseSen = 0;
	Paint mPaint;

	void init(Context context) {

		mContext = context;
		mType = CONFIG_TYPE_MIX;
		mCaseSen = CONFIG_CASE;
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
		boolean result = false;
		if (value != null) {
			if (mCaseSen == 1) {
				result = value.equals(mRamdomResult);
			} else {
				result = value.equalsIgnoreCase(mRamdomResult);

			}

		}

		Toast.makeText(mContext, result ? "done" : "try again",
				Toast.LENGTH_SHORT).show();
		if (!result) {
			this.genCheckSource();
		}
		return result;
	}

	char getNextChar() {
		Random r = new Random();
		boolean lowerCase = r.nextInt(5) == 2;
		Log.e("xx", "case..." + lowerCase);
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

	int getNextOffset() {
		Random r = new Random();
		return r.nextInt() % 20;
	}

	@Override
	void genCheckSource() {
		// gen Check Source ramdom int;
		Log.d("xx", "gen.....");
		mRamdomResult = "";
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
			for (int i = 0; i < CONFIG_BITS; i++) {
				if (r.nextInt(2) == 1) {
					mRamdomResult += getNextInt();
				} else {
					mRamdomResult += getNextChar();
				}
			}
			break;
		default:
			break;
		}
		Log.d("xx", "gen.....done  " + mRamdomResult);
		this.invalidate();
	}

	void drawPoints(Canvas canvas) {
		Random r = new Random();
		for (int i = 0; i < CONFIG_POINTS; i++) {
			int x = r.nextInt(getWidth());
			int y = r.nextInt(getHeight());
			canvas.drawPoint(x, y, mPaint);
		}
	}

	void drawLine(Canvas canvas) {
		Random r = new Random();
		for (int i = 0; i < CONFIG_LINES; i++) {
			int y1 = r.nextInt(this.getHeight());
			int y2 = r.nextInt(this.getHeight());
			canvas.drawLine(0, y1, this.getWidth(), y2, mPaint);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLUE);
		int height = this.getHeight();
		int width = this.getWidth();

		// --------------------------------
		// --A---B---C---D---E---F--------
		// -------------------------------
		//
		// if(mRamdomResult == null){
		// genCheckSource();
		// }
		char[] random = mRamdomResult.toCharArray();
		for (int i = 0; i < CONFIG_BITS; i++) {
			Log.e("xx", "draw...." + random[i]);
			canvas.drawText("" + random[i], 10 + 60 * (i),
					60 + getNextOffset(), mPaint);
		}
		// draw line

		drawLine(canvas);
		drawPoints(canvas);
	}

}
