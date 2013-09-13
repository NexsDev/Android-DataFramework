package com.android.dataframework.entity;

import android.database.Cursor;
import com.android.dataframework.Entity;

public class Post extends Entity{

	public static final String TABLE_NAME = "post";

	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_TEXT = "text";
	public static final String COLUMN_USER_ID = "user_id";

	public Post(Cursor c) {
		super(TABLE_NAME, c);
	}

	public Post(int id) {
		super(TABLE_NAME, (long)id);
	}

	public Post(String xml) {
		super(TABLE_NAME, xml);
	}

	public Post() {
		super(TABLE_NAME);
	}

	public String getText() {
		return getString(COLUMN_TEXT);
	}

	public void setText(String text) {
		setValue(COLUMN_TEXT, text);
	}

	public Integer getUserId() {
		return getInt(COLUMN_USER_ID);
	}

	public void setUserId(Integer user_id) {
		setValue(COLUMN_USER_ID, user_id);
	}

}