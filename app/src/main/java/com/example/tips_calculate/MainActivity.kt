package com.example.tips_calculate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tips_calculate.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val totalaccount = binding.Price.text
            val totalpeople = binding.Numberp.text
            val percentage = binding.tvPercentage.text
            binding.Numberp.setText("")
            binding.tvPercentage.setText("")
            binding.Price.setText("")


            if (totalaccount?.isEmpty() == true || totalpeople?.isEmpty() == true) {
                Snackbar.make(binding.Price,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG ) . show()
            } else {

                val totalac: Float = totalaccount.toString().toFloat()
                val totalp : Float = totalpeople.toString().toFloat()
                val percen : Float = percentage.toString().toFloat()
                val account = totalac / totalp
                val tips = account * percen / 100
                val tot = tips + account

                val intent = Intent (this, SegundaTela::class.java )
                intent.apply {
                    putExtra("Result", tot)
                    putExtra("totalc", totalac)
                    putExtra("totalp", totalp)
                    putExtra("tips", percen)
                    }
                startActivity(intent)
            }
        }
    }
}