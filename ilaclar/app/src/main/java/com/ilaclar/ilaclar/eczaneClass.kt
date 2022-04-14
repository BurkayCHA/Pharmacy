package com.ilaclar.ilaclar

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class eczaneClass(var eczaneadi:String, var ilce:String, var adres:String
                       , var telefon:String) : Serializable {



}