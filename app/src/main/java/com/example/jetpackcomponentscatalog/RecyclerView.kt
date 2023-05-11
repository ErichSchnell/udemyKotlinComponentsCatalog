package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MySimpleRecyclerView(){
    val nombres = listOf("erich","perdro","mengano","sultano")
    LazyColumn{
        item { Text(text = "Inicio") }
        items(7){
            Text(text = "Este es el texto numero $it")
        }
        items(nombres){
            Text(text = "este es mi nombre $it")
        }
        item { Text(text = "Fin") }
    }
}