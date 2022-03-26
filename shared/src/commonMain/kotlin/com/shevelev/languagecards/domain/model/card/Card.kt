package com.shevelev.languagecards.domain.model.card

data class Card(
    val id: Long,
    val color: Color?,
    val side: Map<Language, CardSide>
)