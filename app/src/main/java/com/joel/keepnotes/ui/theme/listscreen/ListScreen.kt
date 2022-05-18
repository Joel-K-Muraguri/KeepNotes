package com.joel.keepnotes.ui.theme.listscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joel.keepnotes.util.UiEvent
import kotlinx.coroutines.flow.collect

@Composable
fun ListScreen(
    onNavigate : (UiEvent.Navigate) -> Unit,
    viewModel: ListScreenViewModel
){
     val notes = viewModel.notes.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect { event ->
            when(event){
                is UiEvent.SnackBar -> {
                    val result = scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                    if (result == SnackbarResult.ActionPerformed){
                        viewModel.onEvent(ListScreenTodoEvent.UndoDeleteClick)
                    }
                }
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "NOTES")
                },
                actions = {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Delete")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(ListScreenTodoEvent.OnAddNoteClick)
                }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add")
            }
        },
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
            items(notes.value){ note ->
                NoteItem(
                    note = note,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            viewModel.onEvent(ListScreenTodoEvent.OnNoteClick(note))
                        }
                )
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun ListScreenPreview(){
    ListScreen()
} */