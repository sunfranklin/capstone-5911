package com.tbi_id;

import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Step1Cause extends Activity {
	protected static int questionNum;
	final Context context = this;
	String cause;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_step1_cause);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		questionNum = (Integer) bundle.get("questionNum");
		final HashMap<String, String> data = (HashMap<String, String>) bundle.getSerializable("patientData");
		EditText enterCause = (EditText) findViewById(R.id.enterCause);
		cause = enterCause.getText().toString();
		Button addEntry = (Button) findViewById(R.id.addEntry);
		Button done = (Button) findViewById(R.id.done);
		
		done.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				data.put("cause" + questionNum, cause);
				Intent i = new Intent(getApplicationContext(),com.tbi_id.Step1Activity.class);
				Bundle b = new Bundle();
				b.putSerializable("patientData", data);
				b.putSerializable("questionNum", questionNum);
				i.putExtras(b);
				startActivity(i);
				
				
			}
		});
		
		
		
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.step1_cause, menu);
		return true;
	}

}
