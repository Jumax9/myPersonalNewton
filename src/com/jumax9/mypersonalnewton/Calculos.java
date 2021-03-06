package com.jumax9.mypersonalnewton;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jumax9.mypersonalnewton.utilities.ElHippyEse;
import com.jumax9.mypersonalnewton.utilities.Utilidades;

@SuppressLint("ShowToast")
public class Calculos extends Activity {
	float altitud;
	float g0, g, coef, rT, rNew;
	String gravedad, planeta, objeto;
	TextView resultado, resultadoPlaneta, resultadoOopart;
	Spinner spinnerOoparts;
	final Context c = this;
	int counter;

	// Population of the spinner
	String[] spinnerPop = { "Aneto", "Calvitero", "Dólmenes de Menga", "Everest", "Mulhacén", "Peña Trevinca", "Pica d\'Estats", "Puig Major", "Teide", "Teleno" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		// Get the content from the intent that got me here
		Bundle extras = getIntent().getExtras();
		planeta = extras.getString("MainActivity.planeta");

		// Read different views
		resultado = (TextView) findViewById(R.id.resultado);
		resultadoPlaneta = (TextView) findViewById(R.id.planetaResultado);
		resultadoOopart = (TextView) findViewById(R.id.ooparts);
		spinnerOoparts = (Spinner) findViewById(R.id.spinnerOoparts);

		// Populate spinner
		poblarSpinner(spinnerOoparts);

		// Write texts
		resultadoPlaneta.setText(Utilidades.planetGravity(planeta));
		calculoAltitud();

		// Toast.makeText(getApplicationContext(), e.toString(),Toast.LENGTH_LONG).show();

		// set listeners
		spinnerOoparts.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				try {
					calculoOopart();
				} catch (Exception e) {
					Toast.makeText(c, e.toString(), Toast.LENGTH_LONG);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void poblarSpinner(Spinner s) {
		// Populates the spinner which contains the ooparts
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < spinnerPop.length; i++) {
			list.add(spinnerPop[i]);
		}
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(dataAdapter);
	}

	public void calculoAltitud() {
		// Calls GPS looking for the altitude over sea level
		// and writes the result for the gravity at that point
		altitud = ElHippyEse.altitude(this);
		resultado.setText(Utilidades.calculation(altitud));
	}

	public void calculoOopart() {
		// Looks in the spinner for the selected object
		// and writes the result for the gravity exerted over you by the object
		objeto = spinnerOoparts.getSelectedItem().toString();
		resultadoOopart.setText(Utilidades.oopartGravity(this, objeto));
	}
}