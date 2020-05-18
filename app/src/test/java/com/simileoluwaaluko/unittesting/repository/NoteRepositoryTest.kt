package com.simileoluwaaluko.unittesting.repository

import com.simileoluwaaluko.unittesting.models.Note
import com.simileoluwaaluko.unittesting.persistence.NoteDao
import com.simileoluwaaluko.unittesting.repository.NoteRepository.Companion.INSERT_FAILURE
import com.simileoluwaaluko.unittesting.repository.NoteRepository.Companion.INSERT_SUCCESS
import com.simileoluwaaluko.unittesting.repository.NoteRepository.Companion.NOTE_TITLE_NULL
import com.simileoluwaaluko.unittesting.ui.Resource
import com.simileoluwaaluko.unittesting.util.TestUtil
import io.reactivex.Single
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.*
import java.lang.Exception

/**
 * Created by Simileoluwa Aluko on 2020-05-17.
 */
class NoteRepositoryTest{

    private fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }
    private fun <T> uninitialized(): T = null as T

    private val NOTE1: Note = Note(TestUtil.TEST_NOTE_1)
    lateinit var noteRepository: NoteRepository
    lateinit var noteDao: NoteDao

    @BeforeEach
    fun initEach(){
        noteDao = mock(NoteDao::class.java)
        noteRepository = NoteRepository(noteDao)
    }

    /**
     *  insert Note
     *  verify the correct method is called
     *  confirm observer is triggered
     *  confirm new rows inserted
     */
    @Test
    fun insertNote_returnRow() {
        // Arrange
        val insertedRow = 1L
        val returnedData = Single.just(insertedRow)
        `when`(noteDao.insertNote(any())).thenReturn(returnedData)

        // Act
        val returnedValue = noteRepository.insertNote(NOTE1).blockingFirst()

        // Assert
        verify(noteDao).insertNote(any())
        verifyNoMoreInteractions(noteDao)

        println("ReturnedValue: ${returnedValue.data}")
        assertEquals(Resource.success(1, INSERT_SUCCESS), returnedValue)

/*        // or test using RXJava
        noteRepository.insertNote(NOTE1).test().await()
            .assertValue(Resource.success(1, INSERT_SUCCESS))*/
    }


    /**
     * insert Note
     * failure (return -1)
     */
    @Test
    fun insertNote_returnFailure() {
        // Arrange
        val failedInsert = -1L
        val returnedData = Single.just(failedInsert)
        `when`(noteDao.insertNote(any())).thenReturn(returnedData)

        // Act
        val returnedValue = noteRepository.insertNote(NOTE1).blockingFirst()

        // Assert
        verify(noteDao).insertNote(any())
        verifyNoMoreInteractions(noteDao)

        assertEquals(Resource.error(null , INSERT_FAILURE), returnedValue)
    }


    /**
     *  insert note
     *  null title
     *  confirm throw exception
     */
    @Test
    fun insertNote_nullTitle_throwException() {
        val exception = assertThrows(Exception::class.java) {
            val note = Note(TestUtil.TEST_NOTE_1)
            note.title = null
            noteRepository.insertNote(note)
        }

        assertEquals(NOTE_TITLE_NULL, exception.message)
    }
}