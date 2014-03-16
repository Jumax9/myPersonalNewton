package com.jumax9.mypersonalnewton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, LocationListener {

	// EditText altitud, planeta;
	Spinner planetes;
	String planet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Views
		Button calcular = (Button) findViewById(R.id.calcular);
		planetes = (Spinner) findViewById(R.id.spinnerPlanets);

		// Set listeners 
		calcular.setOnClickListener(this);

		// Refresh GPS position before doing anything with it
		try {
			LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			Criteria criteria = new Criteria();
			//String provider = locationManager.getBestProvider(criteria, false);
			//locationManager.requestLocationUpdates(provider, 400, 1, this);
			locationManager.requestSingleUpdate(criteria, this, null);
		} catch (Exception e) {
			Toast.makeText(this, "Por favor, activa el GPS", Toast.LENGTH_LONG).show();
		}


		// altitud = (EditText) findViewById(R.id.altitud);
		// planeta = (EditText) findViewById(R.id.planetaNum);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void goToCalcular() {
		planet = planetes.getSelectedItem().toString();
		Intent i = new Intent(this, Calculos.class);
		i.putExtra("MainActivity.planeta", planet);
		startActivity(i);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.calcular: // This is the only case as of now
				// altit = Float.parseFloat(altitud.getText().toString());
				// planet = planeta.getText().toString();
				planet = planetes.getSelectedItem().toString();
				Intent i = new Intent(this, Calculos.class);
				// i.putExtra("MainActivity.altitud", altit);
				i.putExtra("MainActivity.planeta", planet);
				startActivity(i);
				break;
		}
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
