package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.presentation.login.LoginScreen
import com.example.compose.presentation.registration.RegistrationScreen
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                View()
            }
        }
    }
}

@Preview
@Composable
fun View() {
//    LoginScreen()
    RegistrationScreen()
}


