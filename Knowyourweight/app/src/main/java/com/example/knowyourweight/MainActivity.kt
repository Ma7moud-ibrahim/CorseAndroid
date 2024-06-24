package com.example.knowyourweight

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.knowyourweight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val blainGravity1 = 14.2
    private val blainGravity2 = 5.2
    private val blainGravity3 = 1.2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.checkBox5.setOnClickListener(this)
        binding.checkBox6.setOnClickListener(this)
        binding.checkBox7.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v as CheckBox
        val checked: Boolean = v.isChecked
        val weightText = binding.editTextText2.text.toString()

        if (weightText.isNotEmpty()) {
            val weight = weightText.toDouble()
            if (checked) {
                calculateWeight(weight, v)
                if (v.id == R.id.checkBox5) {
                    binding.checkBox6.isChecked = false
                    binding.checkBox7.isChecked = false
                }else if (v.id == R.id.checkBox6) {
                    binding.checkBox5.isChecked = false
                    binding.checkBox7.isChecked = false
                }else if (v.id == R.id.checkBox7) {
                    binding.checkBox5.isChecked = false
                    binding.checkBox6.isChecked = false
                }
            }
        }
    }

    private fun calculateWeight(weight: Double, checkBox: CheckBox) {
        val result: Double = when (checkBox.id) {
            R.id.checkBox6 -> weight * blainGravity1
            R.id.checkBox7 -> weight * blainGravity2
            R.id.checkBox5 -> weight * blainGravity3
            else -> weight * blainGravity3
        }
        binding.textView4.text = result.toString()
    }
}
