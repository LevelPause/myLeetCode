package com.hyperboat.util.generator.data.md

import com.google.gson.annotations.SerializedName

@Deprecated("同com.hyperboat.util.Generator.generate一起废掉")
data class Metadata(
    @SerializedName("daily")
    val daily: Daily
)