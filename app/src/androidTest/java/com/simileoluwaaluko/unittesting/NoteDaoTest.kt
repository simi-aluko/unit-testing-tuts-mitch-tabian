package com.simileoluwaaluko.unittesting

import android.database.sqlite.SQLiteConstraintException
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.simileoluwaaluko.unittesting.models.Note
import com.simileoluwaaluko.unittesting.util.LiveDataTestUtil
import com.simileoluwaaluko.unittesting.util.TestUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

/**
 * Created by Simileoluwa Aluko on 2020-05-10.
 */
class NoteDaoTest : NoteDatabaseTest() {
    val TEST_TITLE = "This is a test title"
    val TEST_CONTENT = "This is some test content"
    val TEST_TIMESTAMP = "08-2018"

    @JvmField
    @Rule
    val rule = InstantTaskExecutorRule()

    /*
        Insert, Read, Delete
     */
    @Test
    fun insertReadDelete() {
        val note = Note(TestUtil.TEST_NOTE_1)

        // insert note
        getNoteDao().insertNote(note).blockingGet()

        // read
        val liveDataTestUtil = LiveDataTestUtil<List<Note>>()
        var insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())

        assertNotNull(insertedNotes)

        assertEquals(note.content, insertedNotes?.get(0)?.content)
        assertEquals(note.timestamp, insertedNotes?.get(0)?.timestamp)
        assertEquals(note.title, insertedNotes?.get(0)?.title)

        note.id = insertedNotes?.get(0)?.id ?: 0

        assertEquals(note, insertedNotes?.get(0))

        // delete
        getNoteDao().deleteNote(note).blockingGet()

        // confirm that database is empty
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())
        assertEquals(0, insertedNotes?.size)
    }

    /*
    Insert, Read, Update, Read, Delete,
    */

    @Test
    fun insertReadUpdateReadDelete() {
        val note = Note(TestUtil.TEST_NOTE_1)

        // insert note
        getNoteDao().insertNote(note).blockingGet()

        // read
        val liveDataTestUtil = LiveDataTestUtil<List<Note>>()
        var insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())

        assertNotNull(insertedNotes)

        assertEquals(note.content, insertedNotes?.get(0)?.content)
        assertEquals(note.timestamp, insertedNotes?.get(0)?.timestamp)
        assertEquals(note.title, insertedNotes?.get(0)?.title)

        note.id = insertedNotes?.get(0)?.id ?: 0

        assertEquals(note, insertedNotes?.get(0))

        // update
        note.title = TEST_TITLE
        note.content = TEST_CONTENT
        note.timestamp = TEST_TIMESTAMP
        getNoteDao().updateNote(note).blockingGet()

        // read
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())
        assertEquals(TEST_CONTENT, insertedNotes?.get(0)?.content)
        assertEquals(TEST_TIMESTAMP, insertedNotes?.get(0)?.timestamp)
        assertEquals(TEST_TITLE, insertedNotes?.get(0)?.title)

        note.id = insertedNotes?.get(0)?.id ?: 0
        assertEquals(note, insertedNotes?.get(0))

        // delete
        getNoteDao().deleteNote(note).blockingGet()

        // confirm that database is empty
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())
        assertEquals(0, insertedNotes?.size)
    }

    /*
    Insert note with null title, throw exception
    */
    @Test(expected = SQLiteConstraintException::class)
    fun insert_nullTitle_throwSQLiteConstraintException() {
        val note = Note(TestUtil.TEST_NOTE_1)
        note.title = null

        getNoteDao().insertNote(note).blockingGet()
    }

    /*
    Insert, Update with null title, throw exception
    */
    @Test(expected = SQLiteConstraintException::class)
    fun updateNote_nullTitle_throwSQLiteConstraintException() {
        var note = Note(TestUtil.TEST_NOTE_1)

        // insert
        getNoteDao().insertNote(note).blockingGet()

        // read
        val liveDataTestUtil = LiveDataTestUtil<List<Note>>()
        val insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())
        assertNotNull(insertedNotes)

        // update
        insertedNotes?.let {
            note = Note(it[0])
            note.title = null
            getNoteDao().updateNote(note).blockingGet()
        }
    }
}