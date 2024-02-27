package com.example.filmflow.model

import com.google.gson.Gson


data class MovieResponse(val films: List<Movie>)

val jsonData = """
    {
      "films": [
        {
          "id": "1",
          "title": "The Shawshank Redemption",
          "director": "Frank Darabont",
          "year": 1994,
          "genre": ["Drama"],
          "rating": 9.3,
          "plot": "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
          "actors": ["Tim Robbins", "Morgan Freeman"],
            "poster": "https://upload.wikimedia.org/wikipedia/en/8/81/ShawshankRedemptionMoviePoster.jpg"
        },
        {
          "id": "2",
          "title": "The Godfather",
          "director": "Francis Ford Coppola",
          "year": 1972,
          "genre": ["Crime", "Drama"],
          "rating": 9.2,
          "plot": "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
          "actors": ["Marlon Brando", "Al Pacino"],
            "poster": "https://upload.wikimedia.org/wikipedia/en/1/1c/Godfather_ver1.jpg"
        },
        {
          "id": "3",
          "title": "The Dark Knight",
          "director": "Christopher Nolan",
          "year": 2008,
          "genre": ["Action", "Crime", "Drama"],
          "rating": 9.0,
          "plot": "When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.",
          "actors": ["Christian Bale", "Heath Ledger"],
           "poster": "https://upload.wikimedia.org/wikipedia/en/1/1c/The_Dark_Knight_%282008_film%29.jpg"
        },
        {
          "id": "4",
          "title": "The Godfather: Part II",
          "director": "Francis Ford Coppola",
          "year": 1974,
          "genre": ["Crime", "Drama"],
          "rating": 9.0,
          "plot": "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.",
          "actors": ["Al Pacino", "Robert De Niro"],
          "poster": "https://upload.wikimedia.org/wikipedia/en/0/03/Godfather_part_ii.jpg"
        },
        {
          "id": "5",
          "title": "12 Angry Men",
          "director": "Sidney Lumet",
          "year": 1957,
          "genre": ["Drama"],
          "rating": 8.9,
          "plot": "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.",
          "actors": ["Henry Fonda", "Lee J. Cobb"],
            "poster": "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/12_Angry_Men_%281957_film_poster%29.jpg/330px-12_Angry_Men_%281957_film_poster%29.jpg"
        },
        {
          "id": "6",
          "title": "Schindler's List",
          "director": "Steven Spielberg",
          "year": 1993,
          "genre": ["Biography", "Drama", "History"],
          "rating": 8.9,
          "plot": "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.",
          "actors": ["Liam Neeson", "Ben Kingsley"],
            "poster": "https://upload.wikimedia.org/wikipedia/en/3/38/Schindler%27s_List_movie.jpg"
        },
        {
          "id": "7",
          "title": "The Lord of the Rings: The Return of the King",
          "director": "Peter Jackson",
          "year": 2003,
          "genre": ["Adventure", "Drama", "Fantasy"],
          "rating": 8.9,
          "plot": "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
          "actors": ["Elijah Wood", "Viggo Mortensen"],
            "poster": "https://upload.wikimedia.org/wikipedia/en/2/23/The_Lord_of_the_Rings%2C_TROTK_%282003%29.jpg"
        },
        {
          "id": "8",
          "title": "Pulp Fiction",
          "director": "Quentin Tarantino",
          "year": 1994,
          "genre": ["Crime", "Drama"],
          "rating": 8.9,
          "plot": "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
          "actors": ["John Travolta", "Uma Thurman"],
            "poster": "https://upload.wikimedia.org/wikipedia/en/3/3b/Pulp_Fiction_%281994%29_poster.jpg"
        },
        {
          "id": "9",
          "title": "The Good, the Bad and the Ugly",
          "director": "Sergio Leone",
          "year": 1966,
          "genre": ["Western"],
          "rating": 8.8,
          "plot": "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.",
          "actors": ["Clint Eastwood", "Eli Wallach"],
            "poster": "https://upload.wikimedia.org/wikipedia/en/4/45/Good_the_bad_and_the_ugly_poster.jpg"
        }
      ]
    }

""".trimIndent()
data class Movie(
    val id: String,
    val title: String,
    val director: String,
    val year: Int,
    val genre: List<String>,
    val rating: Float,
    val plot: String,
    val actors: List<String>,
    val poster: String
)


fun getMovies(): List<Movie> {
    val gson = Gson()
    val movieResponse = gson.fromJson(jsonData, MovieResponse::class.java)
    return movieResponse.films.map {
        Movie(
            it.id,
            it.title,
            it.director,
            it.year,
            ArrayList(it.genre),
            it.rating,
            it.plot,
            ArrayList(it.actors),
            it.poster
        )
    }
}

