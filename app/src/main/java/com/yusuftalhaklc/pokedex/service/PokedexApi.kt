package com.yusuftalhaklc.pokedex.service

import com.yusuftalhaklc.pokedex.model.DetailModel
import com.yusuftalhaklc.pokedex.model.PokedexFeedList
import com.yusuftalhaklc.pokedex.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApi {

    @GET("pokemon?limit=100&offset=0")
    fun getAll() : Call<PokedexFeedList>

    @GET("pokemon/{name}")
    fun getDetail(@Path("name") name:String) : Call<DetailModel>
}