package com.example.jetpackcomponentscatalog.ui.theme

data class CheckInfo(val title:String, var selected:Boolean = false, var onCheckedChange:(Boolean) -> Unit)
data class CheckRadioButton(val title:String, var selected:Boolean = false, var onCheckedChange:(String) -> Unit)