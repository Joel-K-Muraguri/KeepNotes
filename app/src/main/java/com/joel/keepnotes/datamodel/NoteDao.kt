package com.joel.keepnotes.datamodel

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM Notes_table")
    fun getAllNotes() : Flow<List<Note>>

    @Query("SELECT * FROM Notes_table WHERE id = :id")
    fun getNoteById(id : Int) : Note?

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM Notes_table")
    suspend fun deleteAll()
}