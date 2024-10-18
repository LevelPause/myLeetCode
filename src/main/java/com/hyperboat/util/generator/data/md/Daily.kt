package com.hyperboat.util.generator.data.md


import com.google.gson.annotations.SerializedName
@Deprecated("同com.hyperboat.util.Generator.generate一起废掉")
data class Daily(
    @SerializedName("august")
    val august: August,
    @SerializedName("july")
    val july: July,
    @SerializedName("october")
    val october: October,
    @SerializedName("september")
    val september: September
)