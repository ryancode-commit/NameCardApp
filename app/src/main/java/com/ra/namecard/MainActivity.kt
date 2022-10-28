package com.ra.namecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ra.namecard.ui.theme.NameCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun NameCardApp(){
    Column(
        modifier = Modifier
            .background(Color(0xff003A4A))
            .fillMaxSize()
            .padding(24.dp)
            ) {

        ProfileCard(image = painterResource(id = R.drawable.android_logo), title = "Ryan Ardyansyah" , job = "Android Developer")
        Divider(color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        InformationCard(icon = painterResource(id = R.drawable.ic_call), valueField = "085795617707" )
        Divider(color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        InformationCard(icon = painterResource(id = R.drawable.ic_share), valueField = "@rynvsn" )
        Divider(color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        InformationCard(icon = painterResource(id = R.drawable.ic_email), valueField = "ryanardyansyah17@gmail.com" )
        
    }
}

@Composable
fun ProfileCard(
    image: Painter,
    title : String,
    job : String
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.4f),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = image, contentDescription = null,Modifier.width(100.dp) )
        Text(text = title,fontSize = 24.sp, color = Color.White)
        Text(text = job, fontSize = 18.sp, color = Color(0xff40CD92))
    }
}

@Composable
fun InformationCard(icon:Painter,valueField : String){
    Row( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.1f)) {
        Image(painter = icon, contentDescription = null, modifier = Modifier.width(24.dp))
        Spacer(modifier = Modifier.width(32.dp))
        Text(text = valueField,fontSize = 16.sp, color = Color.White)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NameCardTheme {
        NameCardApp()
    }
}