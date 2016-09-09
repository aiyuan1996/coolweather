package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper{
	String TAG = "CoolWeatherOpenHelper";
	/**
	 * Province建表语句
	 */
	public static final String CREATE_PROVINCE = "create table Province("
			+ "id integer primary key autoincrement,"//自增长主键
			+ "province_name text,"//省名
			+ "province_code text)";//省级代号
	
	/**
	 * City建表语句
	 */
	public static final String CREATE_CITY = "create table City("
			+ "id integer primary key autoincrement,"//自主增长键
			+ "city_name text,"//城市名
			+ "city_code text,"//市级代号
			+ "province_id integer)";//City表关联Province表的外键
	/**
	 * County 表建表语句
	 */
	public static final String CREATE_COUNTY = "create table County("
			+ "id integer primary key autoincrement,"//自主增长键
			+ "county_name text,"//县名
			+ "county_code text,"//县级代号
			+ "city_id integer)";//County表链City表的外键

	public CoolWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE);
		Log.i(TAG, "province created");
		db.execSQL(CREATE_CITY);
		Log.i(TAG, "city created");
		db.execSQL(CREATE_COUNTY);
		Log.i(TAG, "county created");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
