package com.example.umc_5th

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_5th.databinding.MusicListItemBinding


class MusicListAdapter(val list: ArrayList<Pair<String,String>>): RecyclerView.Adapter<MusicListAdapter.MusicListViewHolder>() {
    interface MyItemClickListener{
        fun onItemClick(album: Pair<String,String>)
        fun onRemoveAlbum(position: Int)
    }
    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }
    override fun getItemCount(): Int {
        return list.count()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicListViewHolder {
        var binding: MusicListItemBinding = MusicListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicListViewHolder, position: Int) {
        holder.binding(list[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(list[position]) }
    }
    inner class MusicListViewHolder(val binding: MusicListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(list: Pair<String, String>){
            binding.musicName.text = list.first
            binding.musicSingerName.text = list.second
        }
    }
}