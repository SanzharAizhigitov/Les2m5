package com.geektech.les2m5

import android.app.Application
import androidx.room.Room
import com.geektech.les2m5.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object{
      lateinit  var appDatabase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "love_table")
            .allowMainThreadQueries().build()
    }
}