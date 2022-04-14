package com.ilaclar.ilaclar

import android.annotation.SuppressLint

class Dao_iller {

    @SuppressLint("Range")
    fun tum(vt:VeritabaniYardimcisi1) : ArrayList<Class_iller> {

        val liste = ArrayList<Class_iller>()

        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM iller",null)

        while(cursor.moveToNext()){

            val iller = Class_iller(cursor.getInt(cursor.getColumnIndex("id"))
                ,cursor.getString(cursor.getColumnIndex("sehiradi")))

            liste.add(iller)

        }

        return liste
    }

}