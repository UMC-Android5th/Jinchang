package com.example.umc_5th

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_5th.databinding.MusicListItemBinding


class MusicListAdapter(val list: Array<Pair<String,String>>): RecyclerView.Adapter<MusicListAdapter.MusicListViewHolder>() {
    private lateinit var binding: MusicListItemBinding
    override fun getItemCount(): Int {
        return list.count()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicListViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.music_list_item, parent, false)
        return MusicListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicListViewHolder, position: Int) {
        holder.musicItemTile.text = list[position].first
        holder.musicItemSinger.text = list[position].second
    }
    inner class MusicListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var musicItemTile: TextView = view.findViewById(R.id.music_name)
        var musicItemSinger: TextView = view.findViewById(R.id.music_singer_name)
        init{
            view.setOnClickListener{
                (view.context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm,AlbumFragment()).commitAllowingStateLoss()
            }
        }
    }
}