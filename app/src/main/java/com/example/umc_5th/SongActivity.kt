package com.example.umc_5th

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        binding.songDownIb.setOnClickListener(ButtonListener())
    }
    inner class ButtonListener: View.OnClickListener{
        override fun onClick(v: View?) {
            when(v?.id){
                R.id.song_down_ib -> goMainActivity()
            }
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