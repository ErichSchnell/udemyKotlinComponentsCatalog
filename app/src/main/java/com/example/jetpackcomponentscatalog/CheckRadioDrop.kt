package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.ui.theme.CheckInfo
import com.example.jetpackcomponentscatalog.ui.theme.CheckRadioButton


@Composable
fun MyTriStateCheckBoxList() {//checkInfo:CheckInfo
    var state by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(
        modifier = Modifier.padding(8.dp),
        state = state,
        onClick = {
            state = when (state) {
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        }
    )
}

@Composable
fun MyCheckBoxList(checkInfo: CheckInfo) {

    Row(Modifier.padding(8.dp), horizontalArrangement = Arrangement.Center) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(Modifier.width(8.dp))
        Text(text = "${checkInfo.title}", fontSize = 30.sp)
    }
}

@Composable
fun MyCheckBoxWithText(text: String) {
    var state by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.padding(8.dp), horizontalArrangement = Arrangement.Center) {
        Checkbox(checked = state, onCheckedChange = { state = !state }, enabled = true)
        Spacer(Modifier.width(8.dp))
        Text(text = "$text", fontSize = 30.sp)
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = false,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            checkmarkColor = Color.Blue,
            uncheckedColor = Color.Magenta,
            disabledColor = Color.Green
        )
    )
}

@Composable
fun MyRadioButtonList(checkRadioButton: CheckRadioButton) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = checkRadioButton.selected,
            onClick = { checkRadioButton.onCheckedChange(checkRadioButton.title) }
        )
        Text(
            text = "${checkRadioButton.title}",
            modifier = Modifier.padding(start = 6.dp),
            fontSize = 16.sp,

            )
    }
}

@Composable
fun MyRadioButton() {
    var state by rememberSaveable { mutableStateOf(false) }
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = state,
            enabled = true,
            onClick = { state = !state },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledColor = Color.Blue
            )
        )
        Text(text = "Ejemplo")
    }
}

@Composable
fun MyDropDownMenu() {
    var selectedText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Helado", "Cafe", "Chocolate", "Torta")

    Column(Modifier.padding(top = 20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach{
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = it
                }) {
                    Text(text = it)
                }
            }
        }
    }
}