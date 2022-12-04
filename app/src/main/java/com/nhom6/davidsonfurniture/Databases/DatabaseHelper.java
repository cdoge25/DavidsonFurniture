package com.nhom6.davidsonfurniture.Databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    //ĐỊnh nghĩa CSDL
    public static final String DB_NAME = "cart.sqlite";
    public static final int DB_VERSION = 1;
    public static final String TBL_NAME = "CartProduct";
    public static final String COL_ID = "CartProductId";
    public static final String COL_THUMB = "CartProductThumb";
    public static final String COL_NAME = "CartProductName";
    public static final String COL_TYPE = "CartProductType";
    public static final String COL_COLOR = "CartProductColor";
    public static final String COL_PRICE = "CartProductPrice";
    public static final String COL_QUANTITY = "CartProductQuantity";

    //Constructor

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME
                + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_THUMB + " INTEGER, "
                + COL_NAME + " VARCHAR(50), "
                + COL_TYPE + " VARCHAR(50), "
                + COL_COLOR + " VARCHAR(50), "
                + COL_PRICE + " INTEGER, "
                + COL_QUANTITY + " INTEGER)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //B3: Nếu tồn tại thì xóa + Cập nhật lại ?
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }

    //B4:Select
    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    public void queryData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    //B5: Insert, Update, Delete
    public void execSQL(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
}
