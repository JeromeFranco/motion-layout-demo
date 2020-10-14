package com.example.musicplaylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter(private val items: List<String>) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context).run {
            inflate(android.R.layout.simple_list_item_2, parent, false).let {
                ViewHolder(it)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text = items[position]
        holder.text2 = items[position]
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(android.R.id.text1)
        private val textView2: TextView = view.findViewById(android.R.id.text2)

        var text: CharSequence
            get() = textView.text
            set(value) {
                textView.text = value
            }

        var text2: CharSequence
            get() = textView2.text
            set(value) {
                textView2.text = value
            }
    }

}