package com.example.pertemuan5part2

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import android.os.Bundle
import com.example.pertemuan5part2.R
import androidx.core.content.ContextCompat
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.pertemuan5part2.MainActivity
import android.view.WindowManager
import android.content.Intent
import com.example.pertemuan5part2.KalkulasiPersegi
import com.example.pertemuan5part2.KalkulasiLingkaran
import com.example.pertemuan5part2.KalkulasiSegitiga
import com.example.pertemuan5part2.KalkulasiBalok
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import com.example.pertemuan5part2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainScreen: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainScreen = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainScreen.root)


        setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)

        mainScreen.persegiBtn.setOnClickListener {
            val kepersegi = Intent(applicationContext, KalkulasiPersegi::class.java)
            startActivity(kepersegi)
        }
        mainScreen.lingkaranBtn.setOnClickListener {
            val kelingkaran = Intent(applicationContext, KalkulasiLingkaran::class.java)
            startActivity(kelingkaran)
        }
        mainScreen.segitigaBtn.setOnClickListener {
            val kesegitiga = Intent(applicationContext, KalkulasiSegitiga::class.java)
            startActivity(kesegitiga)
        }
        mainScreen.balokBtn.setOnClickListener {
            val kebalok = Intent(applicationContext, KalkulasiBalok::class.java)
            startActivity(kebalok)
        }
    }

    companion object {
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val win = activity.window
            val winParams = win.attributes
            if (on) {
                winParams.flags = winParams.flags or bits
            } else {
                winParams.flags = winParams.flags and bits.inv()
            }
            win.attributes = winParams
        }
    }
}