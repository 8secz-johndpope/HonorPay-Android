package com.freeworldone.honorpay.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.freeworldone.honorpay.data.models.Honor

@Dao
interface HonorDao {
    @Query("SELECT * FROM honor WHERE id = :id LIMIT 1")
    fun get(id: Int): LiveData<Honor>

    @Query("SELECT * FROM honor")
    fun getAll(): LiveData<List<Honor>>

    @Query("SELECT user_from,user_to,message,timestamp,uFrom.first_name as from_first_name,uFrom.last_name as from_last_name,uFrom.nickname as from_nickname,uFrom.type as from_type,uFrom.honors_received as from_honors_received,uTo.first_name as to_first_name,uTo.last_name as to_last_name,uTo.nickname as to_nickname,uTo.type as to_type,uTo.honors_received as to_honors_received FROM honor LEFT JOIN user uFrom ON user_from = uFrom.id LEFT JOIN user uTo ON user_to = uTo.id ORDER BY timestamp DESC LIMIT 15")
    fun getAllRecent(): LiveData<List<HonorDetail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(honor: Honor)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(honor: List<Honor>)

    @Query("DELETE FROM honor WHERE id = :id")
    fun delete(id: Int)

    @Query("DELETE FROM honor")
    fun deleteAll()
}