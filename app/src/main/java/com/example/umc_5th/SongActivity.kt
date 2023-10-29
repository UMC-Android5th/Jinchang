package com.example.umc_5th

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.umc_5th.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongBinding
    lateinit var timer: Timer
    lateinit var song: Song
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        val intent = intent
        binding.songMusicTitleTv.text = intent.getStringExtra("songName")
        binding.songSingerNameTv.text = intent.getStringExtra("singerName")
        setContentView(binding.root)
        songSetting()
        songInfoSetting(song)
        setButton()
    }
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun setButton(){
        binding.songDownIb.setOnClickListener {
            finish()
        }
        binding.songMiniplayerIv.setOnClickListener {
            playerStatusSetting(true)
        }
        binding.songPauseIv.setOnClickListener {
            playerStatusSetting(false)
        }
    }
    private fun songInfoSetting(song: Song){
        binding.songMusicTitleTv.text = intent.getStringExtra("songName")!!
        binding.songSingerNameTv.text = intent.getStringExtra("singer")!!
        binding.songStartTimeTv.text = String.format("%02d:%02d",song.second / 60, song.second % 60)
        binding.songEndTimeTv.text = String.format("%02d:%02d",song.playTime / 60, song.playTime % 60)
        binding.songProgressSb.progress = (song.second * 1000 / song.playTime)
        playerStatusSetting(song.isPlaying)
    }
    private fun playerStatusSetting (isPlaying : Boolean){
        song.isPlaying = isPlaying
        timer.isPlaying = isPlaying

        if(isPlaying){
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        } else {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }

    }
    private fun songSetting(){
        song = Song(
            intent.getStringExtra("songName")!!,
            intent.getStringExtra("singer")!!,
            intent.getIntExtra("second",0),
            intent.getIntExtra("playTime",0),
            intent.getBooleanExtra("isPlaying",false)
        )
        startSong()
    }
    private fun startSong(){
        timer = Timer(song.playTime,song.isPlaying)
        timer.start()
    }
    inner class Timer(private val playTime: Int,var isPlaying: Boolean = true):Thread(){
        private var second : Int = 0
        private var mills: Float = 0f
        override fun run() {
            super.run()
            try {
                while (true){
                    if (second >= playTime){
                        break
                    }
                    if (isPlaying){
                        sleep(10)
                        mills += 10
                        runOnUiThread {
                            binding.songProgressSb.progress = ((mills / playTime)*100).toInt()
                        }
                        if (mills % 1000 == 0f){
                            runOnUiThread {
                                binding.songStartTimeTv.text = String.format("%02d:%02d",second / 60, second % 60)
                            }
                            second++
                        }
                    }
                }
            }catch (e: InterruptedException){
                Log.d("Song","Thread is gone: ${e.message}")
            }
        }
    }
}