package gfu.workshop.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Duck::class], version = 1)
abstract class DuckDatabase : RoomDatabase() {
    abstract fun ducks(): DuckDao
}