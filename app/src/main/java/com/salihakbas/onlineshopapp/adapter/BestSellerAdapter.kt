package com.salihakbas.onlineshopapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.salihakbas.onlineshopapp.databinding.ViewholderBestSellerBinding
import com.salihakbas.onlineshopapp.model.ItemsModel

class BestSellerAdapter(val items: MutableList<ItemsModel>):  RecyclerView.Adapter<BestSellerAdapter.ViewHolder>() {
    private var context: Context?=null
    class ViewHolder(val binding: ViewholderBestSellerBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestSellerAdapter.ViewHolder {
        context = parent.context
        val binding = ViewholderBestSellerBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestSellerAdapter.ViewHolder, position: Int) {
        holder.binding.titleTxt.text = items[position].title
        holder.binding.priceTxt.text = "$"+items[position].price.toString()
        holder.binding.ratingTxt.text = items[position].rating.toString()

        val requestOption = RequestOptions().transform(CenterCrop())
        Glide.with(holder.itemView.context)
            .load(items[position].picUrl[0])
            .apply(requestOption)
            .into(holder.binding.picBestSeller)
    }

    override fun getItemCount(): Int = items.size
}