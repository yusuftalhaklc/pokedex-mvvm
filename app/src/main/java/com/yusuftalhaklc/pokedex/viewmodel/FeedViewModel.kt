package com.yusuftalhaklc.pokedex.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yusuftalhaklc.pokedex.model.DetailModel
import com.yusuftalhaklc.pokedex.model.FeedModel
import com.yusuftalhaklc.pokedex.model.PokedexFeedList
import com.yusuftalhaklc.pokedex.model.Result
import com.yusuftalhaklc.pokedex.service.PokedexAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedViewModel : ViewModel() {

    private var service = PokedexAPIService()

    var resultList = ArrayList<Result>()
    var modelList = ArrayList<FeedModel>()

    var livefeedModelList = MutableLiveData<List<FeedModel>>()
    var feedLiveData = MutableLiveData<List<Result>>()
    var detailsLiveData = MutableLiveData<DetailModel>()

    var loading = MutableLiveData<Boolean>()
    var error = MutableLiveData<Boolean>()

    fun getData(){
        loading.value = true
        service.getFeedFromApi().enqueue(object : Callback<PokedexFeedList>{
            override fun onResponse(call: Call<PokedexFeedList>, response: Response<PokedexFeedList>) {
               if(response.isSuccessful){
                   feedLiveData.value = response.body()?.results

                   resultList = feedLiveData.value as ArrayList<Result>
                   initialDetails(resultList)
               }
            }
            override fun onFailure(call: Call<PokedexFeedList>, t: Throwable) {
                loading.value = false
                error.value = true
            }
        })
    }

    fun initialDetails(newList:ArrayList<Result>){
        for (i in newList){
            getDetails(i.name)
        }
        loading.value = false
    }

    private fun getDetails(name:String){
        service.getDetailFromApi(name).enqueue(object : Callback<DetailModel>{
            override fun onResponse(call: Call<DetailModel>, response: Response<DetailModel>) {
                if(response.isSuccessful){
                    detailsLiveData.value = response.body()

                    val name =  detailsLiveData.value?.name.toString()
                    val imgUrl =  detailsLiveData.value?.sprites?.other?.dream_world?.front_default.toString()
                    val model = FeedModel(name,imgUrl)
                    modelList.add(model)

                    livefeedModelList.postValue(modelList)

                }
            }
            override fun onFailure(call: Call<DetailModel>, t: Throwable) {
            }

        })
    }
}