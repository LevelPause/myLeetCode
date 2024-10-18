package com.hyperboat.util.generator.data.qu.whole


import com.google.gson.annotations.SerializedName

data class Extra(
    @SerializedName("companyTagNum")
    val companyTagNum: Int,
    @SerializedName("hasVideoSolution")
    val hasVideoSolution: Boolean,
    @SerializedName("topCompanyTags")
    val topCompanyTags: List<TopCompanyTag>,
    @SerializedName("__typename")
    val typename: String
)