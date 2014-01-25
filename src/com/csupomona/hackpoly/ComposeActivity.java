package com.csupomona.hackpoly;

import com.csupomona.hackpoly.MainActivity;
import com.example.hackpoly.R;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

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

}
