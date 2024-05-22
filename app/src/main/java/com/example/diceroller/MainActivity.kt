package com.example.diceroller

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}
@Preview
@Composable
fun DiceRollerApp() {
    var selection by remember {
        mutableStateOf(0)
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {selection = 1}) {
            Text(stringResource(R.string.roll))
        }
        Button(onClick = {selection = 2}) {
            Text(stringResource(R.string.roll2))
        }
    }
    if (selection == 1) {
        DiceWithButtonAndImage(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
    } else if (selection == 2) {
        TwoDices(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
    }

}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random()}) {
            Text(stringResource(R.string.roll))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Image(painter = painterResource(R.drawable.see), contentDescription = "viewResult")
        Text(text = "The result is " + result.toString())
    }
}

@Composable
fun TwoDices(modifier: Modifier=Modifier) {
    var result by remember { mutableStateOf(1) }
    var imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    var result2 by remember { mutableStateOf(1) }
    var imageResource2 = when (result2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString())
        Image(
            painter = painterResource(imageResource2),
            contentDescription = result2.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random(); result2 =(1..6).random() }) {
            Text(stringResource(R.string.roll2))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Image(painter = painterResource(R.drawable.see), contentDescription = "viewResult")
        Text(text = "The result is " + (result+result2).toString())
    }
}