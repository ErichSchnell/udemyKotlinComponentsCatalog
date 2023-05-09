package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
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


@Composable
fun MyDivider() {
    Divider(modifier = Modifier.fillMaxWidth(), color = Color.Red)
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = 40.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.Green,
        contentColor = Color.Magenta,
        border = BorderStroke(5.dp, Color.Gray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Eje 1")
            Text(text = "Eje 2")
            Text(text = "Eje 3")
            Text(text = "Eje 4")
        }
    }
}

@Composable
fun MySwitch() {
    var swithState by rememberSaveable { mutableStateOf(true) }
    Switch(
        checked = swithState,
        onCheckedChange = { swithState = !swithState },
        enabled = false,
        colors = SwitchDefaults.colors(
            checkedTrackColor = Color.Black,
            checkedThumbColor = Color.Black,
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Red,
            disabledCheckedThumbColor = Color.Yellow,
            disabledCheckedTrackColor = Color.Yellow,
            disabledUncheckedThumbColor = Color.Magenta,
            disabledUncheckedTrackColor = Color.Magenta,
            checkedTrackAlpha = 0.2f,
            uncheckedTrackAlpha = 0.2f
        )
    )
}

@Composable
fun MyProgressAdvance(progressReal: Float) {

    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.padding(top = 5.dp),
            color = Color.Red,
            strokeWidth = 5.dp,
            progress = progressReal

        )
    }
}

@Composable
fun MyProgress() {
    var enableProgress by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (enableProgress) {
            CircularProgressIndicator(
                modifier = Modifier.padding(top = 5.dp),
                color = Color.Red,
                strokeWidth = 5.dp
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(5.dp),
                color = Color.Red,
                backgroundColor = Color.Yellow
            )
        }

        Button(onClick = { enableProgress = !enableProgress }) { Text(text = "enable") }

    }
}