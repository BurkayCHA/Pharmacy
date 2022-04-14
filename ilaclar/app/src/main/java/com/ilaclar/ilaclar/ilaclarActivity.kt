package com.ilaclar.ilaclar

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_ilaclar.*

class ilaclarActivity : AppCompatActivity(),SearchView.OnQueryTextListener {

    private lateinit var ilaclarliste:ArrayList<ilaclarClass>
    private lateinit var adapter:ilaclarAdapter
    private lateinit var preferences: SharedPreferences
    private lateinit var vt:VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ilaclar)



        toolbar.title = "İlaçlar"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        vt = VeritabaniYardimcisi(this)

        tumKisilerAl()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu?.findItem(R.id.action_ara)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }



    override fun onQueryTextSubmit(query: String): Boolean {
        aramaYap(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        aramaYap(newText)
        return true
    }

    fun tumKisilerAl(){
        preferences = getSharedPreferences("db", MODE_PRIVATE)
        var durum = preferences.getString("eklendi","").toString()

        if(durum.isNullOrEmpty()){
            ilaclardao().ilacekle(vt,"DOLOREX draje 50 mg","Gastrointestinal, dermatolojik, üriner yan etkiler.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/109/dolorex-50-mg-20-draje","Post-operatif ağrı ve enflamasyonlar, primer dismenore ve diğer ağrılı jinekolojik hastalıklar, travmatik enflamasyonlar, omurga ağrıları, KBB hastalıkları, romatizmal ağrılar.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/109/dolorex-50-mg-20-draje")
            ilaclardao().ilacekle(vt,"Apranax Forte 550 Mg 10 Tablet","Gastrointestinal, dermatolojik, kardiyovasküler ve santral sinir sistemi ile ilgili yan etkiler görülebilir.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/2/apranax-forte-550-mg-10-tablet","Migren profilaksisi ve akut migren krizi, nevralji, siyatalji, miyalji. Dismenorede analjezi sağlamak ve menorajide menstruel kan kaybını azaltmak amacıyla. Ağrılı dental problemler, diş çekimi sonrası görülen ağrılarda analjezik ve antienflamatuar olarak. Burkulma, gerilme gibi spor kazaları ve post-operatif ağrılarda. Bursit, tendinit, sinovit, tenosinovit, lumbago.\n" +
                    "\n" +
                    "Enfeksiyöz hastalıklarda spesifik tedaviye ilave olarak analjezik ve antipiretik amaçla. Romatoid artrit, osteoartrit, ankilozan spondilit, juvenil romatoid artrit ve akut gut tedavisinde.   \n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/2/apranax-forte-550-mg-10-tablet")
            ilaclardao().ilacekle(vt,"Karvezide 300 Mg/12,5 Mg 28 Tablet","Baş ağrısı,baş dönmesi,yorgunluk, bulantı ve kusma gibi.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/151/karvezide-300-mg-12-5-mg-28-tablet","Esansiyel hipertansiyon tedavisinde. Tek başına irbesartan veya hidroklorotiazid ile kan basıncının yeterli oranda kontrol altına alınamaması durumunda kullanılır.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/151/karvezide-300-mg-12-5-mg-28-tablet")
            ilaclardao().ilacekle(vt,"Biofenac 100 Mg 20 Film Tablet","Yan etkilerin çoğunluğu gastrointestinal'dir (dispepsi, karın ağrısı, bulantı ve ishal). En sık rastlanılanları ise dispepsi (%7,5) ve karın ağrısıdır (%6,2).\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/287/biofenac-100-mg-20-film-tablet","Osteoartrit, romatoid artrit ve ankilozan spondilitdeki ağrı ve iltihabın sempomatik tedavisi.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/287/biofenac-100-mg-20-film-tablet")
            ilaclardao().ilacekle(vt,"Fludex Sr 1,5 Mg 30 Film Tablet","Hipokalemi ile birlikte potasyum kaybı, hipovolemi, dehidratasyon, hiponatremi, metabolik alkaloz, plazma ürik asit ve glukoz düzeylerinde artış, nadiren trombositopeni, lökopeni, agranülositoz, hemolitik anemi, hepatik yetersizlikte hepatik ensefalopati gelişimi, dermatolojik aşırı duyarlılık reaksiyonları, bazen bulantı, kabızlık ve yorgunluk gibi.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/157/fludex-sr-1-5-mg-30-film-tablet","Basit esansiyel hipertansiyon, kardiyak oküler, renal ve serebral komplikasyonlarla birlikte görülen hipertansiyonda endikedir.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/157/fludex-sr-1-5-mg-30-film-tablet")
            ilaclardao().ilacekle(vt,"Lustral 50 Mg 28 Tablet","Klinik Çalışmalarda Elde Edilen Veriler; Depresyon ve obsesif kompulsif bozukluk için yapılan çok dozlu klinik çalışmalarda sertralin kullanımı ile plaseboya göre daha sık görülen yan etkiler: Otonom sinir sistem: ağız kuruluğu ve terleme artışı Santral ve periferik sinir sistemi: baş dönmesi ve tremor Gastrointestinal sistem: diyare/yumuşak gaita, dispepsi ve bulantı\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/140/lustral-50-mg-28-tablet","LUSTRAL®, depresyon tedavisinde, hastalarda mani hikayesi olsun veya olmasın, endikedir.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/140/lustral-50-mg-28-tablet")
            ilaclardao().ilacekle(vt,"Paxil 20 Mg 28 Tablet","Aşağıdaki belirtilen advers etkilerin bazılarının sıklık ve şiddetinde, devam eden tedavi ile azalma görülebilir. Aşağıda listelenen advers etkiler organ sistemlerine ve sıklıklarına göre listelenmiştir.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/298/paxil-20-mg-28-tablet","Yetişkinler:\n" +
                    "Depresyon: Tepkisel ve şiddetli depresyon ve anksiyetenin eşlik ettiği depresyon dahil olmak üzere tüm depresyon tiplerine ait semptomların tedavisinde endikedir. Başlangıçta yeterli cevap alınmasını takiben Paxil ile tedaviye devam depresyon relapsını önlemede etkilidir.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/298/paxil-20-mg-28-tablet")
            ilaclardao().ilacekle(vt,"Dekort 0,5 Mg 20 Tablet","Ay yüz, yağ depolanması, ödem, hipertansiyon, deride atroti, depresyon, peptik ülser, hipergilsemi, halsizlik ve göz içi basıncında artma gibi yan etkiler görülebilir.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/55/dekort-0-5-mg-20-tablet","Farmasötik şekle göre: Enflamatuar ve allerjik hastalıkların supresyonunda, şokta, Cushing Hastalığı teşhisinde, konjenital adrenal hiperplazide, serebral ödemde, intraartiküler enjeksiyonla romatoid artritte endikedir.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/55/dekort-0-5-mg-20-tablet")
            ilaclardao().ilacekle(vt,"Vermidon 500 Mg 30 Tablet","Nadiren ürtiker,kaşıntı gibi allerjik cilt reaksiyonları görülebilir.İlacın kesilmesiyle bu etkiler ortadan kalkar.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/419/vermidon-500-mg-30-tablet","ağrı ve ateşle seyreden çeşitli hastalıkların tedavisinde ağrı kesici ve ateş düşürücü etkisiyle semptomatik iyileşme sağlar.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/419/vermidon-500-mg-30-tablet")
            ilaclardao().ilacekle(vt,"Parol 500 Mg 20 Tablet","Parasetamol nadiren alerjik ve aşırı duyarlılık reaksiyonlarına ve makülopapüler döküntülere neden olabilir.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/18/parol-500-mg-20-tablet","Baş ve diş ağrıları, migren, dismenore, miyalji, nevralji, tüm müsküloskeletal ve\n" +
                    "tonsilektomi ağrılarında analjezik; soğuk algınlığı, influenza ve diğer bakteriyel ve viral enfeksiyonlar da ise hem analjezik hem de antipiretik etki gösterir.\n" +
                    "\n" +
                    "https://www.ilacprospektusu.com/ilac/18/parol-500-mg-20-tablet")
            var SharedPreferences = this.getSharedPreferences("db", MODE_PRIVATE)
            var ipeditor = SharedPreferences.edit()
            ipeditor.putString("eklendi","1").apply()
        }


        ilaclarliste = ilaclardao().tumilaclar(vt)

        adapter = ilaclarAdapter(this,ilaclarliste,vt)

        rv.adapter = adapter
    }

    fun aramaYap(aramaKelime:String){
        ilaclarliste = ilaclardao().ilacara(vt,aramaKelime)

        adapter = ilaclarAdapter(this,ilaclarliste,vt)

        rv.adapter = adapter
    }

    override fun onBackPressed() {
        startActivity(Intent(this@ilaclarActivity,MainActivity::class.java))
        finish()
    }
}
