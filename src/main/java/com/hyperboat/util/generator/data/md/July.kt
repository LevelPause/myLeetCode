package com.hyperboat.util.generator.data.md


import com.google.gson.annotations.SerializedName
@Deprecated("同com.hyperboat.util.Generator.generate一起废掉")
data class July(
    @SerializedName("nums")
    private val nums: List<String>,
    @SerializedName("path")
    private val path: List<String>
) : MD {
    override fun getPath(): List<String> {
        return path
    }

    override fun getNums(): List<String> {
        return nums
    }
}