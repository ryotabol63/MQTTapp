package com.example.tu_mqttapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

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
        var i = 0
        while (i < 20) {
            val str: String = java.lang.String.format(Locale.US, "Data_0%d", i)
            dataSet.add(str)
            i++
        }



        recyclerView.adapter = MyAdapter(dataSet)

        findViewById<Button>(R.id.button).setOnClickListener{
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }

    }
}