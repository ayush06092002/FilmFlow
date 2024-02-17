package com.example.filmflow.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.filmflow.CreateMovieList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFe3f09b)
            ),
                title = {
                    Text(text = "Top Bar",
                        style = TextStyle(color = Color.Black)
                    )
                })
        }
    ){
        MainContent(navController = navController)
    }
}
@Composable
fun MainContent(navController: NavController,moviesList: List<String> = listOf(
    "The Shawshank Redemption",
    "The Godfather",
    "The Dark Knight",
    "The Godfather: Part II",
    "12 Angry",
    "Schindler's List",
    "The Lord of the Rings: The Return of the King",
    "Pulp Fiction",
    "The Good, the Bad and the Ugly",
)) {
    Surface(modifier = Modifier.padding(top = 60.dp),
        color = Color(0xFF87b6a7)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)){
            LazyColumn {
                items(moviesList.size) { index ->
                    CreateMovieList(moviesList[index]) {
                        Log.d("TAG", "MainContent: " + moviesList[index])
                    }
                }
            }
        }
    }
}
