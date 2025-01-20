package org.example.utils

import org.example.controller.GameController

class Menu() {

    private val GameController = GameController()


    fun startMenu(){

        while(true) {
            println("---- BIENVENIDO ----")
            println("1 - AÑADIR JUEGO")
            println("2 - BUSCAR JUEGO")
            println("3 - OBTENER JUEGOS POR GÉNERO")
            println("4 - MODIFICAR JUEGO")
            println("5 - ELIMINAR JUEGO")
            println("6 - SALIR")
            print("¿Qué desea hacer? > ")
            val decision = readln()

            when(decision) {
                "1" -> {
                    GameController.CreateGame()
                    println()
                }
                "2" -> {
                    println(GameController.GetGame())
                    println()
                }
                "3" -> {
                    val games = GameController.GetByGenre()
                    games.forEach { println(it) }
                    println()
                }
                "4" -> {
                    GameController.UpdateGame()
                    println()
                }
                "5" -> {
                    GameController.DeleteGame()
                    println()
                }
                "6"-> break
                else -> {
                    println("Opción no válida.")
                    println()
                }
            }
        }


    }

}