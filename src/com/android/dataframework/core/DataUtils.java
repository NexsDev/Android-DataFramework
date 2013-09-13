package com.android.dataframework.core;

import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.android.dataframework.Entity;

public class DataUtils {

	/**
	 * Carga la informacion de un objeto JSON en una Entity
	 * 
	 * @param object
	 *            Entity a la que se la cargaran los valores
	 * @param jsonObject
	 *            Json de donde se obtendran los valores
	 * @param idName
	 *            Nombre del atributo que representa el ID de la entidad de
	 *            dentro del objecto json. Por ejemplo el ID de la tabla Persona
	 *            es id_Persona
	 * @return
	 */
	public <T extends Entity> T loadData(T object, JSONObject jsonObject, String idName) {
		if (jsonObject != null) {
			Set<String> attributeNames = object.getAttributeNames();
			try {
				object.setValue("_id", jsonObject.get(idName));
				for (String attributeName : attributeNames) {
					object.setValue(attributeName, jsonObject.get(attributeName));
				}
			} catch (JSONException e) {
				new RuntimeException(e);
			}
		}
		return object;
	}

	public static void importWansoftData(SQLiteDatabase db, Context context) {
//		BufferedReader in = null;
//		String reader = "";
//		try {
//			InputStream inputStream = context.getResources().openRawResource(R.raw.wansoft_data);
//
//			InputStreamReader inputreader = new InputStreamReader(inputStream);
//			in = new BufferedReader(inputreader);
//			
//			while ((reader = in.readLine()) != null) {
//				db.execSQL(reader);
//			}
//		} catch (IOException e) {
//			Log.e("Importing Data Error", reader, e);
//		} finally {
//			if (in != null) {
//				try {
//					in.close();
//				} catch (IOException e) {
//					Log.e("Close buffer error", e.getMessage(), e);
//				}
//			}
//		}
	}

}
