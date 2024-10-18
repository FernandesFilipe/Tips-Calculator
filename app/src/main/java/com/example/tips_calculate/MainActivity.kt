package com.example.tips_calculate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tips_calculate.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            var percentage: Int = 0
            binding.rb10.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked){
                    percentage = 10
                }
            }

            binding.rb15.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked){
                    percentage = 15
                }
            }

            binding.rb20.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked){
                    percentage = 20
                }
            }

            binding.btnClean.setOnClickListener {
                binding.Price.setText("")
                binding.Numberp.setText("")
                //binding.tvresult.setText("")
                binding.rb10.isChecked = false
                binding.rb15.isChecked = false
                binding.rb20.isChecked = false
            }

        binding.btnCalculate.setOnClickListener {
            val totalaccount = binding.Price.text
            val totalpeople = binding.Numberp.text


            if (totalaccount?.isEmpty() == true || totalpeople?.isEmpty() == true) {
                Snackbar.make(binding.Price,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG ) . show()
            } else {

                val totalac: Float = totalaccount.toString().toFloat()
                val totalp : Float = totalpeople.toString().toFloat()
                val account = totalac / totalp
                val tips = account * percentage / 100
                val tot = tips + account

                val intent = Intent (this, SegundaTela::class.java )
                intent.apply {
                    putExtra("Result", tot)
                    putExtra("totalc", totalac)
                    putExtra("totalp", totalp)
                    putExtra("tips", percentage)
                    }
                startActivity(intent)
            }
        }
    }
}