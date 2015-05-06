package com.example.accesschecker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	SimpleCheckerView mChecker;
	Button mButonRegen, mButtonCheck;
	EditText mEditText ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mChecker = (SimpleCheckerView) this.findViewById(R.id.textView1);
		mButonRegen = (Button) this.findViewById(R.id.button1);
		mEditText = (EditText)this.findViewById(R.id.editText1);
		mButonRegen.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (mChecker != null) {
					mChecker.genCheckSource();
				}

			}

		});
		mButtonCheck = (Button) this.findViewById(R.id.button2);
		mButtonCheck.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String value = "";
				value = mEditText.getText().toString();
			    if(mChecker != null){
			    	if( mChecker.getCheckResult(value)){
			    		finish();
			    	}
			       
			    }
				
			}
			
			
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
