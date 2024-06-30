package com.example.azkarelmslam

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.azkarelmslam.ui.theme.AzkarElmslamTheme

@Composable
fun VMGeneralScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(listGenreAskar) { askar ->
            ItemGeneral(askar) {
                navController.navigate(Screen.AyatAlKursiScreen.route)
            }
        }
    }
}

@Composable
fun ItemGeneral(askar: DataProject, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = askar.backGroundColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(14.dp)
        ) {
            AskarItem(askar.icon, Modifier.weight(0.25f))
            AskerDetails(askar.name, Modifier.weight(0.75f))
        }
    }
}

@Composable
fun AskerDetails(name: String, modifier: Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun AskarItem(vector: ImageVector, modifier: Modifier) {
    Icon(
        imageVector = vector,
        contentDescription = "Askar Icon",
        modifier = modifier
            .padding(8.dp)
            .size(40.dp),
        tint = Color.Black
    )
}

@Preview(showBackground = true)
@Composable
fun _GeneralScreen() {
    AzkarElmslamTheme {
        VMGeneralScreen(rememberNavController())
    }
}
