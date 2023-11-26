package com.example.mynoteapp.Database

import androidx.lifecycle.LiveData
import com.example.mynoteapp.Models.Note

class NotesRepository(private val noteDao: NoteDao) {

    private val _allNotes : LiveData<List<Note>> = noteDao.getAllNotes()
    val allNotes: LiveData<List<Note>>
        get() = _allNotes

    suspend fun insert(note: Note) {
         noteDao.insert(note)
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }

    suspend fun update(note: Note) {
        noteDao.update(note.id, note.title, note.note)
    }
}