package com.simileoluwaaluko.unittesting

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.simileoluwaaluko.unittesting.persistence.NoteDao
import com.simileoluwaaluko.unittesting.persistence.NoteDatabase
import org.junit.After
import org.junit.Before

/**
 * Created by Simileoluwa Aluko on 2020-05-10.
 */


abstract class NoteDatabaseTest {

    // system under test
    open lateinit var noteDatabase: NoteDatabase


    open fun getNoteDao(): NoteDao {
        return noteDatabase.getNoteDao()
    }

    @Before
    open fun init() {
        noteDatabase = Room.inMemoryDatabaseBuilder<NoteDatabase>(
            ApplicationProvider.getApplicationContext(),
            NoteDatabase::class.java
        ).build()
    }

    @After
    open fun finish() {
        noteDatabase.close()
    }

}
