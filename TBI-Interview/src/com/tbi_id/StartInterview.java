package com.tbi_id;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class StartInterview extends Activity {

	protected String interviewName;
	protected String interviewId;
	protected String interviewAge;
	protected String interviewDate;
	protected HashMap<String,String> data = new HashMap<String,String>();
	protected ArrayList<String> value = new ArrayList<String>();
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.start_interview);

		//Home Button
		ImageButton homeButton = (ImageButton) findViewById(R.id.home_button_main_screen);
		homeButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), com.tbi_id.MainActivity.class);
				startActivity(i);
			}
		});
		
		//Start Interview Button
		ImageButton startInterviewButton = (ImageButton) findViewById(R.id.start_interview_button);
		startInterviewButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				EditText interviewNameInput = (EditText) findViewById(R.id.interviewName);
				interviewName = interviewNameInput.getText().toString();
				EditText interviewIdInput = (EditText) findViewById(R.id.interviewId);
				interviewId = interviewIdInput.getText().toString();
				EditText interviewAgeInput = (EditText) findViewById(R.id.interviewAge);
				interviewAge = interviewAgeInput.getText().toString();
				EditText interviewDateInput = (EditText) findViewById(R.id.date);
				interviewDate = interviewDateInput.getText().toString();
				data.put("Interview Name", interviewName);
				data.put("Interview Id", interviewId);
				data.put("Interview Date", interviewDate);
				data.put("Interview Age", interviewAge);
				data.put("FileName", "tbi"+interviewId+interviewDate);
				

			//	String FILENAME = "tbi_" + interviewId;

			/*	FileOutputStream fos;
				try {
					fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
					fos.write(interviewName.getBytes());
					fos.write("\n".getBytes());
					fos.write(interviewId.getBytes());
					fos.write("\n".getBytes());
					fos.write(interviewAge.getBytes());
					fos.write("\n".getBytes());
					fos.write(interviewDate.getBytes());
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				Intent i = new Intent(getApplicationContext(), com.tbi_id.Step1Activity.class);
				Bundle b = new Bundle();
				b.putSerializable("patientData",data);
				b.putSerializable("questionNum", 1);
				i.putExtras(b);
				startActivity(i);

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
