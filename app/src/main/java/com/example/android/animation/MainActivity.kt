package com.example.android.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.animation.ui.theme.AnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BoxAnimation()
                }
            }
        }
    }
}

@Composable
fun BoxAnimation(modifier: Modifier = Modifier) {
    var boxSize by remember {
        mutableStateOf(200.dp)
    }

    val size by animateDpAsState(targetValue = boxSize)0

    Card(modifier = modifier.size(50.dp)) {
        Box (modifier = Modifier
            .size(size)
            .background(Color.Red),
            contentAlignment = Alignment.Center){

            Button(onClick = { boxSize += 50.dp}) {
                Text(text = "Increase Box Size")
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun BoxAnimationPreview() {
    AnimationTheme {
        BoxAnimation()
    }
}