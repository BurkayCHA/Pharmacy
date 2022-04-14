package com.ilaclar.ilaclar


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ilaclarBtn.setOnClickListener {
            startActivity(Intent(this,ilaclarActivity::class.java))
            finish()
        }
        nobetciEczaneBtn.setOnClickListener {

            startActivity(Intent(this,eczanelerActivity::class.java))
            finish()

        }

    }


}