package org.example.database

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import io.github.cdimascio.dotenv.dotenv

object DatabaseConnector {

    private val mongoClient: MongoClient by lazy {
        val dotenv = dotenv()
        val connectString = dotenv["URL_MONGODB"]

        MongoClients.create(connectString)
    }

    fun getDatabase(bd: String = "Rmungar1209") : MongoDatabase {
        return mongoClient.getDatabase(bd)
    }

    fun close() {
        mongoClient.close()
    }

}