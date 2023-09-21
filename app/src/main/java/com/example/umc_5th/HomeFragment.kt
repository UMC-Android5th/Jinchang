package com.example.umc_5th

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_5th.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setTodayMusic()
        setPotCast()
        setVideo()
        // Inflate the layout for this fragment
        return binding.root
    }
    private fun setTodayMusic(){
        var musicList: Array<Pair<String,String>> = arrayOf(Pair("LILAC","아이유(IU)"),Pair("제목","가수"),Pair("제목","가수"))
        var musicListAdapter = MusicListAdapter(musicList)
        binding.homePannelMusicListRv.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = musicListAdapter
        }
        musicListAdapter.notifyDataSetChanged()
    }
    private fun setPotCast(){
        var potCastList: Array<Pair<String,String>> = arrayOf(Pair("제목","가수"),Pair("제목","가수"),Pair("제목","가수"))
        var potCastListAdapter = PotCastListAdapter(potCastList)
        binding.homePannelPotcastListRv.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = potCastListAdapter
        }
        potCastListAdapter.notifyDataSetChanged()
    }
    private fun setVideo(){
        var videoList: Array<Pair<String,String>> = arrayOf(Pair("제목","가수"),Pair("제목","가수"),Pair("제목","가수"))
        var videoListAdapter = VideoListAdapter(videoList)
        binding.homePannelVideoListRv.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = videoListAdapter
        }
        videoListAdapter.notifyDataSetChanged()
    }
}