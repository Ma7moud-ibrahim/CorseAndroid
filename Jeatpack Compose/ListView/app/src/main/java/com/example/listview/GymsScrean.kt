package com.example.listview

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalContentColor
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GymsScreen(onItemClick: (Int)->Unit) {
    //Insert The Data (Handling State)
    val vm: GymsViewModel = viewModel()
    LazyColumn {
        items(vm.state) { gym ->
            MyItem(
                gym = gym,
                onFavouriteIconClick = { vm.toggleFavouriteState(it) },
                onItemClick = { id -> onItemClick(id) })
        }
    }

//Column Iteration
    /*Column(Modifier.verticalScroll(rememberScrollState())) {
        ListOfGym.forEach{
            MyItem(it)
        }

    }*/
}

@Composable
fun MyItem(gym: Gym, onFavouriteIconClick: (Int) -> Unit, onItemClick: (Int)->Unit) {
    val iconColor = if (gym.isFavourite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClick(gym.id) },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            DefaultIcon(Icons.Filled.Place, Modifier.weight(0.15f),"Location Icon")
            GymDetails(gym, Modifier.weight(0.70f))
            DefaultIcon(iconColor,Modifier.weight(0.15f),"Favourite Icon"){
                onFavouriteIconClick(gym.id)
            }
        }
    }
}

@Composable
fun DefaultIcon(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    contentDescription: String,
    onClick: () -> Unit = {}
) {
    Image(
        imageVector = icon,
        contentDescription = contentDescription,
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() },
        colorFilter = ColorFilter.tint(Color.DarkGray)
    )
}

@Composable
fun GymDetails(gym: Gym, modifier: Modifier,horizontalAlignment: Alignment.Horizontal=Alignment.Start) {
    Column(modifier = modifier , horizontalAlignment = horizontalAlignment) {
        Text(
            text = gym.name,
            style = MaterialTheme.typography.titleMedium,
            color = Color.Blue
        )
        CompositionLocalProvider(LocalContentColor provides LocalContentColor.current) {
            Text(
                text = gym.place,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GymsScreenPreview() {
//    GymsScreen(vm = GymsViewModel(SavedStateHandle()))
//}

