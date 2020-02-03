package com.example.googlekeeperkotlin.data

import com.example.googlekeeperkotlin.data.model.Note

object Repository {
    private val notes: List<Note>


    init {
        notes = listOf(
            Note(
                "Заметка 1",
                "Kotlin очень краткий, но при этом выразительный язык",
                0xfff06292.toInt()
            ),
            Note(
                "Заметка 2",
                "Kotlin очень краткий, но при этом выразительный язык",
                0xff9575cd.toInt()
            ),
            Note(
                "Заметка 3",
                "Kotlin очень краткий, но при этом выразительный язык",
                0xff64b5f6.toInt()
            ),
            Note(
                "Заметка 4",
                "Kotlin очень краткий, но при этом выразительный язык",
                0xff4db6ac.toInt()
            ),
            Note(
                "Заметка 5",
                "Kotlin очень краткий, но при этом выразительный язык",
                0xffb2ff59.toInt()
            ),
            Note(
                "Заметка 6",
                "Kotlin очень краткий, но при этом выразительный язык",
                0xffffeb3b.toInt()
            ),
            Note(
                "Заметка 7",
                "Kotlin очень краткий, но при этом выразительный язык",
                0xffff6e40.toInt()
            )
        )
    }


    fun getNotes(): List<Note> {
        return notes
    }
}
