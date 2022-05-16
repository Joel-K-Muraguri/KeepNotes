package com.joel.keepnotes.datamodel

import kotlinx.coroutines.flow.Flow

class NoteRepoImpl(
    private val dao: NoteDao
) :NoteRepo {
    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
    }

    override fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insert(note: Note) {
        dao.insert(note)
    }

    override suspend fun update(note: Note) {
        dao.update(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}