package com.example.dicerollerapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicerollerapp.ui.theme.DiceRollerAppTheme
//import kotlinx.coroutines.NonCancellable.message

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   DiceRollerApp()
                }
            }
        }
    }
}
@Preview
@Composable
fun DiceRollerApp (){
    TextIn(message= stringResource(R.string.mess))
    DiceWithImageAndButton(modifier= Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
        .padding(start = 16.dp))
}

@Composable
fun TextIn(message: String ) {
    Column() {
        Text(text= stringResource(R.string.mess), fontSize=80.sp, color= Color.DarkGray,
        modifier= Modifier.fillMaxWidth()
            .wrapContentWidth(align= Alignment.CenterHorizontally)
            .padding(start=0.3.dp,top=20.dp))
    }
}
@Composable
fun DiceWithImageAndButton(modifier: Modifier= Modifier) {
    var result by remember {
        mutableStateOf(1)
    }
    val imageResource: Int = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource), contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(text = stringResource(R.string.roll),color= Color.Black, fontSize = 50.sp)
        }
    }
}
