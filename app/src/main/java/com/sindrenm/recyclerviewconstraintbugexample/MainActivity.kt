package com.sindrenm.recyclerviewconstraintbugexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_view.view.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val sampleItems = List(3, init = { it })

    recyclerView.adapter = Adapter(sampleItems)
    recyclerView.layoutManager = LinearLayoutManager(this)
  }
}

class Adapter(private val items: List<Int>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
  override fun getItemCount(): Int = items.count()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val itemView = inflater.inflate(R.layout.item_view, parent, false)

    return ViewHolder(itemView)
  }

  override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
    viewHolder.bind(items[position])
  }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView = itemView.itemViewTextView

    fun bind(index: Int) {
      textView.text = itemView.context.getString(R.string.item_view_text, index)
    }
  }
}
