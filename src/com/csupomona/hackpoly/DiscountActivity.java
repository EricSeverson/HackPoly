package com.csupomona.hackpoly;

import com.example.hackpoly.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DiscountActivity extends Activity {

	private Discount[] sampleDiscounts = new Discount[5];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discount);
		
		String[] Address0 = {"21550 Valley Boulevard", "City of Industry, CA 91789"};
		sampleDiscounts[0] = new Discount(2, 1, "Chic fil' A", Address0, "Free Medium Drink");
		
		String[] Address1 = {"21555 Valley Boulevard", "Walnut, CA"};
		sampleDiscounts[1] = new Discount(1, 0, "Staples", Address1, "20% off on school supplies");
		
		String[] Address2 = {"3560 W Temple Ave", "Pomona, CA 91768"};
		sampleDiscounts[2] = new Discount(1, 1, "Curry Up", Address2, "10% off");
		
		String[] Address3 = {"1600 S Azusa Ave", "City of Industry, CA"};
		sampleDiscounts[3] = new Discount(0, 0, "Toys R Us", Address3, "5% off");
		
		String[] Address4 = {"13401 Crossroads Pkwy N", "City of Industry, CA"};
		sampleDiscounts[4] = new Discount(0, 0, "Fry's Electronics", Address4, "Free antivirus with purchase of computer");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.discount, menu);
		return true;
	}

}
