package com.simileoluwaaluko.unittesting.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.simileoluwaaluko.unittesting.models.Note
import io.reactivex.Single

/**
 * Created by Si
 * mileoluwa Aluko on 2020-05-10.
 */
@Dao
interface NoteDao {

    @Insert
    @Throws(Exception::class)
    fun insertNote(note: Note): Single<Long>

    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Note>>

    @Delete
    @Throws(Exception::class)
    fun deleteNote(note: Note): Single<Int>

    @Update
    @Throws(Exception::class)
    fun updateNote(note: Note): Single<Int>
}