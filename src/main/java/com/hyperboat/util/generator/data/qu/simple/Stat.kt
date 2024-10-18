package com.hyperboat.util.generator.data.qu.simple


import com.google.gson.annotations.SerializedName

data class Stat(
    @SerializedName("frontend_question_id")
    val frontendQuestionId: String,
    @SerializedName("is_new_question")
    val isNewQuestion: Boolean,
    @SerializedName("question__hide")
    val questionHide: Boolean,
    @SerializedName("question_id")
    val questionId: Int,
    @SerializedName("question__title")
    val questionTitle: String,
    @SerializedName("question__title_slug")
    val questionTitleSlug: String,
    @SerializedName("total_acs")
    val totalAcs: Int,
    @SerializedName("total_column_articles")
    val totalColumnArticles: Int,
    @SerializedName("total_submitted")
    val totalSubmitted: Int
)