package com.example.blocksofcomposeui

import android.os.Bundle
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blocksofcomposeui.ui.theme.BlocksOfComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}
@Preview(showBackground = true)
@Composable
fun MyBox(
) {
    Box(
        modifier = Modifier
            .size(120.dp)
            .background(Color.Black)
            .padding(12.dp)
            .clip(RoundedCornerShape(size = 10.dp))
            .background(Color.LightGray)

    ) {
        Text(text = "Hello", modifier = Modifier.align(Alignment.TopStart), color = Color.White)
        Text(text = "World" , modifier = Modifier.align(Alignment.Center) , color = Color.White)
        Text(text = "Everyone" , color = Color.White , modifier = Modifier.align(Alignment.BottomEnd))
    }
}
@Composable
fun MyList(){

}

@Preview(showBackground = true)
@Composable
fun MyLayout() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyText()
        MyButton()

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Hello")
            MyImage()

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyText() {
    Text(
        text = "Hello Everyone How Are You!?",
        style = TextStyle(
            color = Color.Red,
            background = Color.Yellow,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
        ),
        maxLines = 2,
    )
}

@Preview(showBackground = true)
@Composable
fun MyButton() {
    var isEnable by remember { mutableStateOf(true) }
    Button(
        onClick = { isEnable = !isEnable },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isEnable) Color.Green else Color.Red,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Black
        ),
    ) {
        Text(text = if (isEnable) "Click Me" else "I'm Disabled")
    }
}

@Preview(showBackground = true)
@Composable
fun MyTextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = {
            Text(text = "Enter Your Name")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.downloadclinc),
        contentDescription = "My Image",
        alpha = 0.5f,
        modifier = Modifier.size(128.dp)
    )
}
