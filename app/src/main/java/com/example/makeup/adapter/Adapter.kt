package com.example.makeup.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.makeup.R
import com.example.makeup.model.MakeupItem
import com.example.makeup.util.OnItemClick

class Adapter(
    private val makeupitem: List<MakeupItem>,
    private val context: Context,
    private val onItemClick: OnItemClick
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageview: ImageView = itemView.findViewById<ImageView>(R.id.Image)
        val title: TextView = itemView.findViewById(R.id.Title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cosmetic, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curItem = makeupitem[position]


        holder.apply {
            Glide.with(context)
                .load(curItem.image_link)
                .into(imageview)
            title.text = curItem.name
        }

        holder.imageview.setOnClickListener {
            onItemClick.onClick(position)
        }

    }

    //This function returns the size
    override fun getItemCount(): Int {
        return makeupitem.size
    }


}