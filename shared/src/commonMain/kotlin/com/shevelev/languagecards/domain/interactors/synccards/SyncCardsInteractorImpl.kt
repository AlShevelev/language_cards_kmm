package com.shevelev.languagecards.domain.interactors.synccards

import com.shevelev.languagecards.data.repository.keyvaluestorage.KeyValueStorage

/**
 * This in an interactor for create/update card's database
 */
class SyncCardsInteractorImpl(
    val keyValueStorage: KeyValueStorage
) : SyncCardsInteractor {

}

// Check version in KVS