package com.csupomona.hackpoly;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.hackpoly.R;

public class MainActivity extends Activity {

	private static LocationManager locationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public static Location getLocation() {
		Criteria criteria = new Criteria();
		String provider = locationManager.getBestProvider(criteria, false);
		return locationManager.getLastKnownLocation(provider);
	}
	
	public void toCompose(View view) {
		Intent intent = new Intent(this, ComposeActivity.class);
		startActivity(intent);
	}
	
	public void toList(View view) {
		Intent intent = new Intent(this, ListActivity.class);
		startActivity(intent);
	}
}
