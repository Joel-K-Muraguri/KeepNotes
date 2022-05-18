package com.joel.keepnotes.ui.theme.listscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.keepnotes.datamodel.Note
import com.joel.keepnotes.datamodel.NoteRepo
import com.joel.keepnotes.util.Constants.ADD_EDIT_NOTE_ITEM
import com.joel.keepnotes.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val repository : NoteRepo
)
    : ViewModel() {

    val notes = repository.getAllNotes()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var deletedNote : Note? = null

    fun onEvent(event: ListScreenTodoEvent){
        when(event){
            is ListScreenTodoEvent.OnAddNoteClick -> {
                sendUiEvent(UiEvent.Navigate(ADD_EDIT_NOTE_ITEM))
            }
            is ListScreenTodoEvent.OnNoteClick -> {
                sendUiEvent(UiEvent.Navigate(ADD_EDIT_NOTE_ITEM + "?noteId= ${event.note.id}"))
            }
            is ListScreenTodoEvent.UndoDeleteClick -> {
                deletedNote?.let { note ->
                    viewModelScope.launch {
                        repository.insert(note)
                    }
                }
            }
            is ListScreenTodoEvent.OnDeleteAll -> {
                viewModelScope.launch {
                   // deletedNote = event.note
                    repository.deleteAll()
                    sendUiEvent(UiEvent.SnackBar(
                        message = "DELETED ALL",
                        action = "UNDO"
                    ))
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}