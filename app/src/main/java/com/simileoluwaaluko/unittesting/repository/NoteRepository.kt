package com.simileoluwaaluko.unittesting.repository

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.simileoluwaaluko.unittesting.models.Note
import com.simileoluwaaluko.unittesting.persistence.NoteDao
import com.simileoluwaaluko.unittesting.ui.Resource
import io.reactivex.Flowable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Simileoluwa Aluko on 2020-05-12.
 */


class NoteRepository @Inject constructor(@NonNull val noteDao : NoteDao){
    companion object{
        val NOTE_TITLE_NULL = "Note title cannot be null"
        val INVALID_NOTE_ID = "Invalid id. Can't delete note"
        val DELETE_SUCCESS = "Delete success"
        val DELETE_FAILURE = "Delete failure"
        val UPDATE_SUCCESS = "Update success"
        val UPDATE_FAILURE = "Update failure"
        val INSERT_SUCCESS = "Insert success"
        val INSERT_FAILURE = "Insert failure"
    }

    private val timeDelay = 0
    private val timeUnit = TimeUnit.SECONDS


    @Throws(Exception::class)
    fun insertNote(note: Note): Flowable<Resource<Int>> {
        checkTitle(note)
        return noteDao.insertNote(note)
            .delaySubscription(timeDelay.toLong(), timeUnit)
            .map { aLong ->
                aLong.toInt()
            }
            .onErrorReturn { -1 }
            .map(Function<Int, Any?> { integer ->
                if (integer > 0) {
                    Resource.success(integer, INSERT_SUCCESS)
                } else Resource.error(null, INSERT_FAILURE)
            })
            .subscribeOn(Schedulers.io())
            .toFlowable() as Flowable<Resource<Int>>
    }

    @Throws(Exception::class)
    private fun checkTitle(note: Note) {
        if (note.title == null) {
            throw Exception(NOTE_TITLE_NULL)
        }
    }

}