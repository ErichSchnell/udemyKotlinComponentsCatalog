package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun ScaffoldViewExample(){
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar(
                onClickIcon = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Presionaste $it")
                    }
                },
                onClickDrawer = {
                    coroutineScope.launch {
                            scaffoldState.drawerState.open()
                    }
                }
        ) },
        bottomBar = { MyBottonNavegation() },
        floatingActionButton = { MyFAB()},
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        drawerContent = {
            MyDrawer(){
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        },
        drawerGesturesEnabled = false,
        scaffoldState = scaffoldState
    ) {}
}

@Composable
fun MyBottonNavegation(){
    var index by remember{mutableStateOf(0)}
    BottomNavigation(
        backgroundColor = Color.Red,
        contentColor = Color.White
    ) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0}, icon = {
            Icon(imageVector = Icons.Default.Home,
                contentDescription = "home")
        }, label = { Text(text = "Home")})

        BottomNavigationItem(selected = index == 1, onClick = {index = 1}, icon = {
            Icon(imageVector = Icons.Default.Favorite,
                contentDescription = "favorite")
        }, label = { Text(text = "Favorite")})

        BottomNavigationItem(selected = index == 2, onClick = {index = 2}, icon = {
            Icon(imageVector = Icons.Default.Person,
                contentDescription = "person")
        }, label = { Text(text = "Person")})
    }
}

@Composable
fun MyTopAppBar(onClickIcon:(String) -> Unit, onClickDrawer:() -> Unit){
    TopAppBar(
        title = { Text(text = "Mi primer TopAppBar") },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 8.dp,
        navigationIcon = {
           IconButton(onClick = { onClickDrawer() }) {
               Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu" )
           }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search" )
            }
            IconButton(onClick = { onClickIcon("Add") }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "add" )
            }
        },
    )
}

@Composable
fun MyFAB(){
    FloatingActionButton(
        backgroundColor = Color.Yellow,
        contentColor = Color.Black,
        onClick = {}) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit){
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "Primera Option", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Text(text = "Segunda Option", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Text(text = "Tercera Option", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Text(text = "Cuarta Option", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Text(text = "Quinta Option", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Cerrar", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {onCloseDrawer()})
    }
}