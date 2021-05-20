package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path

import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.Constants
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.characters.Characters
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.hq.Comics

interface ApiService {
    @GET("/v1/public/characters?")
    fun getCharacters(@Query("ts") ts : String = Constants.TS,
                      @Query("apikey") apikey: String = Constants.API_KEY,
                      @Query("hash") hash: String = Constants.HASH,
                      @Query("orderBy") orderBy: String = "name",
                      @Query("limit") limit: Int = 20,
                      @Query("offset") offset: Int = 0) : Call<Characters>

    @GET("/v1/public/characters/{characterId}/comics?")
    fun getComics(@Path("characterId") characterId : Int,
                  @Query("ts") ts : String = Constants.TS,
                  @Query("apikey") apikey: String = Constants.API_KEY,
                  @Query("hash") hash: String = Constants.HASH) : Call<Comics>

}