package com.erdemserhat.room_database_guidance.data.repository

import androidx.lifecycle.LiveData
import com.erdemserhat.room_database_guidance.data.model.User
import com.erdemserhat.room_database_guidance.data.UserDao

class UserRepository ( private val userDao: UserDao) {
    /**
     * A repository class abstracts access to multiple data sources.
     * The repository is not part of the Architecture Components libraries,
     * but is a suggested best practice for code separation and architecture.
     *
     */

    val readAllData:LiveData<List<User>> = userDao.readAllData()

     suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
}