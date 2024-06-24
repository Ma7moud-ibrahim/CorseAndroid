package com.example.myreadsms

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myreadsms.databinding.ActivityMainBinding
import java.net.URI

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            getSms()
            insets
        }
    }
    private fun getSms(){
        val uri = Uri.parse("content://sms//inbox")
        val projection = arrayOf(SMS_SENDER, SMS_BODY)
        val cursor: Cursor = contentResolver.query(uri,projection,null,null,null)!!
        while (cursor.moveToNext()){
            for (i in 0 until cursor.columnCount){
                Log.i(LAG_TAG,"$i - ${cursor.getColumnName(i)} - ${cursor.getString(i)}")
            }
        }
    }

    companion object {
        private const val LAG_TAG = "MAIN_ACTIVITY"
        private const val SMS_BODY ="body"
        private const val SMS_SENDER = "address"
    }
}