package com.simileoluwaaluko.unittesting.di

import android.app.Application
import androidx.room.Room
import com.simileoluwaaluko.unittesting.persistence.NoteDao
import com.simileoluwaaluko.unittesting.persistence.NoteDatabase
import com.simileoluwaaluko.unittesting.persistence.NoteDatabase.Companion.DATABASE_NAME
import com.simileoluwaaluko.unittesting.repository.NoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(application: Application) : NoteDatabase{
        return Room.databaseBuilder(
            application,
            NoteDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) : NoteDao{
        return noteDatabase.getNoteDao()
    }

    @Singleton
    @Provides
    fun provideNoteRepository(noteDao : NoteDao) : NoteRepository{
        return NoteRepository(noteDao)
    }
}
