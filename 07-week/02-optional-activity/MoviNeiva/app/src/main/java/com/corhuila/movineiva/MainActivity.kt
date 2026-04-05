package com.corhuila.movineiva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.corhuila.movineiva.Navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviNeivaApp()
        }
    }
}

@Composable
fun MoviNeivaApp() {
    MaterialTheme {
        Surface {
            NavGraph()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoviNeivaApp()
}
