package com.shevelev.languagecards.data.repository.keyvaluestorage

/**
 * An implementation for updating data in a key-value storage bases on SQLDelight
 */
class KeyValueStorageWriterImpl(
    private val reader: KeyValueStorageReader,
    private val writerOperations: KeyValueStorageWriteOperations
) : KeyValueStorageWriter {

    /**
     * Executes writing operations inside [updateAction] block with reading data opportunity
     */
    override suspend fun updateWithRead(
        updateAction: suspend (KeyValueStorageReader, KeyValueStorageWriteOperations) -> Unit
    ) =
        updateAction(reader, writerOperations)

    /**
     * Executes writing operations inside [updateAction] block
     */
    override suspend fun update(updateAction: suspend (KeyValueStorageWriteOperations) -> Unit) =
        updateAction(writerOperations)
}