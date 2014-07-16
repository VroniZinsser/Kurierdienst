package com.example.kurierdienstvroni;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class ManagerActivity extends Activity {

	private final String DONE = "done";
	private final String INPROGRESS = "in progress";

	private Button submitButton;
	private Button driverSubmitButton;
	private EditText id;
	private EditText date;
	private EditText time;
	private EditText driver_id;
	private EditText driver_name;
	private EditText driver_location;
	private EditText startAdress;
	private EditText destinationAdress;
	private RadioButton done, inProgress;
	private Context context;

	private String status;
	private AuftragsItem auftrag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setupUI();
		setupButtons();
		context = getApplicationContext();
	}

	private void setupButtons() {
		submitButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (done.isChecked()) {
					status = DONE;
				} else {
					status = INPROGRESS;
				}
				// auftrag = new AuftragsItem(id.toString(), status,
				// date.toString(), startAdress,toString(),
				// destinationAdress.toString(), );
			}
		});

		driverSubmitButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
			}
		});
	}

	private void setupUI() {
		setContentView(R.layout.activity_manager);
		submitButton = (Button) findViewById(R.id.lets_go);
		driverSubmitButton = (Button) findViewById(R.id.fahrer_submit);
		id = (EditText) findViewById(R.id.auftragsnummer);
		date = (EditText) findViewById(R.id.datum);
		time = (EditText) findViewById(R.id.uhrzeit);
		driver_id = (EditText) findViewById(R.id.fahrer_id);
		driver_name = (EditText) findViewById(R.id.fahrer_name);
		driver_location = (EditText) findViewById(R.id.standort);
		startAdress = (EditText) findViewById(R.id.start);
		destinationAdress = (EditText) findViewById(R.id.ziel);
		done = (RadioButton) findViewById(R.id.erledigt);
		inProgress = (RadioButton) findViewById(R.id.ausstehend);
	}

	public interface BarSettingDialogListener {

		public void onDialogPositiveClick(DialogFragment dialog);

	}
}
