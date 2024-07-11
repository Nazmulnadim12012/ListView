package com.example.listview

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
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

        var listView = findViewById<ListView>(R.id.list_item)
        val userList = arrayOf("Nadim","Sumon","Mukta","Sumiya","Maishasra","Nushaiba"," Nurul Islam","Nazma")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,userList)
        listView.adapter = arrayAdapter


        listView.setOnItemClickListener { parent, view, position, id ->

            val selectedItem = parent.getItemAtPosition(position) as String

           // Toast.makeText(this,selectedItem,Toast.LENGTH_LONG).show()

            val intent = Intent(this@MainActivity,Activity2::class.java).apply {

                putExtra("selectedItem",selectedItem)

            }

            startActivity(intent)


        }


    }
}