package com.hyperboat.util.generator.data.qu.whole


import com.google.gson.annotations.SerializedName

/**
 * Problem 详细问题实体, 大部份属性都有了, 最主要的是有markdown
 *
 * @property acRate
 * @property content
 * @property difficulty
 * @property extra
 * @property freqBar
 * @property frontendQuestionId
 * @property isFavor
 * @property paidOnly
 * @property solutionNum
 * @property status
 * @property title
 * @property titleCn
 * @property titleSlug
 * @property topicTags
 * @property typename
 * @constructor Create empty Problem
 */
data class Problem(
    @SerializedName("acRate")
    val acRate: Double,
    @SerializedName("content")
    var content: Content,
    @SerializedName("difficulty")
    val difficulty: String,
    @SerializedName("extra")
    val extra: Extra,
    @SerializedName("freqBar")
    val freqBar: Int,
    @SerializedName("frontendQuestionId")
    val frontendQuestionId: String,
    @SerializedName("isFavor")
    val isFavor: Boolean,
    @SerializedName("paidOnly")
    val paidOnly: Boolean,
    @SerializedName("solutionNum")
    val solutionNum: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("titleCn")
    val titleCn: String,
    @SerializedName("titleSlug")
    val titleSlug: String,
    @SerializedName("topicTags")
    val topicTags: List<TopicTag>,
    @SerializedName("__typename")
    val typename: String
)