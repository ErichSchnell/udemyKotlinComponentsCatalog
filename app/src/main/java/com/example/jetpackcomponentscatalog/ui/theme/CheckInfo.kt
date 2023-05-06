package com.example.jetpackcomponentscatalog.ui.theme

data class CheckInfo(val title:String, var selected:Boolean = false, var oncheckedChange:(Boolean) -> Unit)