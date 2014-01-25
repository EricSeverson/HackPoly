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
import android.widget.EditText;
import android.widget.Toast;

import com.example.hackpoly.R;

public class ComposeActivity extends Activity {
	
	private LocationManager locationManager;
	private String provider;
	private Geocoder geo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compose);
		Location location = MainActivity.getLocation();
		if (location != null) {
			System.out.println("Provider " + provider + " has been selected.");
		}
		geo = new Geocoder(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compose, menu);
		return true;
	}
	
	public void getGPS(View view) {
		Location location = MainActivity.getLocation();
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
		EditText editText = (EditText) findViewById(R.id.address);
		try {
			List<Address> addresses = geo.getFromLocationName(editText.getText().toString(), 20);
			Location mLocation = MainActivity.getLocation();
			int minIndex = 0;
			double minVal = 0;
			for (int i = 0; i < addresses.size(); i++) {
				float results[] = new float[1];
				Location.distanceBetween(mLocation.getLatitude(), mLocation.getLongitude(),
						addresses.get(i).getLatitude(), addresses.get(i).getLongitude(), results);
				if (minVal == 0 || results[0] < minVal) {
					minVal = results[0];
					minIndex = i;
				}
			}
			Address destLocation = geo.getFromLocation(addresses.get(minIndex).getLatitude(), addresses.get(minIndex).getLongitude(), 1).get(0);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(addresses.get(minIndex).getLatitude() + " " + addresses.get(minIndex).getLongitude() + "\n" + destLocation.getAddressLine(0) + "\n" + destLocation.getAddressLine(1)).setTitle("Addresses");
			AlertDialog dialog = builder.create();
			dialog.show();
			Log.i("Error Message", "Address used = " + addresses.get(minIndex) + "at index " + minIndex);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
