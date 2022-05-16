package com.joel.keepnotes.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.joel.keepnotes.util.Constants.DATABASE_NAME

@Entity(tableName = DATABASE_NAME)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title : String,
    val notes : String,
)
