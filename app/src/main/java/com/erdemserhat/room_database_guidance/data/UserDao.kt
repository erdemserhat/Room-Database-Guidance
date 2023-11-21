package com.erdemserhat.room_database_guidance.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    //Contains the methods used for accessing the database.
    @Insert(onConflict = OnConflictStrategy.IGNORE) //-> Ignore if there are conflicted (same) values users in the database
    suspend fun addUser(user:User)

    @Query("SELECT * FROM user_table ORDER BY id ASC") //-> Order by id ascending order
    fun readAllData():LiveData<List<User>>








}