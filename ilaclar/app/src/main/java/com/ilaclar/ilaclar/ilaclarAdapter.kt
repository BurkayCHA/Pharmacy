package com.ilaclar.ilaclar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ilaclarAdapter(private val mContext:Context
                     ,private var ilaclarliste:List<ilaclarClass>
                     ,private val vt:VeritabaniYardimcisi)
    : RecyclerView.Adapter<ilaclarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:View) : RecyclerView.ViewHolder(tasarim){
        var ilacAditText:TextView
        var cardEndikasyon:TextView
        var cardYanetki:TextView
        var cardIlac:CardView

        init {
            ilacAditText = tasarim.findViewById(R.id.ilacAditText)
            cardEndikasyon = tasarim.findViewById(R.id.cardEndikasyon)
            cardYanetki = tasarim.findViewById(R.id.cardYanetki)
            cardIlac = tasarim.findViewById(R.id.cardIlac)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.ilac_card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return ilaclarliste.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val ilaclar = ilaclarliste.get(position)

        holder.ilacAditText.setText(ilaclar.ilacadi)

        holder.cardEndikasyon.setOnClickListener {
            alertGosterEndikasyon(ilaclar)
        }
        holder.cardYanetki.setOnClickListener {
            alertGosterYanetki(ilaclar)
        }




    }
    fun alertGosterEndikasyon(ilaclar:ilaclarClass){
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.alert_tasarim,null)
        val alertText = tasarim.findViewById(R.id.alertText) as TextView

        alertText.setText(ilaclar.endikasyon)

        val ilac = AlertDialog.Builder(mContext)

        ilac.setTitle("Endikasyon")
        ilac.setView(tasarim)
        ilac.setPositiveButton("Kapat"){ dialogInterface, i ->


        }


        ilac.create().show()
    }
    fun alertGosterYanetki(ilaclar:ilaclarClass){
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.alert_tasarim,null)
        val alertText = tasarim.findViewById(R.id.alertText) as TextView

        alertText.setText(ilaclar.yanetki)

        val ilac = AlertDialog.Builder(mContext)

        ilac.setTitle("Yan Etki")
        ilac.setView(tasarim)
        ilac.setPositiveButton("Kapat"){ dialogInterface, i ->


        }


        ilac.create().show()
    }


}