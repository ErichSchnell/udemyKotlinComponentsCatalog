package com.example.jetpackcomponentscatalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import org.w3c.dom.Text

@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Title") },
            text = { Text(text = "Mensseged of Alert") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Acept")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Close")
                }
            }
        )
    }
}

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un dialogo")
                Text(text = "Esto es un dialogo")
                Text(text = "Esto es un dialogo")
            }
        }
    }

}

@Composable
fun MyAdvanceCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show){
        Dialog(
            onDismissRequest = { onDismiss() },
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog("Set backoup account")
                AccountItem("ejemplo@gmail.com", R.drawable.avatar)
                AccountItem("ejemplo1@gmail.com", R.drawable.avatar)
                AccountItem("Añadir nueva cuenta", R.drawable.add)
            }
        }
    }


}

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit
){
    if (show){
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                MyTitleDialog(data = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), Color.LightGray)

                Column() {
                    val listaDeComponentes = getListRadioButton(
                        titles = listOf("Erich","josue","Pedro","Juan","Rodolfo","Mengano","Julio","Marta","Anastacio","Perico")
                    )
                    listaDeComponentes.forEach {
                        MyRadioButtonList(checkRadioButton = it)
                    }
                }

                Divider(Modifier.fillMaxWidth(), Color.LightGray)

                Row(
                    Modifier
                        .align(Alignment.End)
                        .padding(8.dp)) {
                    TextButton(onClick = { onDismiss() }) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = {  }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}
@Composable
fun AccountItem(email:String, @DrawableRes drawable:Int){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyTitleDialog(data:String, modifier: Modifier = Modifier.padding(bottom = 12.dp)){
    Text(
        text = data,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}