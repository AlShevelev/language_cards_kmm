package com.shevelev.languagecards.data.repository.cards

import com.shevelev.languagecards.domain.model.card.Color
import com.shevelev.languagecards.domain.model.card.ContentItemType
import com.shevelev.languagecards.domain.model.card.Language

internal class MappingHelper {
    fun colorToDb(color: Color?): Short? =
        color?.let {
            when(it) {
                Color.RED -> 0
                Color.GREEN -> 1
                Color.BLUE -> 2
                Color.YELLOW -> 3
                Color.GRAY -> 4
                Color.BROWN -> 5
            }
        }

    fun colorFromDb(color: Short?): Color? =
        color?.let {
            when(it.toInt()) {
                0 -> Color.RED
                1 -> Color.GREEN
                2 -> Color.BLUE
                3 -> Color.YELLOW
                4 -> Color.GRAY
                5 -> Color.BROWN
                else -> null
            }
        }

    fun contentItemTypeToDb(type: ContentItemType): Short =
        when(type) {
            ContentItemType.CLARIFICATION -> 0
            ContentItemType.MAIN -> 1
            ContentItemType.EXAMPLE -> 2
        }

    fun contentItemTypeFromDb(type: Short?): ContentItemType? =
        type?.let {
            when(it.toInt()) {
                0 -> ContentItemType.CLARIFICATION
                1 -> ContentItemType.MAIN
                2 -> ContentItemType.EXAMPLE
                else -> null
            }
        }

    fun languageToDb(language: Language): Short =
        when(language) {
            Language.RUSSIAN -> 0
            Language.ENGLISH -> 1
        }

    fun languageFromDb(language: Short?): Language? =
        language?.let {
            when(it.toInt()) {
                0 -> Language.RUSSIAN
                1 -> Language.ENGLISH
                else -> null
            }
        }
}