package com.example.tu_mqttapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Mqttactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val topic = intent.getStringExtra("topic")
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
        dataSet.add(("Topic:$topic"))
        var i = 0
        while (i < 20) {
            val str: String = java.lang.String.format(Locale.US, "Data_0%d", i)
            dataSet.add(str)
            i++
        }


        val mqttadapter = MyAdapter(dataSet)
        recyclerView.adapter = mqttadapter

        findViewById<Button>(R.id.button).setOnClickListener {
            val hoge = "hoge"
            dataSet.add(hoge)
            mqttadapter.notifyItemInserted(dataSet.lastIndex)
        }

    }
}