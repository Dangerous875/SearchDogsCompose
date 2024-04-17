package com.example.dogsearchcompose.ui.view.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.dogsearchcompose.ui.viewmodel.DogsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainDogScreen(viewModel: DogsViewModel) {
    Scaffold(
        topBar = { ToolBar() },
        content = { ContentView(viewModel) }
    )
}

@Composable
fun ContentView(viewModel: DogsViewModel) {
    val dogList by viewModel.lisDogs.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    var searchText by remember { mutableStateOf("") }

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 60.dp)
            ) {
                SearchView(
                    query = searchText,
                    onQueryChange = { searchText = it },
                    onSearch = { viewModel.getDogsByBreeds(searchText) }
                )

                LazyColumnWithImages(dogList)


            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    TextField(
        value = query,
        onValueChange = { onQueryChange(it) },
        placeholder = { Text(text = "Search...") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
//        trailingIcon = {
//            if (query.isNotEmpty()) {
//                IconButton(onClick = { onSearch() }) {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "Clear Icon"
//                    )
//                }
//            }
//        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { onSearch() }
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun LazyColumnWithImages(imageUrls: List<String>) {
    LazyColumn(modifier = Modifier.padding(horizontal = 8.dp)) {
        items(imageUrls) { imageUrl ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(250.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar() {
    TopAppBar(
        title = { Text(text = "MainDogScreen", color = Color.White, fontStyle = FontStyle.Italic) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.DarkGray
        )
    )
}
