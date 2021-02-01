package br.com.desafioandroidclaudiomonteoliva.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso

import br.com.desafioandroidclaudiomonteoliva.model.contracts.character.Result
import br.com.desafioandroidclaudiomonteoliva.R
import br.com.desafioandroidclaudiomonteoliva.view.main.MainActivity
import com.bumptech.glide.Glide

class ItemAdapter(private val activity: MainActivity) : RecyclerView.Adapter<ItemAdapter.ViewHolder>()  {

    private var list: MutableList<Result> = emptyList<Result>().toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(this, view)
    }

    fun updateList(items: MutableList<Result>) {
        list = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun getItemId(position: Int): Long = list[position].id.toLong()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Result = getItem(position)

        val imageUrl = "${item.thumbnail.path}.${item.thumbnail.extension}"

        holder.apply {
            itemName.text = item.name

            Glide.with(activity.baseContext)
                .load(imageUrl)
                .into(itemImage)

//            Picasso.get().load(imageUrl).into(itemImage)
        }
    }

    fun getItem(position: Int): Result = list[position]

    fun detail(item: Result) { activity.detail(item) }

    class ViewHolder(itemAdapter: ItemAdapter, itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemName: TextView     = itemView.findViewById(R.id.itemName)
        val itemImage: ImageView   = itemView.findViewById(R.id.itemImage)
        val itemCard: LinearLayout = itemView.findViewById(R.id.itemCard)

        init {
            itemCard.setOnClickListener {
                val item: Result = itemAdapter.getItem(adapterPosition)
                itemAdapter.detail(item)
            }
        }
    }
}