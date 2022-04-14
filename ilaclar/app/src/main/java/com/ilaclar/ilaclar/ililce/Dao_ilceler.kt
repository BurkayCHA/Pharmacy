package com.ilaclar.ilaclar

import android.annotation.SuppressLint

class Dao_ilceler {



    @SuppressLint("Range")
    fun tum(vt:VeritabaniYardimcisi1, id:Int) : ArrayList<Class_ilceler> {

        val liste = ArrayList<Class_ilceler>()

        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM ilceler WHERE  ilceler.sehirid = $id",null)

        while(cursor.moveToNext()){

            val ilceler = Class_ilceler(cursor.getInt(cursor.getColumnIndex("id"))
                ,cursor.getString(cursor.getColumnIndex("ilceadi")),cursor.getInt(cursor.getColumnIndex("sehirid")))


            liste.add(ilceler)

        }

        return liste
    }

}