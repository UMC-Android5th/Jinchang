package com.example.umc_5th

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.umc_5th.databinding.FragmentHomeBinding
import com.example.umc_5th.databinding.MusicListItemBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        mainActivity = context as MainActivity
        setBannerVP()
        setTodayMusic()
        setPotCast()
        setVideo()
        return binding.root
    }
    private fun setBannerVP(){
        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homePannelViewpagerExp.adapter = bannerAdapter
        binding.homePannelViewpagerExp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
    private fun setTodayMusic(){
        var musicList: ArrayList<Pair<String,String>> = arrayListOf(Pair("LILAC","아이유(IU)"),Pair("제목","가수"),Pair("제목","가수"))
        var musicListAdapter = MusicListAdapter(musicList)
        binding.homePannelMusicListRv.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = musicListAdapter
        }
        musicListAdapter.notifyDataSetChanged()
        binding.homePannelMusicListRv.adapter = musicListAdapter

        musicListAdapter.setMyItemClickListener(object : MusicListAdapter.MyItemClickListener{

            override fun onItemClick(album: Pair<String,String>) {
                changeAlbumFragment(album)
            }

            override fun onRemoveAlbum(position: Int) {

            }
        })
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
    private fun changeAlbumFragment(album: Pair<String, String>) {
        mainActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, AlbumFragment())
            .commitAllowingStateLoss()
    }
}