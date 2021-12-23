package com.example.pertemuan5part2

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import android.widget.TextView
import android.os.Bundle
import android.view.View
import com.example.pertemuan5part2.R
import androidx.core.content.ContextCompat
import android.widget.Toast
import com.example.pertemuan5part2.databinding.BalokKalkulasiBinding

class KalkulasiBalok : AppCompatActivity() {

    private lateinit var balok: BalokKalkulasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        balok = BalokKalkulasiBinding.inflate(layoutInflater)
        setContentView(balok.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        balok.hitungBlk.setOnClickListener{ view: View? ->
            if (balok.panjangBlk.length() == 0 || balok.tinggiBlk.length() == 0 || balok.lebarBlk.length() == 0) {
                Toast.makeText(application, "Maaf Tidak Boleh Kosong Semuanya !", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(application, "Hasil Telah Di temukan !", Toast.LENGTH_LONG).show()
                val p: Double
                val t: Double
                val l: Double

                val hasil_luas: Double
                val hasil_keliling: Double

                p = balok.panjangBlk.getText().toString().trim { it <= ' ' }.toDouble()
                t = balok.tinggiBlk.getText().toString().trim { it <= ' ' }.toDouble()
                l = balok.lebarBlk.getText().toString().trim { it <= ' ' }.toDouble()

                hasil_luas = 2 * (p * l + p * t + l * t)
                hasil_keliling = 4 * (p + l + t)

                val ctk_hsl_ls = hasil_luas.toString()
                balok.hasilLsBalok.setText(ctk_hsl_ls)

                val ctk_hsl_kl = hasil_keliling.toString()
                balok.hasilKlBalok.setText(ctk_hsl_kl)
            }
        }
        balok.clearTextBlk.setOnClickListener{ view: View? ->
            balok.panjangBlk.getText().clear()
            balok.tinggiBlk.getText().clear()
            balok.lebarBlk.getText().clear()
            balok.hasilLsBalok.setText(null)
            balok.hasilKlBalok.setText(null)
        }
    }
}