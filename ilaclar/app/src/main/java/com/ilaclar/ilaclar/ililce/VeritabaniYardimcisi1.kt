package com.ilaclar.ilaclar

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi1(context:Context) : SQLiteOpenHelper(context,"turkiye.sqlite",null,1){

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE IF NOT EXISTS iller(\n" +
                "   id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "   sehiradi TEXT NOT NULL\n" +
                ")")

        db?.execSQL("CREATE TABLE IF NOT EXISTS ilceler (\n" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  ilceadi varchar(255) NOT NULL,\n" +
                "  sehirid int(11) NOT NULL\n" +
                ")")


    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

        db?.execSQL("DROP TABLE IF EXISTS iller")
        db?.execSQL("DROP TABLE IF EXISTS ilceler")

        onCreate(db)

    }


}