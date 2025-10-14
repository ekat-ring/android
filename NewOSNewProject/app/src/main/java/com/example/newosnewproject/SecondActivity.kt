package com.example.newosnewproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.*
import androidx.activity.compose.setContent
import androidx.appcompat.widget.Toolbar
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.jvm.java
/*
class SecondActivity :  ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
               Scaffold (modifier = Modifier.fillMaxSize()) {innerPadding ->
                   Screen("Katey", modifier = Modifier.padding(innerPadding))
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(name: String, modifier: Modifier) {
    Column() {
        TopAppBar(
            title = { Text(text = "NewOSNewProject") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Login successful, $name!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .align(Alignment.CenterHorizontally)
        )
        Image(
            painter = painterResource(id = R.drawable.login),
            modifier = Modifier.fillMaxWidth(),
            contentDescription = "Test Image"
        )
        BackButton()
    }
}
@Composable
fun BackButton() {
    val context: Context = LocalContext.current
    Button(onClick = {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)

    },
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp),
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()) {
                    Text("Back")
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
*/