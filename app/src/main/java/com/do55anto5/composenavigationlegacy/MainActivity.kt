package com.do55anto5.composenavigationlegacy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.do55anto5.composenavigationlegacy.ui.theme.ComposeNavigationLegacyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationLegacyTheme {
            }
        }
    }
}
