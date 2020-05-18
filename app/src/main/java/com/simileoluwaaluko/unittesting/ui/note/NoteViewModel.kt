package com.simileoluwaaluko.unittesting.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simileoluwaaluko.unittesting.models.Note
import com.simileoluwaaluko.unittesting.repository.NoteRepository
import com.simileoluwaaluko.unittesting.repository.NoteRepository.Companion.NOTE_TITLE_NULL
import com.simileoluwaaluko.unittesting.ui.Resource
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by Simileoluwa Aluko on 2020-05-17.
 */
class NoteViewModel @Inject constructor(val noteRepository: NoteRepository) : ViewModel() {
    val TAG = "NoteViewModel"
    val note = MutableLiveData<Note>()

    fun insertNote() : LiveData<Resource<Int>>{
        return LiveDataReactiveStreams.fromPublisher(
            noteRepository.insertNote(note.value!!)
        )
    }

    fun observeNote() : LiveData<Note>{
        return note
    }

    fun setNote(note : Note){
        if(note.title == null || note.title.equals("")){
            throw Exception(NOTE_TITLE_NULL)
        }
        this.note.value = note
    }
}