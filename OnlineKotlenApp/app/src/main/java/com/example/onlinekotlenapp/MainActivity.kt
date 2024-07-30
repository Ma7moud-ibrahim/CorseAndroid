package com.example.onlinekotlenapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.onlinekotlenapp.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val fragmentOne = OneFragment()
    val fragmentTwo = TwoFragment()
    var isFragmentOneDisplayed = true
    var isFragmentTwoDisplayed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initially add fragmentOne
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentContainerView.id, fragmentOne)
            .commit()

        binding.button.setOnClickListener {
            if (!isFragmentTwoDisplayed) {
                supportFragmentManager.beginTransaction()
                    .replace(binding.fragmentContainerView.id, fragmentTwo)
                    .commit()
                isFragmentTwoDisplayed = true
                isFragmentOneDisplayed=false
            } else {
                finish()
                exitProcess(0)
            }
        }


        binding.button2.setOnClickListener {
            if (!isFragmentOneDisplayed) {
                supportFragmentManager.beginTransaction()
                    .replace(binding.fragmentContainerView.id, fragmentOne)
                    .commit()
                isFragmentOneDisplayed = true
                isFragmentTwoDisplayed= false
            } else {
                finish()
                exitProcess(0)
            }
        }
    }
    fun sendDataToFragmentTwo(data: String) {
        val bundle = Bundle()
        bundle.putString("key", data)
        fragmentTwo.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerView.id, fragmentTwo)
            .commit()
    }
}
