package com.ilaclar.ilaclar

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class eczaneAdapter(private val mContex:Context, private val list:List<eczaneClass>)
    :RecyclerView.Adapter<eczaneAdapter.CardViewTasarimNesneleriniTutucu>() {

    inner class CardViewTasarimNesneleriniTutucu(view: View):RecyclerView.ViewHolder(view){

        val cardeczaneTextView:TextView
        val cardilceTextView:TextView
        val cardAdresTextView:TextView
        val cardTelefonTextView:TextView
        init {

            cardeczaneTextView = view.findViewById(R.id.cardeczaneTextView)
            cardilceTextView = view.findViewById(R.id.cardilceTextView)
            cardAdresTextView = view.findViewById(R.id.cardAdresTextView)
            cardTelefonTextView = view.findViewById(R.id.cardTelefonTextView)
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewTasarimNesneleriniTutucu {
        val tasarim = LayoutInflater.from(mContex).inflate(R.layout.tasarimeczanelayout,parent,false)
        return CardViewTasarimNesneleriniTutucu(tasarim)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardViewTasarimNesneleriniTutucu, position: Int) {
        val liste = list[position]
        holder.cardeczaneTextView.text = "Eczane: " + liste.eczaneadi
        holder.cardilceTextView.text = "İlçe: " + liste.ilce
        holder.cardAdresTextView.text = "Adres: " + liste.adres
        holder.cardTelefonTextView.text = "Telefon: " + liste.telefon

    }

    override fun getItemCount(): Int {
        return list.size
    }


}