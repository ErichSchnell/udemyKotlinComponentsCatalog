package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Place,
        contentDescription = "IconEjemplo",
        tint = Color.Gray
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.killjoy),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .size(150.dp)
            .border(3.dp, Color.Green, CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_meme),
        contentDescription = "Es un Ejemplo",
        alpha = 1f,
        modifier = Modifier.size(150.dp)
    )
}