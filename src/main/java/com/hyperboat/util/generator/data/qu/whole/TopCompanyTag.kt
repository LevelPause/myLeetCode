package com.hyperboat.util.generator.data.qu.whole


import com.google.gson.annotations.SerializedName

data class TopCompanyTag(
    @SerializedName("imgUrl")
    val imgUrl: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("__typename")
    val typename: String
)