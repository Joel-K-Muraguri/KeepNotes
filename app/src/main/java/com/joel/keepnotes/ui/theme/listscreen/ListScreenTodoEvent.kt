package com.joel.keepnotes.ui.theme.listscreen

import com.joel.keepnotes.datamodel.Note

sealed class ListScreenTodoEvent {

     // Navigates User to the Add/ edit screen
     object OnAddNoteClick : ListScreenTodoEvent()
     // Navigates user to the add/edit screen of a specific user
     object OnDeleteAll : ListScreenTodoEvent()

     //Deletes all the notes present on the list screen
     data class OnNoteClick( val note: Note) : ListScreenTodoEvent()

     // Undo delete with the snackbar action
    object UndoDeleteClick  : ListScreenTodoEvent()



}