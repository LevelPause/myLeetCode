package com.hyperboat.util.generator.data.qu.whole


import com.google.gson.annotations.SerializedName

data class TopicTag(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nameTranslated")
    val nameTranslated: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("__typename")
    val typename: String
)