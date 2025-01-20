package org.example.classes

import java.util.Date

data class Game(val title: String, val genre: String, val price: Double, val releaseDate: Date) {
    init {
        if (title.isBlank() || genre.isBlank() || price < 0 ) {
            throw IllegalArgumentException("Invalid arguments")
        }
    }
}
