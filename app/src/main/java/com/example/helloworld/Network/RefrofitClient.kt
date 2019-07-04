package com.example.helloworld.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RefrofitClient {
    companion object{

        fun getClient():Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://www.simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}