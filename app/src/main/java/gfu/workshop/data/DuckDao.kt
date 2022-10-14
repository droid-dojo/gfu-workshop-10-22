package gfu.workshop.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DuckDao {

    @Query("SELECT * FROM Duck")
    suspend fun allDucks(): List<Duck>

    @Insert
    suspend fun insertDuck(duck: Duck)

    @Insert
    suspend fun insertDucks(ducks: List<Duck>)

    @Insert
    suspend fun insertDucksVararg(vararg duck: Duck)
}