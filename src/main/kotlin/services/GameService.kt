package org.example.services

import com.mongodb.client.model.Filters
import org.bson.Document
import org.example.classes.Game
import org.example.database.DatabaseConnector

class GameService() {

    private val database = DatabaseConnector.getDatabase()
    private val collection = database.getCollection("Juegos")


    fun CreateGame(game: Game){
        try {
            val exists = GetGame(game.title)
            println("Este juego ya existe.")

        }
        catch (e: Exception){
            val document = Document(mutableMapOf("titulo" to game.title, "genero" to game.genre, "precio" to game.price, "fechaSalida" to game.releaseDate))

            collection.insertOne(document)
            println("${game.title} añadido correctamente.")

        }
    }

    fun UpdateGame(game: Game): Game {

        val nameFilter = Filters.eq("titulo", game.title)
        val exists = collection.find(nameFilter).firstOrNull()
        if(exists == null){
            throw Exception("Este juego no existe.")
        }
        else{
            val updateDocument = Document("\$set", mutableMapOf(
                "genero" to game.genre,
                "precio" to game.price,
                "fechaSalida" to game.releaseDate
            ))
            val result = collection.updateOne(nameFilter, updateDocument)

            if (result.modifiedCount > 0){
                println("${game.title} actualizado correctamente.")
            }
            else {
                println("${game.title} no ha sido actualizado.")
            }


            return game
        }
    }

    fun GetGame(gameName: String): Game {

        val nameFilter = Filters.eq("titulo", gameName)
        val exists = collection.find(nameFilter).firstOrNull()
        if(exists == null){
            throw Exception("Este juego no existe.")
        }
        else{
            return Game(exists.getString("titulo"),exists.getString("genero"),exists.getDouble("precio"),exists.getDate("fechaSalida"))
        }
    }

    fun GetByGenre(genre: String): List<Game> {
        val gameList = mutableListOf<Game>()
        val genreFilter = Filters.eq("genero", genre)
        collection.find(genreFilter).forEach {
            gameList.add(Game(it.getString("titulo"),it.getString("genero"),it.getDouble("precio"),it.getDate("fechaSalida")))
        }
        return gameList
    }

    fun DeleteGame(gameName: String){
        val nameFilter = Filters.eq("titulo", gameName)
        val exists = collection.find(nameFilter).firstOrNull()
        if(exists == null){
            throw Exception("Este juego no existe.")
        }
        else{
            val result = collection.deleteOne(exists)
            if (result.deletedCount > 0){
                println("$gameName borrado correctamente.")
            }
        }
    }

}
