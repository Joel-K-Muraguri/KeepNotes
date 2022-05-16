package com.joel.keepnotes.datamodel


import kotlinx.coroutines.flow.Flow

interface NoteRepo {

    fun getAllNotes() : Flow<List<Note>>

    fun getNoteById(id : Int) : Note?

    suspend fun insert(note: Note)

    suspend fun update(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun deleteAll()
}