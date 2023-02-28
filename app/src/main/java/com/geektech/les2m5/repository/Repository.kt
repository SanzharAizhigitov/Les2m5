package com.geektech.les2m5.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.geektech.les2m5.remote.LoveModel
import com.geektech.les2m5.remote.LoveService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    fun getLove(firstName:String, secondName: String): MutableLiveData<LoveModel>{
        val  liveLoveData = MutableLiveData<LoveModel>()

        LoveService().api.calculatePercentage(firstName, secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
liveLoveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("xvr", "loh" )
            }
        })
        return liveLoveData
    }

}