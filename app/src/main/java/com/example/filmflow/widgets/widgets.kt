package com.example.filmflow.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.filmflow.model.Movie

@Composable
fun CreateMovieList(moviesName: Movie, onClickItem : (String) -> Unit = {  })
{
    Card(modifier =
    Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .fillMaxWidth()
        .height(100.dp)
        .background(Color.White)
        .clickable { onClickItem(moviesName.id) }
        , shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically){
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(80.dp),
                shape = RectangleShape,
                shadowElevation = 8.dp) {
//                Icon(imageVector = Icons.Default.AccountBox,
//                    contentDescription = "Movie Image")
                AsyncImage(model = moviesName.poster, contentDescription = "Movie Image")
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = moviesName.title,
                    style = TextStyle(color = Color.White, fontStyle = MaterialTheme.typography.displayMedium.fontStyle),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = moviesName.director,
                    style = TextStyle(color = Color.White, fontStyle = MaterialTheme.typography.labelSmall.fontStyle),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = moviesName.year.toString(),
                    style = TextStyle(color = Color.White, fontStyle = MaterialTheme.typography.labelSmall.fontStyle),
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}