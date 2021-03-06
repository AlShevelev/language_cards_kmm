package com.shevelev.languagecards.data.repository.keyvaluestorage

import com.shevelev.languagecards.data.api.DatabaseDriverFactory
import com.shevelev.languagecards.data.api.keyvaluestorage.KeyValueStorageDatabase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * An implementation for access to a key-value storage based on SQLDelight
 */
class KeyValueStorageImpl(
    private val dbDriverFactory: DatabaseDriverFactory,
    private val storageKey: String,
    private val ioDispatcher: CoroutineDispatcher
) : KeyValueStorage {

    private val database by lazy { KeyValueStorageDatabase(dbDriverFactory.createKeyValueStorageDriver()) }

    /**
     * An entity for reading data from a key-value storage
     */
    override val reader: KeyValueStorageReader by lazy {
        KeyValueStorageReaderImpl(
            dbQueries = database.keyValueStorageQueries,
            storageKey = storageKey,
            ioDispatcher = ioDispatcher
        )
    }

    /**
     * An entity for updating data in a key-value storage
     */
    override val writer: KeyValueStorageWriter by lazy {
        KeyValueStorageWriterImpl(
            reader = reader,
            writerOperations = KeyValueStorageWriteOperationsImpl(
                dbQueries = database.keyValueStorageQueries,
                storageKey = storageKey,
                ioDispatcher = ioDispatcher
            )
        )
    }
}