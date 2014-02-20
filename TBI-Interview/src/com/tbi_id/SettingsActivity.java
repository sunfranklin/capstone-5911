package com.tbi_id;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.settings);

		SharedPreferences sharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		
		EditText enterEmailHipaa = (EditText) findViewById(R.id.emailEnterHipaa);
		TextView emailNotif = (TextView) findViewById(R.id.enterEmailNotif);

		Boolean checked = sharedPrefs.getBoolean("checkboxHipaa", false);
		if (checked == false) {
			enterEmailHipaa.setVisibility(View.GONE);
			emailNotif.setVisibility(View.GONE);

		}
		

		else

		{
			SharedPreferences.Editor editor = sharedPrefs.edit();
			String email = sharedPrefs.getString("hipaaEmail", "ahmad.k.farag@gmail.com");
			enterEmailHipaa.setText(email);
			

		}

		
		
		
		CheckBox checkBoxHipaa = (CheckBox) findViewById(R.id.hippaCompliance);
		checkBoxHipaa.add
		
		
		
	}
}
