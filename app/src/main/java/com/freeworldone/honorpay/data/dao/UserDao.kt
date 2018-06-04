package com.freeworldone.honorpay.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.freeworldone.honorpay.data.models.User
import org.intellij.lang.annotations.Language

@Dao
interface UserDao {
    @Language("RoomSql")
    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    fun get(id: Int): LiveData<User>

    @Language("RoomSql")
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Language("RoomSql")
    @Query("DELETE FROM user WHERE id = :id")
    fun delete(id: Int)

    @Language("RoomSql")
    @Query("DELETE FROM user")
    fun deleteAll()
}