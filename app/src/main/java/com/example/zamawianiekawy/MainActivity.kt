package com.example.zamawianiekawy

import android.os.Bundle
import android.widget.CheckBox
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
        val radioGroup = findViewById<RadioGroup>(R.id.kawyradio)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val wybor = findViewById<RadioButton>(checkedId).text
        }

            val cukierciukbox = findViewById<CheckBox>(R.id.cukierciukbox)
            val mlekociukbox = findViewById<CheckBox>(R.id.mlekociukbox)

        cukierciukbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val cukier = true;
            } else {
                val cukier = false
            }
        }
        mlekociukbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val mleko = true;
            } else {
                val mleko = false;
            }
        }
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val ilosckawy = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(this@MainActivity, "awaw", Toast.LENGTH_SHORT)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(this@MainActivity, "bwbw", Toast.LENGTH_SHORT)
            }

        })
    }
}