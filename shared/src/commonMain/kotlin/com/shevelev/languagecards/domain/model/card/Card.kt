package com.shevelev.languagecards.domain.model.card

data class Card(
    val id: Long,
    val color: Color? = null,
    val side: Map<Language, CardSide>
)