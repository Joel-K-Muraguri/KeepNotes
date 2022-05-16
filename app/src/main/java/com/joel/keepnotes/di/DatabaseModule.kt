package com.joel.keepnotes.di

import android.app.Application
import androidx.room.Room
import com.joel.keepnotes.datamodel.NoteDatabase
import com.joel.keepnotes.datamodel.NoteRepo
import com.joel.keepnotes.datamodel.NoteRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDataBase(app : Application) : NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            "Note_Database"
        ).build()

    }

    @Provides
    @Singleton
    fun provideNoteRepo(database: NoteDatabase): NoteRepo {
        return NoteRepoImpl(database.dao)

    }

}