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
import com.example.pertemuan5part2.databinding.LingkaranCalculatorBinding

class KalkulasiLingkaran : AppCompatActivity() {

    private lateinit var lingkaran: LingkaranCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lingkaran = LingkaranCalculatorBinding.inflate(layoutInflater)
        setContentView(lingkaran.root)


        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        lingkaran.hitungLngkrn.setOnClickListener { view: View? ->
            if (lingkaran.jrJrLngkrn.length() == 0) {
                Toast.makeText(application, "Maaf Tidak Boleh Kosong Semuanya !", Toast.LENGTH_LONG)
                    .show()
            } else {

                Toast.makeText(application, "Hasil Telah Di temukan !", Toast.LENGTH_LONG).show()

                val jr_jr: Double
                val hs_ls: Double
                val hs_kl: Double

                jr_jr = lingkaran.jrJrLngkrn.getText().toString().trim { it <= ' ' }.toDouble()
                hs_ls = 3.14 * jr_jr * jr_jr
                hs_kl = 2 * 3.14 * jr_jr

                val ctk_hsl_ls = hs_ls.toString()
                lingkaran.hslLsLingkaran.setText(ctk_hsl_ls)

                val ctk_hsl_kl = hs_kl.toString()
                lingkaran.hslKlLingkaran.setText(ctk_hsl_kl)
            }
        }
        lingkaran.clearTextLngkrn.setOnClickListener{ view: View? ->
            lingkaran.jrJrLngkrn.getText().clear()
            lingkaran.hslLsLingkaran.setText(null)
            lingkaran.hslKlLingkaran.setText(null)
        }
    }
}