package com.ilaclar.ilaclar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_eczaneler.*
import org.json.JSONObject

class eczanelerActivity : AppCompatActivity() {
    private var secilenil = ""
    private var secilenilce = ""
    private lateinit var list:ArrayList<eczaneClass>
    private lateinit var eczaneadapter:eczaneAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eczaneler)

        spinneril.setTitle("İl Seçiniz.")
        spinneril.setPositiveButton("Kapat")
        spinnerilce.setTitle("İlçe Seçiniz.")
        spinnerilce.setPositiveButton("Kapat")

        eczaneRv.setHasFixedSize(true)
        eczaneRv.layoutManager = LinearLayoutManager(this)

        veritabanikopyala()
        val vt = VeritabaniYardimcisi1(this)
        val illiste = Dao_iller().tum(vt)
        val iller = ArrayList<String>()
        iller.clear()

        iller.add("İl Seçiniz")

        for (i in illiste){
            iller.add(i.sehiradi)
        }
        val ilceler = ArrayList<String>()
        if(spinneril != null){
            val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,iller)
            spinneril.adapter = adapter
            spinneril.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    secilenil = iller[p2]
                    ilceler.clear()
                    ilceler.add("İlçe Seçiniz")
                    val ilceliste = Dao_ilceler().tum(vt,p2)
                    for (i in ilceliste){
                        ilceler.add(i.ilceadi)
                    }
                    if(spinnerilce != null){
                        val adapterilce = ArrayAdapter(this@eczanelerActivity,android.R.layout.simple_spinner_item,ilceler)
                        spinnerilce.adapter = adapterilce
                        spinnerilce.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                secilenilce = ilceler[p2]
                                if(secilenil != "İl Seçiniz" && secilenilce != "İlçe Seçiniz"){
                                    getUrl()
                                }
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {

                            }

                        }
                    }

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
        }



    }

    private fun getUrl() {
        var url = "https://api.collectapi.com/health/dutyPharmacy?il="+secilenil+"&ilce="+
                secilenilce
        val request = object : StringRequest(Method.POST,url, Response.Listener { reply ->
            list = ArrayList()
            try {
                val jsonObject = JSONObject(reply)
                val data = jsonObject.getJSONArray("result")
                for (i in 0 until data.length()){
                    val get = data.getJSONObject(i)
                    val data = eczaneClass(get.getString("name")
                        ,get.getString("dist")
                        ,get.getString("address")
                        ,get.getString("phone"))
                    list.add(data)
                }

                eczaneadapter = eczaneAdapter(this@eczanelerActivity,list)
                eczaneRv.adapter = eczaneadapter


            }catch (e:Exception){
                e.printStackTrace()
            }

        }, Response.ErrorListener { error ->  }){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String,String>()
                return params
            }
            override fun getHeaders(): MutableMap<String, String> {
                val params = HashMap<String,String>()
                params["authorization"] = "apikey 7rxTRfaaUMgLKKBvwDYCj6:7kWAOifBhEnMmLja9amd5q"
                params["content-type"] = "application/json"
                return params
            }
        }
        Volley.newRequestQueue(this@eczanelerActivity).add(request)
    }

    fun veritabanikopyala(){
        val db = DatabaseCopyHelper(this)
        try {
            db.createDataBase()
        }catch (e:Exception){

        }
        try {
            db.openDataBase()
        }catch (e:Exception){

        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this@eczanelerActivity,MainActivity::class.java))
        finish()

    }

}