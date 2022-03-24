package com.shevelev.languagecards.data.repository.keyvaluestorage

import com.shevelev.languagecards.data.api.keyvaluestorage.KeyValueStorageQueries

/**
 * An implementation for updating data in a key-value storage bases on SQLDelight
 */
class KeyValueStorageWriterImpl(
    dbQueries: KeyValueStorageQueries,
    storageKey: String,
    private val reader: KeyValueStorageReader
) : KeyValueStorageWriter {

    private val writer = KeyValueStorageWriteOperationsImpl(dbQueries, storageKey)

    /**
     * Executes writing operations inside [updateAction] block with reading data opportunity
     */
    override fun updateWithRead(
        updateAction: (KeyValueStorageReader, KeyValueStorageWriteOperations) -> Unit
    ) =
        updateAction(reader, writer)

    /**
     * Executes writing operations inside [updateAction] block
     */
    override fun update(updateAction: (KeyValueStorageWriteOperations) -> Unit) =
        updateAction(writer)
}