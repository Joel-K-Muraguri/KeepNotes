package com.joel.keepnotes.ui.theme.listscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.keepnotes.datamodel.Note

@Composable
fun NoteItem(
    note : Note,
    modifier: Modifier
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 10.dp
    ) {
        Column() {
            Text(
                text = note.title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))

            note.notes?.let { 
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = it)
            }
        }
    }
}

