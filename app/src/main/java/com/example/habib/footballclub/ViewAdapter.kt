package com.example.habib.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.ScrollingTabContainerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*

class ViewAdapter(private val context: Context,private val items : List<Items>,private val listener: (Items)->Unit):RecyclerView.Adapter<ViewAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(items[position],listener)
    }
    override fun getItemCount(): Int = items.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false))

    class ViewHolder(val containerView: View):RecyclerView.ViewHolder(containerView),LayoutContainer {
        fun bindItems(item: Items,listener: (Items) -> Unit){
            itemView.name.text = item.name
            Glide.with(itemView.context).load(item.image).into(itemView.image)
            containerView.onClick { listener(item) }
        }
    }
}
interface LayoutContainer {

}
