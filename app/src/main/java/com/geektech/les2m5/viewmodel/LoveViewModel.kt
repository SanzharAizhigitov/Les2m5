package com.geektech.les2m5.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.les2m5.remote.LoveModel
import com.geektech.les2m5.repository.Repository

class LoveViewModel : ViewModel() {
    private val repository = Repository()
    fun getLiveLove(firstName:String, secondName:String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }
}