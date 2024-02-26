package com.example.filmflow.model

import com.google.gson.Gson
import java.io.File

data class Movie(val id: String,
                val title: String,
                val year : Int,
                val genre: List<String>,
                val rating: Float,
                val plot: String,
                val actors: List<String>
                )

fun getMovies(): List<Movie> {
    //return a list of movies with data from a json file
    //json file name is data.json
    val gson = Gson()
    val jsonString = File("data.json").readText(Charsets.UTF_8)
    return gson.fromJson(jsonString, Array<Movie>::class.java).toList()
}
