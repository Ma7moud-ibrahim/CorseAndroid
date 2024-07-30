package com.example.listview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GymsDetailsScreen() {
    val viewModel: GymsDetailsViewModel = viewModel()
    val item = viewModel.state.value

    item?.let {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            DefaultIcon(
                icon = Icons.Filled.Place,
                modifier = Modifier.padding(2.dp).fillMaxSize(0.2f),
                contentDescription = "Location Icon"
            )
            GymDetails(
                gym = it,
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            Text(
                text = if (item.isOpen) "Gym is Open" else "Gym is Closed",
                color = if (item.isOpen) Color.Green else Color.Red
            )
        }
    }
}
