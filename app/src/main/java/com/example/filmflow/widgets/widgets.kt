package com.example.filmflow.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.filmflow.model.Movie

@Composable
fun CreateMovieList(moviesName: Movie, onClickItem : (String) -> Unit = {  })
{
    var expanded by remember{
        mutableStateOf(false)
    }
    Card(modifier =
    Modifier
        .fillMaxWidth()
        .padding(8.dp)
//        .height(100.dp)
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
//                AsyncImage(model = moviesName.poster, contentDescription = "Movie Image")
                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = moviesName.poster)
                        .apply(block = fun ImageRequest.Builder.() {
                            crossfade(true)
                            transformations(CircleCropTransformation())
                        }).build()
                )
                Image(
                    painter = painter,
                    contentDescription = "Movie Image",
                )

            }
                Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = moviesName.title,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Medium, // Adjust fontWeight as needed
                        fontSize = 20.sp // Adjust fontSize as needed
                    ),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = moviesName.director,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal, // Adjust fontWeight as needed
                        fontSize = 14.sp // Adjust fontSize as needed
                    ),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = moviesName.year.toString(),
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal, // Adjust fontWeight as needed
                        fontSize = 14.sp // Adjust fontSize as needed
                    ),
                    textAlign = TextAlign.Start,
                )
                    AnimatedVisibility(visible = expanded) {
                        Column {
                            Text(buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Genre: ")
                                }
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                                    append(moviesName.genre.joinToString())
                                }
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("\nRating: ")
                                }
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                                    append(moviesName.rating.toString())
                                }
                            })
                        }
                    }
                    
                    
                    Icon(imageVector = if(expanded) Icons.Filled.KeyboardArrowUp
                        else Icons.Filled.KeyboardArrowDown, contentDescription = "Expand Info",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { expanded = !expanded },
                        tint = Color.White)
            }
        }
    }
}