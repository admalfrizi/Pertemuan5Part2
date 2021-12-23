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
import com.example.pertemuan5part2.databinding.SegitigaKalkulasiBinding

class KalkulasiSegitiga : AppCompatActivity() {

    private lateinit var segitiga: SegitigaKalkulasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        segitiga = SegitigaKalkulasiBinding.inflate(layoutInflater)
        setContentView(segitiga.root)


        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        segitiga.hitungSgtga.setOnClickListener { view: View? ->
            if (segitiga.alasSgtga.length() == 0 || segitiga.tinggiSgtga.length() == 0 || segitiga.sisiSgtga.length() == 0) {
                Toast.makeText(application, "Maaf Tidak Boleh Kosong Semuanya !", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(application, "Hasil Telah Di temukan !", Toast.LENGTH_LONG).show()
                val alas: Double
                val tinggi: Double
                val sisi: Double
                val hasil_luas: Double
                val hasil_keliling: Double

                alas = segitiga.alasSgtga.getText().toString().trim { it <= ' ' }.toDouble()
                tinggi = segitiga.tinggiSgtga.getText().toString().trim { it <= ' ' }.toDouble()
                sisi = segitiga.sisiSgtga.getText().toString().trim { it <= ' ' }.toDouble()
                hasil_luas = alas * tinggi / 2
                hasil_keliling = sisi + sisi + sisi

                val ctk_hsl_ls = hasil_luas.toString()
                segitiga.hasilLsSegitiga.setText(ctk_hsl_ls)

                val ctk_hsl_kl = hasil_keliling.toString()
                segitiga.hasilKlSegitiga.setText(ctk_hsl_kl)
            }
        }
        segitiga.clearTextSgtga.setOnClickListener { view: View? ->
            segitiga.alasSgtga.getText().clear()
            segitiga.tinggiSgtga.getText().clear()
            segitiga.sisiSgtga.getText().clear()
            segitiga.hasilLsSegitiga.setText(null)
            segitiga.hasilKlSegitiga.setText(null)
        }
    }
}