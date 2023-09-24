package com.example.umc_5th

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.umc_5th.databinding.ActivityMainBinding
import com.example.umc_5th.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        val intent = intent
        binding.songMusicTitleTv.text = intent.getStringExtra("songName")
        binding.songSingerNameTv.text = intent.getStringExtra("singerName")
        setContentView(binding.root)
        binding.songDownIb.setOnClickListener { goMainActivity() }
        binding.songMiniplayerIv.setOnClickListener { setPlayerStatus(false) }
        binding.songPauseIv.setOnClickListener { setPlayerStatus(true) }
    }
    private fun setPlayerStatus(isPlaying: Boolean){
        if(isPlaying){
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }else{
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }
    private fun goMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}