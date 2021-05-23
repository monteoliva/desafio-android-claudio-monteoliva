package br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import br.com.monteoliva.desafioandroidclaudiomonteoliva.R
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.loadImageByGlide
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.ResultDetail
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.characters.Result

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
    private var list: MutableList<Result> = emptyList<Result>().toMutableList()

    var onClick: ((ResultDetail) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.characters_item, parent, false)
        return ViewHolder(view)
    }

    fun updateList(items: MutableList<Result>) {
        this.list.clear()
        this.list.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = getItem(position)

        viewHolder.apply {
            characterName.text = item.name
            itemView.apply {
                val imageUrl = "${item.thumbnail?.path}.${item.thumbnail?.extension}"
                characterImage.loadImageByGlide(context, imageUrl)
                setOnClickListener {
                    val result = ResultDetail().apply {
                        id          = item.id
                        description = item.description
                        name        = item.name
                        thumbnail   = item.thumbnail
                    }
                    onClick?.invoke(result)
                }
            }
        }
    }

    private fun getItem(position: Int): Result = list[position]

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.characterImage)
        val characterName: TextView   = itemView.findViewById(R.id.characterName)
    }
}