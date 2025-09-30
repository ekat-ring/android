package com.example.project30_09

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.*
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class SecondActivity :  ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
               Scaffold (modifier = Modifier.fillMaxSize()) {innerPadding ->
                    Greeting(
                        name = "K.",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        /*
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.button_second).setOnClickListener{
            val context: Context = this@SecondActivity
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)

         */
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Kate")
    }
}

@Composable
fun BackButton() {
    val context: Context = LocalContext.current
    Button(onClick = {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }) {
        Text("Filled")
    }
}

@Composable
fun MyApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}

fun lightColorPalette(
    primary: Color,
    onPrimary: Color,
    primaryVariant: Color,
    secondary: Color,
    onSecondary: Color,
    secondaryVariant: Color,
    surface: Color,
    onSurface: Color,
    error: Color,
    onError: Color
) {
}
