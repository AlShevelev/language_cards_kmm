package com.shevelev.languagecards.data.repository.cards

import com.shevelev.languagecards.domain.model.card.Card

interface CardsRepository {
    /**
     * Returns all cards in random order
     */
    suspend fun getAllCards(): List<Card>

    /**
     * Saves a card in the storage
     */
    suspend fun createCard(card: Card)
}