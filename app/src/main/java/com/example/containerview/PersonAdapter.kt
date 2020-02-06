package com.example.containerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.person_item.view.*

class PersonAdapter(private val personList: ArrayList<Person>) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateItem(person: Person) {
            itemView.tvFirstName.text = person.firstName
            itemView.tvLastName.text = person.lastName
            itemView.tvAddress.text = person.address

            itemView.setOnClickListener(View.OnClickListener {
                val intent = Intent(it.context, PersonDetails::class.java)
                intent.putExtra(KEY_PERSON, person)
                it.context.startActivity(intent)
            })

        }
    }

    fun addPersonToList(person: Person){
        personList.add(person)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //Inflating this recourse into memory

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_item, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder

    }

    override fun getItemCount() = personList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.populateItem(personList[position])
    }

    

}