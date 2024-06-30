package com.example.viewmodel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun AskarScreen() {
val vm :AskarViewModel = viewModel()
    val state by rememberSaveable {
        mutableStateOf(vm.getModelAskar())
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(state) { askar ->
            CardAskerDetails(askar)
        }
    }
}

@Composable
fun CardAskerDetails(askar: DataAskar) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .background(Color(0xFF222222))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DetailsAskar(askar.text)
            ButtonsAskar(askar.share, askar.repeat)
        }
    }
}

@Composable
fun ButtonsAskar(buttonShare: String, repeat: String) {
    var count by remember { mutableStateOf(100) }

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(top = 16.dp)
            .background(Color(0xFFF2EDEF))
    ) {
        Button(
            onClick = {

                      },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF3EEF0)),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(text = buttonShare, color = Color.Black)
        }
        Button(
            onClick = { count-- },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF3EEF0)),
            modifier = Modifier.padding(5.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "($count)", color = Color.Black,modifier = Modifier.padding(5.dp))
                Text(text = repeat, color = Color.Black,modifier = Modifier.padding(5.dp))

            }
        }
    }
}

@Composable
fun DetailsAskar(text: String) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color.DarkGray,
        modifier = Modifier.padding(top = 8.dp,start = 10.dp,end = 10.dp))
}

@Preview(showBackground = true)
@Composable
fun AskarScreenPreview() {
    AskarScreen()
}
