package com.shevelev.languagecards.data.api

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createKeyValueStorageDriver(): SqlDriver

    fun createAppStorageDriver(): SqlDriver
}