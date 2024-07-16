package com.marlonncarvalhosa.climafcil.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.marlonncarvalhosa.climafcil.presentation.ui.screens.WeatherScreen
import com.marlonncarvalhosa.climafcil.presentation.ui.theme.ClimaFácilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClimaFácilTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    WeatherScreen()
                }
            }
        }
    }
}