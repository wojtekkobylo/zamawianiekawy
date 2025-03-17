package com.example.zamawianiekawy

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val checkBoxMilk = findViewById<CheckBox>(R.id.checkBoxMilk)
        val checkBoxSugar = findViewById<CheckBox>(R.id.checkBoxSugar)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val textViewQuantity = findViewById<TextView>(R.id.textViewQuantity)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonOrder = findViewById<Button>(R.id.buttonOrder)

        var coffeeType = ""
        var coffeeImageRes = R.drawable.espresso


        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            coffeeType = when (checkedId) {
                R.id.radioEspresso -> "Espresso"
                R.id.radioCappuccino -> "Cappuccino"
                R.id.radioLatte -> "Latte"
                else -> ""
            }

            coffeeImageRes = when (checkedId) {
                R.id.radioEspresso -> R.drawable.espresso
                R.id.radioCappuccino -> R.drawable.capuccino
                R.id.radioLatte -> R.drawable.latte
                else -> R.drawable.espresso
            }

            imageView.setImageResource(coffeeImageRes)
        }


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewQuantity.text = "Ilość: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })


        buttonOrder.setOnClickListener {
            val milk = if (checkBoxMilk.isChecked) "z mlekiem" else "bez mleka"
            val sugar = if (checkBoxSugar.isChecked) "z cukrem" else "bez cukru"
            val ilosc = seekBar.progress

            val summary = "Zamówiono: $coffeeType, $milk, $sugar, Ilość: $ilosc"
            Toast.makeText(this, summary, Toast.LENGTH_SHORT).show()

        }
    }
}