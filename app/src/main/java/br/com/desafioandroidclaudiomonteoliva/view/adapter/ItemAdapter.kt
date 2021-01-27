package br.com.desafioandroidclaudiomonteoliva.view.adapter

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

class ItemAdapter(private val activity: MainActivity,
                  private val list: MutableList<Result>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(this, view)
    }

    override fun getItemCount(): Int = list.size

    override fun getItemId(position: Int): Long = list[position].id.toLong()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Result = getItem(position)

        val imageUrl = "${item.thumbnail?.path}.${item.thumbnail?.extension}"

        holder.apply {
            itemName.text = item.name

            Picasso.get().load(imageUrl).into(itemImage)
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