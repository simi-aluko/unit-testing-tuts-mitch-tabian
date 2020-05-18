 package com.simileoluwaaluko.unittesting.ui.noteslist

import android.os.Bundle
import android.util.Log
import com.simileoluwaaluko.unittesting.R
import com.simileoluwaaluko.unittesting.repository.NoteRepository
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

 class NotesListActivity : DaggerAppCompatActivity() {

     @Inject
     lateinit var noteRepository : NoteRepository
     val TAG = "NotesListActivity"

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_notes_list)

         Log.d(TAG, "onCreate: " + noteRepository)
     }
}
