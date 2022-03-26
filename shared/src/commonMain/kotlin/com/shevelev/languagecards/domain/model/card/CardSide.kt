package com.shevelev.languagecards.domain.model.card

data class CardSide(
    val clarification: CardContentItem?,
    val mainItems: List<CardContentItem>,
    val examples: List<CardContentItem>
)