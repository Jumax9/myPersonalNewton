package com.jumax9.mypersonalnewton.utilities;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class ElHippyEse  implements LocationListener {
	// Didn't want to use Google play services
	// Because I wanted this app to run into a toaster
	// Not a cylon, I meant a very old phone

	public static float altitude(Context c) {
		// Gets altitude over sea level
		float altitud;
		try {
			LocationManager locationManager = (LocationManager) c.getSystemService(Context.LOCATION_SERVICE);
			Criteria criteria = new Criteria();
			String bestProvider = locationManager.getBestProvider(criteria, false);
			Location location = locationManager.getLastKnownLocation(bestProvider);
			altitud = (float) location.getAltitude();
		} catch (Exception e) {
			altitud = 4;
		}
		return altitud;
	}

	public static double[] myPosition(Context c) {
		// returns longitude and latitude
		double longitude, latitude;
		try {
			LocationManager locationManager = (LocationManager) c.getSystemService(Context.LOCATION_SERVICE);
			Criteria criteria = new Criteria();
			String bestProvider = locationManager.getBestProvider(criteria, false);
			Location location = locationManager.getLastKnownLocation(bestProvider);
			longitude = location.getLongitude();
			latitude = location.getLatitude();
		} catch (Exception e) {
			longitude = -1f;
			latitude = 37f;
		}
		return new double[] { longitude, latitude };
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
