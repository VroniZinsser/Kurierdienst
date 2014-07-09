package com.example.kurierdienst2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AuftragDatabase {
	
	// Parameters for the database
		private static final String DATABASE_NAME = "auftrag.db";
		private static final int DATABASE_VERSION = 1;

		// Name of database table
		private static final String DATABASE_TABLE = "Auftrag";
		// Set the names for database columns in table (we only have two columns)
		public static final String KEY_ID = "Auftrags_ID";
		public static final String KEY_STATUS = "Status";
		public static final String KEY_DATE = "Datum";
		public static final String KEY_PICKUPADDRESS = "Abholadresse";
		public static final String KEY_DROPOFFADDRESS = "Zieladresse";
		public static final String KEY_DRIVER = "Fahrer";

		// Stor index of task-column
		public static final int COLUMN_ID_INDEX = 1;
		public static final int COLUMN_STATUS_INDEX = 2;
		public static final int COLUMN_DATE_INDEX = 3;
		public static final int COLUMN_PICKUPADDRESS_INDEX = 3;
		public static final int COLUMN_DROPOFFADDRESS_INDEX = 3;
		public static final int COLUMN_DRIVER_INDEX = 3;

		public static final String TAG = "Database";

		private AdressDBOpenHelper dbHelper;
		private SQLiteDatabase db;

		public AuftragDatabase(Context context) {
			dbHelper = new AdressDBOpenHelper(context, DATABASE_NAME, null,
					DATABASE_VERSION);

		}

		private class AdressDBOpenHelper extends SQLiteOpenHelper {
			private static final String DATABASE_CREATE = "create table "
					+ DATABASE_TABLE + " (" 
					+ KEY_ID + " integer primary key autoincrement, " 
					+ KEY_STATUS + " text, " 
					+ KEY_DATE + " text, "
					+ KEY_PICKUPADDRESS + " text, "
					+ KEY_DROPOFFADDRESS + " text, "
					+ KEY_DRIVER + " text);";

			public AdressDBOpenHelper(Context c, String dbname,
					SQLiteDatabase.CursorFactory factory, int version) {
				super(c, dbname, factory, version);
			}

			@Override
			public void onCreate(SQLiteDatabase db) {
				db.execSQL(DATABASE_CREATE);
			}

			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

			}
		}

		public void open() throws SQLException {
			try {
				db = dbHelper.getWritableDatabase();
			} catch (SQLException e) {
				db = dbHelper.getReadableDatabase();
			}
		}

		public void close() {
			db.close();
		}

		public long insertAdress(AuftragsItem item) {
			ContentValues newAuftragValues = new ContentValues();

			// add the data form the TodoItem object
			newAuftragValues.put(KEY_ID, item.getId());
			newAuftragValues.put(KEY_STATUS, item.getStatus());
			newAuftragValues.put(KEY_DATE, item.getDate());
			newAuftragValues.put(KEY_PICKUPADDRESS, item.getPickUpAddress());
			newAuftragValues.put(KEY_DROPOFFADDRESS, item.getDropOffAddress());
			newAuftragValues.put(KEY_DRIVER, item.getDriver());

			// insert into the database
			return db.insert(DATABASE_TABLE, null, newAuftragValues);
		}

		public void removeAdress(AuftragsItem item) {
			String whereClause = KEY_ID + " = '" + item.getId() + "' AND "
					+ KEY_STATUS + " = '" + item.getStatus() + "' AND "
					+ KEY_DATE + " = '" + item.getDate() + "' AND "
					+ KEY_PICKUPADDRESS + " = '" + item.getPickUpAddress() + "' AND "
					+ KEY_DROPOFFADDRESS + " = '" + item.getDropOffAddress() + "' AND "+ KEY_DRIVER
					+ " = '" + item.getDriver() + "'";

			db.delete(DATABASE_TABLE, whereClause, null);
		}

		public Cursor getAdress() {
			return db.query(DATABASE_TABLE, new String[] {KEY_ID, KEY_STATUS,
					KEY_DATE, KEY_PICKUPADDRESS, KEY_DROPOFFADDRESS, KEY_DRIVER}, null, null, null, null, null);

		}

}