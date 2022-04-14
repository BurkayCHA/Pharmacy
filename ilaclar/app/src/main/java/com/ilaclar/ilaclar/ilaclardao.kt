package com.ilaclar.ilaclar

import android.annotation.SuppressLint
import android.content.ContentValues

class ilaclardao {

    fun ilacsil(vt:VeritabaniYardimcisi,ilacid:Int){
        val db = vt.writableDatabase
        db.delete("ilaclar","ilacid=?", arrayOf(ilacid.toString()))
        db.close()
    }

    fun ilacekle(vt:VeritabaniYardimcisi,ilacadi:String,yanetki:String,endikasyon:String){
        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("ilacadi",ilacadi)
        values.put("yanetki",yanetki)
        values.put("endikasyon",endikasyon)

        db.insertOrThrow("ilaclar",null,values)

        db.close()
    }


    @SuppressLint("Range")
    fun tumilaclar(vt:VeritabaniYardimcisi) : ArrayList<ilaclarClass> {
        val db = vt.writableDatabase
        val ilaclarliste = ArrayList<ilaclarClass>()
        val c = db.rawQuery("SELECT * FROM ilaclar",null)

        while (c.moveToNext()){
            val ilac = ilaclarClass(c.getInt(c.getColumnIndex("ilacid"))
                ,c.getString(c.getColumnIndex("ilacadi"))
                ,c.getString(c.getColumnIndex("yanetki"))
                ,c.getString(c.getColumnIndex("endikasyon")))

            ilaclarliste.add(ilac)
        }

        return ilaclarliste
    }

    @SuppressLint("Range")
    fun ilacara(vt:VeritabaniYardimcisi, aramaKelime:String) : ArrayList<ilaclarClass> {
        val db = vt.writableDatabase
        val ilaclarliste = ArrayList<ilaclarClass>()
        val c = db.rawQuery("SELECT * FROM ilaclar WHERE ilacadi like '%$aramaKelime%'",null)

        while (c.moveToNext()){
            val ilac = ilaclarClass(c.getInt(c.getColumnIndex("ilacid"))
                ,c.getString(c.getColumnIndex("ilacadi"))
                ,c.getString(c.getColumnIndex("yanetki"))
                ,c.getString(c.getColumnIndex("endikasyon")))

            ilaclarliste.add(ilac)
        }

        return ilaclarliste
    }
}
