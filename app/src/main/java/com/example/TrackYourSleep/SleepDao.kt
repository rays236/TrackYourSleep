package com.example.TrackYourSleep

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Accesses the database of Sleep objects.
 */
@Dao
interface SleepDao {
    @Query("SELECT * FROM sleep ORDER BY sid ASC")
    suspend fun getAll(): List<Sleep>

    @Query("SELECT * FROM sleep ORDER BY start_date DESC")
    fun getAllLive(): LiveData<List<Sleep>>

    @Query("SELECT * from sleep where sid = :id LIMIT 1")
    suspend fun getById(id: Int): Sleep

    @Query("SELECT * FROM sleep WHERE stop_date > :after ORDER BY start_date DESC")
    fun getAfterLive(after: Long): LiveData<List<Sleep>>

    @Insert
    suspend fun insert(sleepList: List<Sleep>)

    @Insert
    suspend fun insert(sleep: Sleep)

    @Update
    suspend fun update(sleep: Sleep)

    @Delete
    suspend fun delete(sleep: Sleep)

    @Query("delete from sleep")
    suspend fun deleteAll()
}

/* vim:set shiftwidth=4 softtabstop=4 expandtab: */
