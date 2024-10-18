package com.hyperboat.util.generator.data.qu.whole


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("cn")
    val cn: String,
    @SerializedName("en")
    val en: String
)