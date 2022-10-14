package gfu.workshop.data

import retrofit2.http.GET

interface DuckApi {
    @GET("api/v2/list")
    suspend fun listDucks(): DuckListResponse
}