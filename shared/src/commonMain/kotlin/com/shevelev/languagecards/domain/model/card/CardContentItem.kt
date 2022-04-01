package com.shevelev.languagecards.domain.model.card

data class CardContentItem(
    val value: String,
    val valueVoicing: String? = null,
    val description: String? = null
)