package com.shevelev.languagecards.domain.interactors.updatecardsstorage

/**
 * This in an interactor for create/update card's database
 */
interface UpdateCardsStorageInteractor {
    suspend fun updateCards()
}