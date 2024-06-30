package com.example.azkarelmslam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.azkarelmslam.ui.theme.AzkarElmslamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AzkarElmslamTheme {
                Navigation()
            }
        }
    }
}
