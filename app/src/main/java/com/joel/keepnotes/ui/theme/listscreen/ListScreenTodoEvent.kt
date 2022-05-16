package com.joel.keepnotes.ui.theme.listscreen

 sealed class ListScreenTodoEvent {

     // Navigates User to the Add/ edit screen
     object OnAddNoteClick : ListScreenTodoEvent()
     // Navigates user to the add/edit screen of a specific user
     object OnNoteClick : ListScreenTodoEvent()

}