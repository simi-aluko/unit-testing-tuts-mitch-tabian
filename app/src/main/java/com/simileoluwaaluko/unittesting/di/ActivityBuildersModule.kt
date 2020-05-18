package com.simileoluwaaluko.unittesting.di

import com.simileoluwaaluko.unittesting.ui.noteslist.NotesListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(
        modules = [

        ]
    )
    abstract fun contributesNotesListActivity() : NotesListActivity
}
