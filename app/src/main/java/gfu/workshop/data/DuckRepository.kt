package gfu.workshop.data

import android.content.Context
import androidx.room.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DuckRepository(context: Context) {
    private val client = Retrofit.Builder()
        .baseUrl("https://random-d.uk/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: DuckApi = client.create()

    private val database = Room
        .databaseBuilder(context, DuckDatabase::class.java, "duck.db")
        .build()

    suspend fun getDuckList(): List<Duck> {
        val ducks = database.ducks().allDucks()

        api.listDucks()

        return ducks.ifEmpty {
            val apiDucks = api.listDucks().images.map { Duck("https://random-d.uk/api/$it") }
            database.ducks().insertDucks(apiDucks)
            apiDucks
        }
    }
}

