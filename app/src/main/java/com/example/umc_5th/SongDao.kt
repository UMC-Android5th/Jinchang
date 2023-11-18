package com.example.umc_5th

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SongDao {
    @Insert
    fun insert(song:Song)
    @Update
    fun update(song:Song)
    @Delete
    fun delete(song:Song)
    @Query("select * from songTable")
    fun getSongs():List<Song>
    @Query("select * from songTable where id = :id")
    fun getSong(id:Int): Song
    @Query("UPDATE SongTable SET isLike= :isLike WHERE id = :id")
    fun updateIsLikeById(isLike: Boolean,id: Int)
    @Query("SELECT * FROM SongTable WHERE isLike= :isLike")
    fun getLikedSongs(isLike: Boolean): List<Song>
}