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
                        var myTextField1 by rememberSaveable { mutableStateOf("") }
                        var myTextFieldAdvance1 by rememberSaveable { mutableStateOf("") }
                        var myOutLinedTextField1 by rememberSaveable { mutableStateOf("") }
                        var estado by rememberSaveable { mutableStateOf(true) }

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

                        MyProgress()
                        MyImage()
                        MyImageAdvance()

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
        MyIcon()
    }
}

@Composable
fun MyProgress(){
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
