package com.example.githubreposapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubreposapp.ui.theme.Typography

@Composable
fun ReposeDetails(modifier: Modifier = Modifier) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyScreenDetails(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TopAppBar(
            title = {
                Text(
                    "Details", modifier = Modifier.padding(start = 80.dp),
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = { /* Handle navigation back */ }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        )
        IconWithText(imageVector = Icons.Filled.AccountCircle, language = "Language")
        Row {
            StatsRow(stars = 1525, forks = 347, language = "Python")
        }
        Text(
            text = "Shared repository for open-sourced projects from the Google Al Language team.",
            maxLines = 2,
            modifier = Modifier.padding(30.dp)
        )

    }
}

@Composable
fun IconWithText(imageVector: ImageVector, language: String) {
    Column {
        Image(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "description",
            alignment = Alignment.Center,
            modifier = Modifier.size(240.dp)
        )
        Text(
            text = "Language",
            modifier = Modifier.padding(start = 80.dp, bottom = 20.dp),
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun StatsRow(stars: Int, forks: Int, language: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icons(icon = Icons.Filled.Star, text = stars.toString())
        Icons(icon = Icons.Filled.Info, text = language)
        Icons(icon = Icons.Filled.Star, text = forks.toString())
    }
}

@Composable
fun Icons(icon: ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = text,
            modifier = Modifier.padding(end = 3.dp)
        )
        Image(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 15.dp)
        )
    }
}

