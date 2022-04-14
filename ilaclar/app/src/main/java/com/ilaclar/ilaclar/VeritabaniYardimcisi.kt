package com.ilaclar.ilaclar

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi(context:Context)
    : SQLiteOpenHelper(context,"rehber.sqlite",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ilaclar (ilacid INTEGER PRIMARY KEY AUTOINCREMENT,ilacadi TEXT,yanetki TEXT,endikasyon TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ilaclar")
        onCreate(db)
    }
}