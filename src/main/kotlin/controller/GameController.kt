package org.example.controller

import org.example.classes.Game
import org.example.services.GameService
import java.text.SimpleDateFormat
import java.util.Date

class GameController() {

    private val gameService = GameService()


    fun CreateGame(){

        var title = ""
        var genre = ""
        var price: Double? = null
        var releaseDate: Date? = null

        while(title == ""){
            print("Ingrese el título del juego > ")
            title = readln()
            println()
            if(title == "" || title == " "){
                println("Título no válido.")
            }
            println()
        }
        while(genre == ""){
            print("Ingrese el género del juego > ")
            genre = readln()
            println()
            if(genre == "" || genre == " "){
                println("Género no válido.")
            }
            println()
        }
        while(price == null){
            print("Ingrese el precio del juego > ")
            price = readln().toDoubleOrNull()
            println()
            if (price == null){
                println("Precio no válido.")
            }
            println()
        }
        while(releaseDate == null){
            try {
                val dateFormat = SimpleDateFormat("dd/MM/yyyy")
                print("Ingrese la fecha de salida del juego (DD/MM/AAAA) > ")
                releaseDate = dateFormat.parse(readln())
                println()
            }
            catch(e: Exception){
                println("Fecha no válida.")
            }
            println()
        }

        return gameService.CreateGame(Game(title,genre,price,releaseDate))
    }

    fun UpdateGame(): Game {

        var title = ""
        var genre = ""
        var price: Double? = null
        var releaseDate: Date? = null

        while(title == ""){
            print("Ingrese el título del juego > ")
            title = readln()
            println()
            if(title == "" || title == " "){
                println("Título no válido.")
            }
            println()
        }
        while(genre == ""){
            print("Ingrese el género del juego > ")
            genre = readln()
            println()
            if(genre == "" || genre == " "){
                println("Género no válido.")
            }
            println()
        }
        while(price == null){
            print("Ingrese el precio del juego > ")
            price = readln().toDoubleOrNull()
            println()
            if (price == null){
                println("Precio no válido.")
            }
            println()
        }
        while(releaseDate == null){
            try {
                val dateFormat = SimpleDateFormat("dd/MM/yyyy")
                print("Ingrese la fecha de salida del juego (DD/MM/AAAA) > ")
                releaseDate = dateFormat.parse(readln())
                println()
            }
            catch(e: Exception){
                println("Fecha no válida.")
            }

        }

        val updatedGame = Game(title,genre,price,releaseDate)
        return gameService.UpdateGame(updatedGame)

    }

    fun GetGame(): Game {
        var title = ""
        while(title == ""){
            print("Ingrese el título del juego > ")
            title = readln()
            println()
            if(title == "" || title == " "){
                println("Título no válido.")
            }
            println()
        }
        return gameService.GetGame(title)
    }


    fun GetByGenre(): List<Game> {
        var genre = ""
        while(genre == ""){
            print("Ingrese el género del juego > ")
            genre = readln()
            println()
            if(genre == "" || genre == " "){
                println("Género no válido.")
            }
            println()
        }
        return gameService.GetByGenre(genre)
    }

    fun DeleteGame(){
        var genre = ""
        while(genre == ""){
            print("Ingrese el género del juego > ")
            genre = readln()
            println()
            if(genre == "" || genre == " "){
                println("Género no válido.")
            }
            println()
        }
        return gameService.DeleteGame(genre)
    }


}
