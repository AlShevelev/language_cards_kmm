package com.shevelev.languagecards.domain.interactors.updatecardsstorage

import com.shevelev.languagecards.data.repository.cards.CardsRepository
import com.shevelev.languagecards.data.repository.keyvaluestorage.KeyValueStorage
import com.shevelev.languagecards.domain.interactors.updatecardsstorage.batches.SyncCardsBatch
import com.shevelev.languagecards.domain.interactors.updatecardsstorage.batches.SyncCardsVersion1Batch

private const val LAST_CARDS_BATCH_VERSION = "LAST_CARDS_BATCH_VERSION"

/**
 * This in an interactor for create/update card's database
 */
class UpdateCardsStorageInteractorImpl(
    val keyValueStorage: KeyValueStorage,
    private val repository: CardsRepository
) : UpdateCardsStorageInteractor {

    private val batches: List<SyncCardsBatch> by lazy {
        listOf(
            SyncCardsVersion1Batch(repository)
        )
    }

    override suspend fun updateCards() {
        val lastVersion = keyValueStorage.reader.getInt(LAST_CARDS_BATCH_VERSION) ?: 0

        val batchesToProcess = batches.filter { it.version > lastVersion }

        batchesToProcess.forEach { batch ->
            batch.update()

            keyValueStorage.writer.update {
                it.setInt(LAST_CARDS_BATCH_VERSION, batch.version)
            }
        }
    }
}