package com.shevelev.languagecards.data.repository.keyvaluestorage

import com.shevelev.languagecards.data.api.DatabaseDriverFactory
import com.shevelev.languagecards.data.api.keyvaluestorage.KeyValueStorageDatabase

/**
 * An implementation for access to a key-value storage based on SQLDelight
 */
class KeyValueStorageImpl(
    private val dbDriverFactory: DatabaseDriverFactory,
    private val storageKey: String
) : KeyValueStorage {

    private val database by lazy { KeyValueStorageDatabase(dbDriverFactory.createKeyValueStorageDriver()) }

    /**
     * An entity for reading data from a key-value storage
     */
    override val reader: KeyValueStorageReader by lazy {
        KeyValueStorageReaderImpl(database.keyValueStorageQueries, storageKey)
    }

    /**
     * An entity for updating data in a key-value storage
     */
    override val writer: KeyValueStorageWriter by lazy {
        KeyValueStorageWriterImpl(database.keyValueStorageQueries, storageKey, reader)
    }
}