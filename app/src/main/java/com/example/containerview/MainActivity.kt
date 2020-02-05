package com.example.containerview


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_person_details.*

class MainActivity : AppCompatActivity() {

    // Will initialize whenever the value is called
    val personList by lazy {
        populateList()
    }
    val adapter by lazy {

        PersonAdapter(personList)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }


    private fun initRecyclerView() {

        val adapter = PersonAdapter(personList)
        val layoutManager = LinearLayoutManager(this)
        val gridLayoutManager = GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvPersonList.layoutManager = layoutManager
        rvPersonList.addItemDecoration(itemDecoration)
        rvPersonList.adapter = adapter
    }


    private fun populateList(): ArrayList<Person> {

        val returnList = ArrayList<Person>()
        returnList.add(Person("Nathan", "Parizi", "232 Address"))
        returnList.add(Person("Paul", "Wilmott", "23 Address"))
        returnList.add(Person("Emanual", "Derman", "232 Quant Ct."))
        returnList.add(Person("Toby", "Kieth", "232 Gunther Avenue"))
        returnList.add(Person("Roy", "Boy", "232 SmashBros court"))
        returnList.add(Person("Seth", "McFarlane", "232 Hollywood"))
        returnList.add(Person("Billy", "Holiday", "232 Saywhat St"))
        returnList.add(Person("Charlie", "Sheen", "69 DoubleQueen St"))
        returnList.add(Person("Parker", "Green", "232 OneCallThatsAll Blvd"))
        returnList.add(Person("Richie", "Rich", "232 PoorAf St"))
        returnList.add(Person("Scoot", "Bahoot", "232 Primetime Ct."))
        returnList.add(Person("Slowpoke", "Rodriguez", "1 HePackAGun Rd"))

        return returnList
    }

    fun onClick(view: View) {

        val first = etFirstName.text.toString()
        val last = etLastName.text.toString()
        val address = etAddress.text.toString()
        val persontoAdd = Person(first, last, address)
        adapter.addPersonToList(persontoAdd)


    }



}
