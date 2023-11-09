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


class MusicListAdapter(private val albumList: ArrayList<Album>/*val list: ArrayList<Pair<String,String>>*/): RecyclerView.Adapter<MusicListAdapter.MusicListViewHolder>() {
    interface MyItemClickListener{
        fun onItemClick(album: Album)
        fun onRemoveAlbum(position: Int)
    }
    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }
    fun addItem(album: Album){
        albumList.add(album)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        albumList.removeAt(position)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return albumList.count()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicListViewHolder {
        var binding: MusicListItemBinding = MusicListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicListViewHolder, position: Int) {
        holder.binding(albumList[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(albumList[position]) }
    }
    inner class MusicListViewHolder(val binding: MusicListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(list: Album){
            binding.itemAlbumTitleTv.text = list.title
            binding.musicSingerNameTv.text = list.singer
            binding.musicImage.setImageResource(list.coverImg!!)
        }
    }
}