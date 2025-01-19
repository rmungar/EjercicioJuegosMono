package org.example.database

import com.mongodb.client.MongoClients
import io.github.cdimascio.dotenv.dotenv

object DatabaseConnector {


    fun connect() {
        val dotenv = dotenv()
        val connectionString = dotenv["DB_NAME"]

        val client = MongoClients.create(connectionString)


    }


}