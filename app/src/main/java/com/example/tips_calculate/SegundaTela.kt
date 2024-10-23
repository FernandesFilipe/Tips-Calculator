package com.example.tips_calculate

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tips_calculate.databinding.ActivitySegundaTelaBinding

class SegundaTela : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaTelaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySegundaTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //resultado para cada um
        val result = intent.getFloatExtra("Result", 0f)
        val totalaccount = intent.getFloatExtra("totalc", 0f)
        val totalp = intent.getFloatExtra("totalp", 0f)
        val tipsp = intent.getFloatExtra("tips", 0f)


        binding.tvTt.text = totalaccount.toString()
        binding.tvNump.text = totalp.toString()
        binding.tvPerc.text = tipsp.toString()
        binding.tvtotalamount.text = result.toString()


        binding.btnClean.setOnClickListener {
            finish()



        }

    }
}