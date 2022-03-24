package com.shevelev.languagecards.data.repository.keyvaluestorage

/**
 * An interface for updating data in a key-value storage
 */
interface KeyValueStorageWriter {
    /**
     * Executes writing operations inside [updateAction] block with reading data opportunity
     */
    fun updateWithRead(updateAction: (KeyValueStorageReader, KeyValueStorageWriteOperations) -> Unit)

    /**
     * Executes writing operations inside [updateAction] block
     */
    fun update(updateAction: (KeyValueStorageWriteOperations) -> Unit)
}