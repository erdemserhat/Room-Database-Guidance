package com.erdemserhat.room_database_guidance.data

import androidx.lifecycle.LiveData

class UserRepository ( private val userDao: UserDao) {
    /**
     * A repository class abstracts access to multiple data sources.
     * The repository is not part of the Architecture Components libraries,
     * but is a suggested best practice for code separation and architecture.
     *
     */

    val readAllData:LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user:User){
        userDao.addUser(user)
    }
}