package com.geektech.les2m5.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.les2m5.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

   abstract fun loveDao():LoveDao


}