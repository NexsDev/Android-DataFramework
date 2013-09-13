package com.android.dataframework.entity;

import android.database.Cursor;
import com.android.dataframework.Entity;

public class Comment extends Entity{

	public static final String TABLE_NAME = "comment";

	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_POST_ID = "post_id";
	public static final String COLUMN_TEXT = "text";
	public static final String COLUMN_USER_ID = "user_id";

	public Comment(Cursor c) {
		super(TABLE_NAME, c);
	}

	public Comment(int id) {
		super(TABLE_NAME, (long)id);
	}

	public Comment(String xml) {
		super(TABLE_NAME, xml);
	}

	public Comment() {
		super(TABLE_NAME);
	}

	public Integer getPostId() {
		return getInt(COLUMN_POST_ID);
	}

	public void setPostId(Integer post_id) {
		setValue(COLUMN_POST_ID, post_id);
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