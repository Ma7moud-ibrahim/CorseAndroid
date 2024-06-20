package com.example.sqlliteinandroid

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sqlliteinandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var dataBaseHelper: ArticleDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            dataBaseHelper = ArticleDBHelper(applicationContext)
            insertData()

            insets
        }
    }

    private fun insertData() {
        binding.btnSave.setOnClickListener {
            val title = binding.inputTitle.text.toString()
            val body = binding.inputBody.text.toString()
            val newEntry = ContentValues().apply {
                put(DB.TITLE,title)
                put(DB.BODY,body)
            }
            dataBaseHelper.writableDatabase.insert(DB.TABLE_NAME,null,newEntry)
        }
        binding.btnLog.setOnClickListener {
            readData()
        }
    }

    private fun readData() {
        val cursor = dataBaseHelper.writableDatabase.rawQuery(
            "SELECT * FROM ${DB.TABLE_NAME}"
            , arrayOf<String>()
        )
        while(cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val title = cursor.getString(1)
            val body = cursor.getString(2)
            Log.d("MAIN ACTIVITY", "$id - $title - $body")
        }
    }

}