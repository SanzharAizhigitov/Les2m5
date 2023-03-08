package com.geektech.les2m5.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geektech.les2m5.remote.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_model")
    fun getAll():List<LoveModel>

    @Query("SELECT * FROM love_model ORDER BY firstName ASC")
    fun getAllForAlphabet():List<LoveModel>
}