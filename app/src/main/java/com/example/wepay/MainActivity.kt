package com.example.wepay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.wepay.data.DataSource
import com.example.wepay.graphs.RootNavigationGraph
import com.example.wepay.ui.theme.WePayTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WePayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    //OnBoardScreen()
                    //SkipScreen()
                    RootNavigationGraph(navController = rememberNavController())

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    WePayTheme {
        //OnBoardScreen()
        //SkipScreen()
    }
}