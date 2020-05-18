package com.simileoluwaaluko.unittesting.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.simileoluwaaluko.unittesting.models.Note

/**
 * Created by Simileoluwa Aluko on 2020-05-10.
 */

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME = "notes"
    }

    abstract fun getNoteDao() : NoteDao
}