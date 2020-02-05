package com.example.containerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_person_details.*
import kotlinx.android.synthetic.main.person_item.*

class PersonDetails : AppCompatActivity() {


    val list by lazy { initList() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_details)

        //Type safety, will not call the function if the variable is null  (( intent? ))


        val passedPerson = intent?.getParcelableExtra<Person>(KEY_PERSON)
        first_name.text = passedPerson?.firstName ?: "No First Name"  // Elvis operator
        // ternary operator

        // passedPerson.getFirstName != null ? passedPerson.getFirstName() : "no first name"

        first_name.text = passedPerson?.firstName ?: "No first name"
        last_name.text = passedPerson?.lastName ?: "No last name"
        txtaddress.text = passedPerson?.address ?: "No address name"

        initListView()

    }

    fun initListView() {
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list)
//        lvListView.adapter = adapter
//        lvListView.setOnItemClickListener{AdapterView.OnItemClickListener {adapterView, view, i, 1,  ->
//            val ss = list[i]
//            val intent = Intent("MAKE>THE>INTENT")
//            intent.putExtra("KEY" ,ss)
//            startActivity(intent)
//        })
    }

    //*** ListView

    fun initList(): ArrayList<String> {
        val stringList = ArrayList<String>()

        stringList.add("Value1")
        stringList.add("Value2")
        stringList.add("Value3")
        stringList.add("Value4")
        stringList.add("Value5")
        stringList.add("Value6")

        return stringList

    }
}
