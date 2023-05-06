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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.ui.theme.JetpackComponentsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                       /* var myTextField1 by rememberSaveable { mutableStateOf("") }
                        var myTextFieldAdvance1 by rememberSaveable { mutableStateOf("") }
                        var myOutLinedTextField1 by rememberSaveable { mutableStateOf("") }
                        var estado by rememberSaveable { mutableStateOf(true) }
                        var progressReal by rememberSaveable { mutableStateOf(0f) }
                        var estadoProgressBtnIncrese by rememberSaveable { mutableStateOf(true) }
                        var estadoProgressBtnDecrese by rememberSaveable { mutableStateOf(true) }

                        MyTextField(myTextField1) { myTextField1 = it }
                        MyTextButton() {
                            myTextFieldAdvance1 = myTextField1
                            myOutLinedTextField1 = myTextField1
                        }

                        MyOutLinedTextField(myOutLinedTextField1) { myOutLinedTextField1 = it }
                        MyTextFieldAdvance(myTextFieldAdvance1) {
                            if (it.contains("habilitar")) {
                                estado = true
                            }
                            myTextFieldAdvance1 = it
                        }

                        MyButton(estado) {
                            Log.i("erich", "Se presiono el btn")
                            estado = false
                            myTextField1 = ""
                            myTextFieldAdvance1 = ""
                            myOutLinedTextField1 = ""
                        }
                        MyOutlinedButton(estado) {
                            Log.i("erich", "Se presiono el btn outlined")
                            estado = false
                            myTextFieldAdvance1 = ""
                        }

                        MySwitch()
                        MyCheckBox()

                        MyProgress()
                        MyImage()
                        MyImageAdvance()
                        MyProgressAdvance(progressReal)
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            MyButton(estadoProgressBtnIncrese){
                                progressReal += 0.1f
                            }
                            MyButton(estadoProgressBtnDecrese){
                                progressReal -= 0.1f
                            }
                            Text(text = "$progressReal")
                            estadoProgressBtnIncrese = progressReal < 1f
                            estadoProgressBtnDecrese = progressReal > 0.1f
                        }*/

                        var nom1 by rememberSaveable { mutableStateOf("Erich") }
                        var nom2 by rememberSaveable { mutableStateOf("Ezequiel") }
                        var nom3 by rememberSaveable { mutableStateOf("Schnell") }
                        var nom4 by rememberSaveable { mutableStateOf("Josue") }
                        MyCheckBoxWithText(nom1)
                        MyCheckBoxWithText(nom2)
                        MyCheckBoxWithText(nom3)
                        MyCheckBoxWithText(nom4)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComponentsCatalogTheme {
        MySwitch()
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
