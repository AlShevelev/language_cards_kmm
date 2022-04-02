package com.shevelev.languagecards.domain.interactors.updatecardsstorage.batches

/**
 * This is an interface for one batch of creating/updating maps
 */
interface SyncCardsBatch {
    val version: Int

    suspend fun update()
}