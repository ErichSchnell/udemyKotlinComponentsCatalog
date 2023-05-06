package com.example.jetpackcomponentscatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.ui.theme.CheckInfo
import com.example.jetpackcomponentscatalog.ui.theme.CheckRadioButton
import com.example.jetpackcomponentscatalog.ui.theme.JetpackComponentsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(20.dp)) {

                    }
                }
            }
        }
    }
}

@Composable
fun getListRadioButton(titles:List<String>):List<CheckRadioButton> {
    var status by rememberSaveable { mutableStateOf("") }
    return titles.map {
        CheckRadioButton(
            title = it,
            selected = status == it,
            onCheckedChange = { status = it }
        )
    }
}

@Composable
fun getListBox(titles:List<String>):List<CheckInfo>{
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { status = it }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComponentsCatalogTheme {
        //MyBadgeBox()
    }
}

//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun MyBadgeBox(){
//    BadgedBox(
//        badge = { Text(text = "1")},
//        modifier = Modifier.padding(16.dp),
//    ) {
//        Icon(imageVector = Icons.Default.Star, contentDescription = "")
//    }
//}
@Composable
fun MyCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = 40.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.Green,
        contentColor = Color.Magenta,
        border = BorderStroke(5.dp, Color.Gray)
    ){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Eje 1")
            Text(text = "Eje 2")
            Text(text = "Eje 3")
            Text(text = "Eje 4")
        }
    }
}

@Composable
fun MyRadioButtonList(checkRadioButton: CheckRadioButton){
    Row() {
        RadioButton(selected = checkRadioButton.selected, onClick = {checkRadioButton.onCheckedChange(checkRadioButton.title) } )
        Text(text = "${checkRadioButton.title}")
    }
}
@Composable
fun MyRadioButton(){
    var state by rememberSaveable{ mutableStateOf(false) }
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = state,
            enabled = true,
            onClick = {  state = ! state},
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
fun  MyTriStateCheckBoxList(){//checkInfo:CheckInfo
    var state by rememberSaveable{ mutableStateOf(ToggleableState.Off) }
    
    TriStateCheckbox(
        modifier = Modifier.padding(8.dp),
        state = state,
        onClick = {
            state = when(state){
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        }
    )
}

@Composable
fun  MyCheckBoxList(checkInfo:CheckInfo){

    Row(Modifier.padding(8.dp), horizontalArrangement = Arrangement.Center) {
        Checkbox(checked = checkInfo.selected, onCheckedChange = {checkInfo.onCheckedChange(!checkInfo.selected)})
        Spacer(Modifier.width(8.dp))
        Text(text = "${checkInfo.title}", fontSize = 30.sp)
    }
}

@Composable
fun  MyCheckBoxWithText(text:String){
    var state by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.padding(8.dp), horizontalArrangement = Arrangement.Center) {
        Checkbox(checked = state, onCheckedChange = {state = !state}, enabled = true)
        Spacer(Modifier.width(8.dp))
        Text(text = "$text", fontSize = 30.sp)
    }
}
@Composable
fun  MyCheckBox(){
    var state by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = state,
        onCheckedChange = {state = !state},
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
fun MySwitch(){
    var swithState by rememberSaveable { mutableStateOf(true) }
    Switch(
        checked = swithState,
        onCheckedChange = {swithState = !swithState},
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
fun MyProgressAdvance(progressReal:Float){

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
fun MyProgress(){
    var enableProgress by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if(enableProgress){
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

        Button(onClick = { enableProgress = !enableProgress}) { Text(text = "enable")}

    }
}

@Composable
fun MyIcon(){
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

@Composable
fun MyOutLinedTextField(data: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier.padding(5.dp),
        value = data,
        onValueChange = { onValueChange(it) },
        label = { Text(text = "Holita") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyTextFieldAdvance(name: String, onValueChange: (String) -> Unit) {
    TextField(
        modifier = Modifier.padding(5.dp),
        value = name,
        onValueChange = {
            onValueChange(it)
        },
        label = { Text(text = "habilita btn") }
    )
}

@Composable
fun MyTextField(name: String, onValueChange: (String) -> Unit) {
    TextField(
        modifier = Modifier.padding(5.dp),
        value = name,
        onValueChange = { onValueChange(it) }
    )
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Red)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", fontFamily = FontFamily.Cursive)
        Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.LineThrough)
        Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.Underline)
        Text(
            text = "Esto es un ejemplo", textDecoration = TextDecoration.combine(
                listOf(TextDecoration.Underline, TextDecoration.LineThrough)
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }
}
