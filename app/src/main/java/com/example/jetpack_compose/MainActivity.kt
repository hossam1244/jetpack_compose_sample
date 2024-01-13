package com.example.jetpack_compose

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Surface(modifier = Modifier.padding(horizontal = 20.dp)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Spacer(modifier = Modifier.height(40.dp))
                            usernameField()
                            Spacer(modifier = Modifier.height(16.dp))
                            passwordField()
                            Spacer(modifier = Modifier.height(40.dp))
                            loginButton()
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun usernameField() {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        placeholder = { Text("Username") },
        onValueChange = ({
            print("Username: $it")
        })
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun passwordField() {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        placeholder = { Text("Password") },
        onValueChange = ({
            print("Password: $it")
        })
    )
}




@Composable
fun loginButton() {
    val context = LocalContext.current
    Surface(modifier = Modifier.padding(20.dp)) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            onClick = {
                  context.startActivity(Intent(context, ActivityList::class.java))
            }
        )
        {
            Text(text = "Login", color = Color.White)
        }
    }
}

