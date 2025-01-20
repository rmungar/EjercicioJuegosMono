package org.example


import org.example.database.DatabaseConnector
import org.example.utils.Menu

fun main() {
    try {
        val mainMenu = Menu()

        mainMenu.startMenu()
    }
    catch (e: Exception) {
        println(e.message)
    }
    finally {
        DatabaseConnector.close()
    }
}