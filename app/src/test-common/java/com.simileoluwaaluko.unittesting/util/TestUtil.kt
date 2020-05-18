package com.simileoluwaaluko.unittesting.util

import com.simileoluwaaluko.unittesting.models.Note
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Simileoluwa Aluko on 2020-05-10.
 */

object TestUtil {
    const val TIMESTAMP_1 = "05-2019"
    val TEST_NOTE_1: Note = Note("Take out the trash", "It's garbage day tomorrow.", TIMESTAMP_1)

    const val TIMESTAMP_2 = "06-2019"
    val TEST_NOTE_2: Note = Note("Anniversary gift", "Buy an anniversary gift.", TIMESTAMP_2)

    val TEST_NOTES_LIST: List<Note> =
        listOf(Note(1, "Take out the trash", "It's garbage day tomorrow.", TIMESTAMP_1),
                Note(2, "Anniversary gift", "Buy an anniversary gift.", TIMESTAMP_2))
}