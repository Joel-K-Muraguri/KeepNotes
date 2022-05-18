package com.joel.keepnotes.util

sealed class UiEvent(){
    data class Navigate (val route : String) : UiEvent()
    object PopBackStack : UiEvent()
    data class SnackBar (
        val message : String,
        val action : String? = null
            ) : UiEvent()
}
