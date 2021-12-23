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
import android.view.View
import com.example.pertemuan5part2.databinding.KalkulasipersegiBinding

class KalkulasiPersegi : AppCompatActivity() {

    private lateinit var persegi: KalkulasipersegiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        persegi = KalkulasipersegiBinding.inflate(layoutInflater)
        setContentView(persegi.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)

        persegi.hitungPrsgi.setOnClickListener { view: View? ->
            if (persegi.sisiPrsgi.length() == 0) {
                Toast.makeText(application, "Maaf Tidak Boleh Kosong !", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(application, "Hasil Telah Di temukan !", Toast.LENGTH_LONG).show()
                val sisi: Double
                val hitungluas: Double
                val hitungkeliling: Double

                sisi = persegi.sisiPrsgi.getText().toString().trim { it <= ' ' }.toDouble()
                hitungluas = sisi * sisi
                hitungkeliling = sisi + sisi + sisi + sisi

                val ctk_hsl_ls = hitungluas.toString()
                persegi.hasilLsPrsgi.setText(ctk_hsl_ls)

                val ctk_hsl_kl = hitungkeliling.toString()
                persegi.hasilKlPrsgi.setText(ctk_hsl_kl)
            }
        }
        persegi.clearTextPrsgi.setOnClickListener { view: View? ->
            persegi.sisiPrsgi.getText().clear()
            persegi.hasilLsPrsgi.setText(null)
            persegi.hasilKlPrsgi.setText(null)
        }
    }
}