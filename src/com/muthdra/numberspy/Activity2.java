package com.muthdra.numberspy;

import java.util.Map;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity2 extends Activity {
	public Bundle bundle;
	public float n;
	public TextView title;
	public TextView info[];
	public SharedPreferences settings;
	public Spyable s;
	public LinearLayout linearLayout;
	public Map<String, ?> settingsMap;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_activity2);
	    bundle = getIntent().getExtras();
	    n = bundle.getFloat("n");
	    linearLayout = (LinearLayout)findViewById(R.id.linear);
	    
	    s = new Spyable(n);
	    settings = getSharedPreferences("settings",MODE_PRIVATE);
	    settingsMap = settings.getAll();
	    
	    TextView newTextViewNumber= new TextView(this);
	    newTextViewNumber.setText(String.valueOf(n));
	    newTextViewNumber.setTextColor(Color.BLACK);
	    newTextViewNumber.setTextSize(32);
	    newTextViewNumber.setPadding(0,0,0,20);
		linearLayout.addView(newTextViewNumber);
	    
	    for (Map.Entry<String, ?> entry : settingsMap.entrySet()) {
	        Log.w("map values", entry.getKey() + ": " + entry.getValue().toString());
	        if(entry.getValue().toString() == "true"){
	        	switch(entry.getKey()){
	        	case "sin":
	        		addValue("Sine", s.getSin());
	        		break;
	        	case "cos":
	        		addValue("Cosine", s.getCos());
	        		break;
	        	case "log":
	        		addValue("Logarithm", s.getLog());
	        		break;
	        	case "hex":
	        		addValue("Hexadecimal", s.getHex());
	        		break;
	        	case "oct":
	        		addValue("Octal", s.getOct());
	        		break;
	        	case "bin":
	        		addValue("Binary", s.getBin());
	        		break;
	        	case "roman":
	        		addValue("Roman Numbers", s.getRoman());
	        		break;
	        	case "isPrime":
	        		addValue("Is Prime", s.getIsPrime());
	        		break;
		        }
	        }
	    }
	}
	
	public void addValue(String name, String value){
		TextView newTextViewName = new TextView(this);
		newTextViewName.setText(name);
		newTextViewName.setTextColor(Color.BLACK);
		newTextViewName.setTextSize(20);
		linearLayout.addView(newTextViewName);
		
		TextView newTextViewValue = new TextView(this);
		newTextViewValue.setText(value);
		newTextViewValue.setTextSize(15);
		linearLayout.addView(newTextViewValue);
		
	}

}
