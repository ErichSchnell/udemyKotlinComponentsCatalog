package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.ui.theme.CheckRadioButton

@Composable
fun MyTextButton(onClick: () -> Unit) {
    TextButton(onClick = { onClick() }) {
        Text(text = "hola soy un textButton")
    }
}

@Composable
fun MyOutlinedButton(estado: Boolean, onClick: () -> Unit) {
    Button(
        modifier = Modifier.padding(top = 5.dp),
        enabled = estado,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.Yellow,
            disabledBackgroundColor = Color.Yellow,
            disabledContentColor = Color.Black
        ),
        //border = BorderStroke(2.dp, Color.Yellow)
    ) {
        Text(text = "Presionamee")
    }
}

@Composable
fun MyButton(estado: Boolean, onClick: () -> Unit) {
    Button(
        modifier = Modifier.padding(5.dp),
        enabled = estado,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.Yellow
        ),
        border = BorderStroke(2.dp, Color.Yellow)
    ) {
        Text(text = "Presionamee")
    }
}