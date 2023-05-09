package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*

@Composable
fun MyBasicSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column {
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun MyAdvanceSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    var completeValue by remember { mutableStateOf("") }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {completeValue = sliderPosition.toString()},
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = completeValue)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    var currentRange by remember { mutableStateOf(0f..10f) }
    var completeValueStart by remember { mutableStateOf("") }
    var completeValueEnd by remember { mutableStateOf("") }
    RangeSlider(
        values = currentRange,
        onValueChange = { currentRange = it },
        onValueChangeFinished = {
            completeValueStart = currentRange.start.toString()
            completeValueEnd = currentRange.endInclusive.toString()
        },
        valueRange = 0f..10f,
        steps = 9
    )
    Text(text = "Valor inferior: ${completeValueStart}")
    Text(text = "Valor inferior: ${completeValueEnd}")
}