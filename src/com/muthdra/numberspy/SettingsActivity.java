package com.muthdra.numberspy;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;

public class SettingsActivity extends Activity {

	public SharedPreferences settings;
	public CheckBox sin,cos,hex,oct,bin,roman,isPrime,log;
	public SharedPreferences.Editor prefEditor;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.settings);
	
	    settings = getSharedPreferences("settings", MODE_PRIVATE);
	    
	    sin = (CheckBox)findViewById(R.id.sin);
	    sin.setChecked(settings.getBoolean("sin", true));
	    
	    cos = (CheckBox)findViewById(R.id.cos);
	    cos.setChecked(settings.getBoolean("cos", true));
	    
	    hex = (CheckBox)findViewById(R.id.hex);
	    hex.setChecked(settings.getBoolean("hex", true));
	    
	    oct = (CheckBox)findViewById(R.id.oct);
	    oct.setChecked(settings.getBoolean("oct", true));
	    
	    bin = (CheckBox)findViewById(R.id.bin);
	    bin.setChecked(settings.getBoolean("bin", true));
	    
	    roman = (CheckBox)findViewById(R.id.roman);
	    roman.setChecked(settings.getBoolean("roman", true));
	    
	    isPrime = (CheckBox)findViewById(R.id.isPrime);
	    isPrime.setChecked(settings.getBoolean("isPrime", true));
	    
	    log = (CheckBox)findViewById(R.id.log);
	    log.setChecked(settings.getBoolean("log", true));
	    // TODO Auto-generated method stub
	}
	
	@Override
	protected void onStop(){
		super.onStop();
	    prefEditor = settings.edit();
		prefEditor.putBoolean("sin", sin.isChecked());
		prefEditor.putBoolean("cos", cos.isChecked());
		prefEditor.putBoolean("hex", hex.isChecked());
		prefEditor.putBoolean("oct", oct.isChecked());
		prefEditor.putBoolean("bin", bin.isChecked());
		prefEditor.putBoolean("roman", roman.isChecked());
		prefEditor.putBoolean("isPrime", isPrime.isChecked());
		prefEditor.putBoolean("log", log.isChecked());
		prefEditor.commit();
	}
	
}
