package com.csupomona.hackpoly;

import com.example.hackpoly.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DiscountActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discount);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.discount, menu);
		return true;
	}

}
