package com.example.githubreposapp

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReposeScreen(modifier: Modifier = Modifier) {
}

@Preview(showBackground = true)
@Composable
fun PreviewReposeItems() {
    ReposeItems(
        reposeDate = ReposeDate(
            "Sample Title",
            "Sample Subtitle",
            "This is a sample description"
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReposeItems(reposeDate: ReposeDate) {
    Column {
        TopAppBar(
            title = {
                Text(
                    "Github Repositories", modifier = Modifier.padding(start = 60.dp),
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            },

            )
        Card(
            modifier = Modifier.padding(14.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(contentColor = MaterialTheme.colorScheme.background)
        ) {
            Row {
                ReposeIcon(Icons.Filled.AccountCircle, Modifier.weight(0.10f), "Repository Icon")
                ReposeDetails(date = reposeDate, modifier = Modifier.weight(0.70f))
                ReposeIcon(Icons.Filled.Star, Modifier.weight(0.20f), "Star Icon", "16971")

            }
        }
    }


}

@Composable
fun ReposeDetails(
    date: ReposeDate,
    modifier: Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,

        ) {
        Text(text = date.title, style = MaterialTheme.typography.titleSmall, color = Color.Black)
        Text(text = date.supTitle, style = MaterialTheme.typography.bodyMedium, color = Color.Black)
        Text(
            text = date.description,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }
}

@Composable
fun ReposeIcon(
    icon: ImageVector,
    modifier: Modifier,
    description: String,
    evaluation: String = ""
) {
    Row(modifier = modifier) {
        Text(text = evaluation, color = Color.Black)
        Image(
            imageVector = icon, contentDescription = description, modifier = Modifier
                .padding(5.dp, 0.dp, 0.dp, 0.dp)
                .size(20.dp)
        )


    }

}

@Preview(showBackground = true)
@Composable
fun PreviewReposeScreen() {
    ReposeScreen()
}
