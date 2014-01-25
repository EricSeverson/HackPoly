package com.csupomona.hackpoly;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.hackpoly.R;

public class ComposeActivity extends Activity {
	
	private LocationManager locationManager;
	private String provider;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compose);
		Location location = MainActivity.getLocation();
		if (location != null) {
			System.out.println("Provider " + provider + " has been selected.");
		}
		Toast.makeText(this, location.getLatitude() + " " + location.getLongitude(), Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compose, menu);
		return true;
	}
	
	public void getGPS(View view) {
		Location location = MainActivity.getLocation();
		Geocoder geo = new Geocoder(this);
		try {
			List<Address> l = geo.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
			String addresses = "";
			for (Address a : l) {
				for (int i = 0; i <= a.getMaxAddressLineIndex(); i++) {
					addresses += a.getAddressLine(i) + "\n";				
				}
			}
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(addresses).setTitle("Addresses");
			AlertDialog dialog = builder.create();
			dialog.show();
		} catch (IOException e) {
			Log.i("Error", "IOEXception I suppose");
		}
	}
	
	public void submitDiscount(View view) {
		
	}

}
