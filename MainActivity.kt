package com.example.cs360_projectone_inventoryapp_rx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material3.MaterialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {  // Wrap your screen in a MaterialTheme
                DataGridScreen()
            }
        }
    }
}

@Preview(showBackground = true) // Added Preview annotation here
@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") } // ← Add this line
    var passwordVisible by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }


    Column(
        Modifier.fillMaxSize().padding(16.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(64.dp)) // Added Spacer
        Text(
            text = " Inventory Application",
            style = MaterialTheme.typography.headlineMedium // Apply header style
        )
        Spacer(modifier = Modifier.height(32.dp)) // Added Spacer
        Text("Login") // Basic Text for title

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                message = "Login: $username / $password" // Basic message
            },
            Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        OutlinedButton(
            onClick = {
                message = "Create: $username / $password" // Basic message
            },
            Modifier.fillMaxWidth()
        ) {
            Text("Create Account")
        }

        if (message.isNotEmpty()) {
            Spacer(Modifier.height(8.dp))
            Text(message) // Display message without styling
        }
    }
}