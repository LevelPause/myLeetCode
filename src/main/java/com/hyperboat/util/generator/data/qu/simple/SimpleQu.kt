package com.hyperboat.util.generator.data.qu.simple


import com.google.gson.annotations.SerializedName

/**
 * Simple qu 简单问题实体, 存储显示一些基本信息
 *
 * @property difficulty
 * @property frequency
 * @property isFavor
 * @property paidOnly
 * @property progress
 * @property stat
 * @property status
 * @constructor Create empty Simple qu
 */
data class SimpleQu(
    @SerializedName("difficulty")
    val difficulty: Difficulty,
    @SerializedName("frequency")
    val frequency: Int,
    @SerializedName("is_favor")
    val isFavor: Boolean,
    @SerializedName("paid_only")
    val paidOnly: Boolean,
    @SerializedName("progress")
    val progress: Int,
    @SerializedName("stat")
    val stat: Stat,
    @SerializedName("status")
    val status: String
)