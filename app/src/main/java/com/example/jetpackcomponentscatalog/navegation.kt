package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jetpackcomponentscatalog.model.Routes
import com.example.jetpackcomponentscatalog.model.Routes.*

@Composable
fun Screen1(navegationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(text = "Pantalla1", modifier = Modifier.align(Alignment.Center)
            .clickable { navegationController.navigate(Pantalla2.route) })
    }
}

@Composable
fun Screen2(navegationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(text = "Pantalla2", modifier = Modifier.align(Alignment.Center)
            .clickable { navegationController.navigate(Pantalla3.route) })
    }
}

@Composable
fun Screen3(navegationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(text = "Pantalla3", modifier = Modifier.align(Alignment.Center))
    }
}