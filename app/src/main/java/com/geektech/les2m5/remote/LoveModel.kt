package com.geektech.les2m5.remote

import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("fname")
    var firstName:String,
    @SerializedName("sname")
    var secondName:String,
    var percentage:String,
    var result:String
): java.io.Serializable
