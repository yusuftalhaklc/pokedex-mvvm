package com.yusuftalhaklc.pokedex.service

import com.yusuftalhaklc.pokedex.model.DetailModel
import com.yusuftalhaklc.pokedex.model.PokedexFeedList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokedexAPIService {

    private var api = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokedexApi::class.java)

    fun getFeedFromApi() : Call<PokedexFeedList>{
        return api.getAll()
    }

    fun getDetailFromApi(name:String) : Call<DetailModel>{
        return api.getDetail(name = name)
    }
}