package com.example.tu_mqttapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class Mqttactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mqtt)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
        // use a linear layout manager
        val rLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this)
        recyclerView.layoutManager = rLayoutManager
        val dataSet: ArrayList<String> = arrayListOf()
        val inputadapter = MyAdapter(dataSet)
        recyclerView.adapter = inputadapter

        findViewById<Button>(R.id.button).setOnClickListener{
            val textbox = findViewById<EditText>(R.id.edit_text)
            val inputtext = textbox.text.toString()
            //for when need to jump to new activity
            //val intent = Intent(applicationContext,MainActivity::class.java)
            //startActivity(intent)
            dataSet.add(inputtext)
            inputadapter.notifyItemInserted(dataSet.lastIndex)
        }

    }
}