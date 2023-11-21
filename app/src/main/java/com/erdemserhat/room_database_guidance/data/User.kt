package com.erdemserhat.room_database_guidance.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table") //--> specify the table's name
data class User(
    @PrimaryKey(autoGenerate = true) //-> auto increments the id
    val id:Int, //-> columns for table
    val firstName:String,
    val lastName:String,
    val age:Int

)
