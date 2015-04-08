package com.muthdra.numberspy;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	
	public static Button button;
	public float n;
	public EditText editText;
	public SharedPreferences settings;
	public SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        settings = getSharedPreferences("settings", MODE_PRIVATE);
        
        prefEditor = settings.edit();
        
        button = (Button) findViewById(R.id.button1);
        editText = (EditText) findViewById(R.id.editText1);
        
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try{
					n = Float.parseFloat(editText.getText().toString());
				}
				catch(Exception e){
					n = 0;
				}
				finally{
					prefEditor.putString("lastN", String.valueOf(n));
					prefEditor.commit();
					Intent intent = new Intent(MainActivity.this, Activity2.class);
					intent.putExtra("n", n);
					startActivity(intent);
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
        	Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        	return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
