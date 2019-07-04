package com.example.helloworld.Network

import com.example.helloworld.DTO.Hero
import retrofit2.Call
import retrofit2.http.GET

interface HeroService {
    @GET("marvel")
    fun getHeroes():Call<List<Hero>>
}