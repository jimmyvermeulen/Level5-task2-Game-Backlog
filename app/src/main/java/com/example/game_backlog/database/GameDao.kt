package com.example.game_backlog.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.game_backlog.model.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable")
    fun getAllGames(): LiveData<List<Game>>

    @Insert
    fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE FROM gametable")
    suspend fun deleteAllProducts()

}