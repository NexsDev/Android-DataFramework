package com.android.dataframework.entity;

import android.database.Cursor;
import com.android.dataframework.Entity;

public class User extends Entity{

	public static final String TABLE_NAME = "user";

	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "name";

	public User(Cursor c) {
		super(TABLE_NAME, c);
	}

	public User(int id) {
		super(TABLE_NAME, (long)id);
	}

	public User(String xml) {
		super(TABLE_NAME, xml);
	}

	public User() {
		super(TABLE_NAME);
	}

	public String getName() {
		return getString(COLUMN_NAME);
	}

	public void setName(String name) {
		setValue(COLUMN_NAME, name);
	}

}