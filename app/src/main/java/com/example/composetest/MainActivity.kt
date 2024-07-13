package com.example.composetest

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composetest.ui.theme.ComposeTestTheme

val TAG = MainActivity::class.java.name

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )

                    LoginView()

                }
            }
        }
    }
}

@Composable
fun LoginView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(start = 40.dp, top = 20.dp, end = 40.dp)
    ) {
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = R.drawable.black_back),
            contentDescription = "backIcon"
        )


        Text(
            modifier = Modifier.padding(top = 50.dp),
            text = "Welcome\nPlay Android",
            fontSize = 24.sp,
            color = Color.Black
        )
        var name by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            placeholder = {
                Text(text = ("Enter your name value"))
            },
            maxLines = 1,
            //是否是错误的
            isError = false,
            modifier = Modifier
                .padding(top = 200.dp)
                .fillMaxWidth()
        )


        var password by remember { mutableStateOf(TextFieldValue("")) }
        var passwordVisibility: Boolean by remember { mutableStateOf(false) }
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = {
                Text(text = ("Enter your password value"))
            },
            maxLines = 1,
            //是否是错误的
            isError = false,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val bitmap = if (passwordVisibility)
                    ImageBitmap.imageResource(id = R.drawable.unlock)
                else
                    ImageBitmap.imageResource(id = R.drawable.lock)
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            passwordVisibility = !passwordVisibility
                        },
                    bitmap = bitmap, contentDescription = "lock"
                )
            }
        )


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
        LoginView()
    }
}