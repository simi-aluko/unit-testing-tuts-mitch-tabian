package com.simileoluwaaluko.unittesting.ui.note

import com.simileoluwaaluko.unittesting.repository.NoteRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by Simileoluwa Aluko on 2020-05-17.
 */
class NoteViewModelTest {
    lateinit var noteViewModel : NoteViewModel

    @Mock
    lateinit var noteRepository : NoteRepository

    @BeforeEach
    fun init(){
        MockitoAnnotations.initMocks(this)
        noteViewModel = NoteViewModel(noteRepository)
    }

    /**
     * can't observe a note that hasn't been set
     */
    @Test
    fun observeEmptyNoteWhenNotSet() {
        TODO("Not yet implemented")
    }

    /**
     *  Observe a note that has been set and onchanged will trigger
     */
    @Test
    fun observeNote_whenSet() {
        TODO("Not yet implemented")
    }

    /**
     *  Insert a new note and observe row returned
     */
    @Test
    fun insertNote_returnRow() {

    }

    /**
     *  Insert: dont return a new row without observer
     */
    @Test
    fun dontReturnInsertRowWithoutObserver() {
        TODO("Not yet implemented")
    }

    /**
     *  set note, null title, throw exceptions
     */
    @Test
    fun setNote_nullTitle_throwException() {
        TODO("Not yet implemented")
    }
}