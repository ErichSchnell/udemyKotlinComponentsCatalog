package com.example.jetpackcomponentscatalog

import android.opengl.Visibility
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun ColorAnimationBasic(){
    Column {
        var firstColor by rememberSaveable { mutableStateOf(false)}
        var showBox by rememberSaveable{ mutableStateOf(true) }
        val realColor by animateColorAsState(
            targetValue = if(firstColor) Color.Red else Color.Yellow,
            animationSpec = tween(durationMillis = 1000),
            finishedListener = {showBox = false}
        )
        if(showBox){
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(realColor)
                    .clickable { firstColor = !firstColor }
            )
        }
    }
}

@Composable
fun SizeAnimation(){
    Column {
        var showBox by rememberSaveable{ mutableStateOf(true) }
        var showBox2 by rememberSaveable{ mutableStateOf(true) }

        var smallSize by rememberSaveable { mutableStateOf(true)}
        var size = if (smallSize) 100.dp else 200.dp
        if (showBox){
            Box(
                modifier = Modifier
                    .size(size)
                    .background(Color.Red)
                    .clickable {
                        smallSize = !smallSize
                        showBox2 = !showBox2
                    }
            )
        }
        Spacer(modifier = Modifier.size(200.dp))

        var smallSize2 by rememberSaveable { mutableStateOf(true)}
        val size2 by animateDpAsState(
            targetValue = if (smallSize2) 100.dp else 200.dp,
            animationSpec = tween(durationMillis = 500),
            finishedListener = {showBox = !showBox}
        )
        if (showBox2){
            Box(
                modifier = Modifier
                    .size(size2)
                    .background(Color.Cyan)
                    .clickable { smallSize2 = !smallSize2 }
            )
        }
    }
}


@Composable
fun VisibilityAnimation(){
    Column {
        var stateBox by rememberSaveable { mutableStateOf(true) }

        Button(onClick = { stateBox = !stateBox}) {
            Text(text = "Presioname!")
        }

        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(
            stateBox,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                Modifier
                    .size(200.dp)
                    .background(Color.Cyan))
        }

    }
}

@Composable
fun CrossfadeAnimation(){
    var myComponentType: ComponentType by remember{ mutableStateOf(ComponentType.Text) }
    Column(Modifier.fillMaxSize()) {

        Button(onClick = {myComponentType = getComponentTypeRandom()}) {
            Text(text = "Cambiar Componente")
        }
        
        Crossfade(targetState = myComponentType) {
            when(it){
                ComponentType.Image -> Icon(Icons.Default.Share, contentDescription = "share")
                ComponentType.Text -> Text(text = "soy un componente")
                ComponentType.Box -> Box(modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red))
                ComponentType.Error -> Text(text = "error")
            }
        }

    }
}

fun getComponentTypeRandom(): ComponentType {
    return when(nextInt(from = 0, until = 3)){
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}

enum class ComponentType(){
    Image, Text, Box, Error
}