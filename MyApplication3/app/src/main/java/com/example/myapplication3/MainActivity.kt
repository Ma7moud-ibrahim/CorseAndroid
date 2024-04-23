package com.example.myapplication3

import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//     val myfragmentone = OneFragment()
//     val myfragmenttwo = TwoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            initSpinner()
//            addnaf()
//            showDialog()
            binding.floating.setOnClickListener {
                Toast.makeText(this , "Click Me ",Toast.LENGTH_LONG).show()
            }
            WindowInsetsCompat.CONSUMED // Add this line to indicate that you've consumed the insets
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.icon11 ->{
                Toast.makeText(this@MainActivity,"Icon 1",Toast.LENGTH_LONG).show()
            }
            R.id.icon22 ->{
                Toast.makeText(this@MainActivity,"Icon 2",Toast.LENGTH_LONG).show()
            }
            R.id.icon33 ->{
                Toast.makeText(this@MainActivity,"Icon 3",Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun showDialog(){
        val builder = AlertDialog.Builder(this)
        builder.apply {
            setTitle("Dialog")
            setMessage("Massage")
            setPositiveButton("Yes",DialogInterface.OnClickListener{dialog, i ->
                Toast.makeText(this@MainActivity, "Positive", Toast.LENGTH_LONG).show()
            })
            setNegativeButton("No",DialogInterface.OnClickListener { dialog, i ->
                Toast.makeText(this@MainActivity,"nagtive",Toast.LENGTH_LONG).show()
            })
        }
        val dialog  = builder.create()
        dialog.show()
    }

//    private fun replace(fr : Fragment){
//        val transition = supportFragmentManager.beginTransaction()
//        transition.replace(androidx.fragment.R.id.fragment_container_view_tag ,fr)
//        transition.commit()
//    }
//    private fun addnaf(){
//        binding.navigationBarItemLabelsGroup.setOnItemSelectedListener{item ->
//            when(item.itemId){
//                R.id.icon1 ->{
//                    replace(myfragmentone)
//                    true
//                }
//                R.id.icon2 ->{
//                    replace(myfragmenttwo)
//                    true
//                }
//
//                else -> {
//                    false
//                }
//            }
//        }
//    }

//private fun initSpinner(){
//    var item = listOf("A","B","C","D")
//    val mayAdapter = ArrayAdapter(this@MainActivity,R.layout.spinner_layout,item)
//
//    binding.spinner.apply {
//        adapter = mayAdapter
//        onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                Toast.makeText(this@MainActivity , item[position] ,Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//            }
//
//        }
//    }
}





