package com.hnam.asm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SanPhamHelper extends SQLiteOpenHelper {
    public SanPhamHelper(@Nullable Context context) {
        super(context, "SanPhamDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SanPham(\n" +
                "  masp integer PRIMARY KEY AUTOINCREMENT,\n" +
                "  tensp text,\n" +
                "  giaban integer,\n" +
                "  soluong integer\n" +
                ")";
        db.execSQL(sql);
        String data = "INSERT INTO SanPham VALUES\n" +
                "(1,'Nước có ga không đường',70000,10),\n" +
                "(2,'Nưóc lọc tinh khiết',10000,52),\n" +
                "(3,'Trà sửa chân châu',25000,38),\n" +
                "(4,'Trà chanh ',10000,11),\n" +
                "(5,'Soda cacao ',35000,30),\n" +
                "(6,'Bò khô',10000,47),\n" +
                "(7,'Cafe đen truyền thống',50000,24)";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(db);
        }
    }
}
