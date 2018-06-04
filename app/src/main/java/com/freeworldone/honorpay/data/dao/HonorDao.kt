package com.freeworldone.honorpay.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.freeworldone.honorpay.data.models.Honor
import org.intellij.lang.annotations.Language

@Dao
interface HonorDao {
    @Language("RoomSql")
    @Query("SELECT * FROM honor WHERE id = :id LIMIT 1")
    fun get(id: Int): LiveData<Honor>

    @Language("RoomSql")
    @Query("SELECT * FROM honor")
    fun getAll(): LiveData<List<Honor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(honor: Honor)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(honor: List<Honor>)

    @Language("RoomSql")
    @Query("DELETE FROM honor WHERE id = :id")
    fun delete(id: Int)

    @Language("RoomSql")
    @Query("DELETE FROM honor")
    fun deleteAll()
}