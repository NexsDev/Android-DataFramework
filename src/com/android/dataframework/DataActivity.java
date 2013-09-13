package com.android.dataframework;

import android.app.Activity;
import android.os.Bundle;

public class DataActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			DataFramework.getInstance().open(this, getPackageName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void onDestroy() {
		DataFramework.getInstance().close();
	}
}
