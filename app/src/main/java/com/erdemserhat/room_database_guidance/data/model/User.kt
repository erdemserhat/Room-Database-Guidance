package com.erdemserhat.room_database_guidance.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.ParcelField
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Entity(tableName = "user_table") //--> specify the table's name
data class User(
    @PrimaryKey(autoGenerate = true) //-> auto increments the id
    val id:Int, //-> columns for table
    var firstName:String,
    var lastName:String,
    var age:Int

):Serializable
