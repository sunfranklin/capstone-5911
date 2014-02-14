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
import android.widget.ImageButton;
import android.widget.TextView;

public class Step1Activity extends Activity {

	final Context context = this;
	protected static int questionNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_step1);
		Intent intent = getIntent();
		Bundle b = intent.getExtras();
		questionNum = b.getInt("questionNum");
		TextView question = (TextView) findViewById(R.id.step_1_question);
		getQuestion(context, question, questionNum);
		@SuppressWarnings("unchecked")
		final HashMap<String, String> data = (HashMap<String, String>) b.getSerializable("patientData");
		ImageButton yesButton = (ImageButton) findViewById(R.id.step_1_question_yes);
		yesButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				boolean alreadyAnswered = data.containsKey("question"
						+ questionNum);
				if (alreadyAnswered == false) {
					data.put("question" + questionNum, "yes");
					questionNum++;
					Intent i = new Intent(getApplicationContext(),com.tbi_id.Step1Cause.class);
					Bundle b = new Bundle();
					b.putSerializable("patientData", data);
					b.putSerializable("questionNum", questionNum);
					i.putExtras(b);
					startActivity(i);
				}

				else {
					data.remove("question" + questionNum);
					data.put("question" + questionNum, "yes");
					questionNum++;
					Intent i = new Intent(getApplicationContext(),com.tbi_id.Step1Cause.class);
					Bundle b = new Bundle();
					b.putSerializable("patientData", data);
					b.putSerializable("questionNum", questionNum);
					i.putExtras(b);
					startActivity(i);
				}

			}

		});

		ImageButton noButton = (ImageButton) findViewById(R.id.step_1_question_no);
		noButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				boolean alreadyAnswered = data.containsKey("question"
						+ questionNum);
				if (alreadyAnswered == false) {
					data.put("question" + questionNum, "no");
					questionNum++;
					Intent i = new Intent(getApplicationContext(),com.tbi_id.Step1Activity.class);
					Bundle b = new Bundle();
					b.putSerializable("patientData", data);
					b.putSerializable("questionNum", questionNum);
					i.putExtras(b);
					startActivity(i);
				}

				else {
					data.remove("question" + questionNum);
					data.put("question" + questionNum, "no");
					questionNum++;
					Intent i = new Intent(getApplicationContext(),com.tbi_id.Step1Activity.class);
					Bundle b = new Bundle();
					b.putSerializable("patientData", data);
					b.putSerializable("questionNum", questionNum);
					i.putExtras(b);
					startActivity(i);
				}

			}

	});
	}

	private void getQuestion(Context context, TextView question, int questionNum) {

		
		if( questionNum == 1)
		{
			question.setText(context.getString(R.string.step_1_question1));

		}
		else if( questionNum == 2)
		{
			question.setText(context.getString(R.string.step_1_question2));

		}
		else if( questionNum == 3)
		{
			question.setText(context.getString(R.string.step_1_question3));

		}
		else if( questionNum == 4)
		{
			question.setText(context.getString(R.string.step_1_question4));

		}
		else if( questionNum == 5)
		{
			question.setText(context.getString(R.string.step_1_question5));

		}
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.step1, menu);
		return true;
	}

}
