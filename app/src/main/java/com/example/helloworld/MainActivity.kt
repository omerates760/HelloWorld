package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.helloworld.Adapter.HeroAdapter
import com.example.helloworld.DTO.Hero
import com.example.helloworld.Listener.CustomItemListener
import com.example.helloworld.Network.HeroService
import com.example.helloworld.Network.RefrofitClient
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this)


        RefrofitClient.getClient().create(HeroService::class.java)
            .getHeroes().enqueue(object : retrofit2.Callback<List<Hero>> {

                override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                    val repoList:List<Hero>
                    repoList= response.body()!!
                    Log.e("result",""+response.body())

                    val adapter=HeroAdapter(this@MainActivity,repoList,object :CustomItemListener{
                        override fun onItemClick(hero: Hero, position: Int) {
                            Snackbar.make(main_layout, hero.name, Snackbar.LENGTH_LONG).show()

                        }
                    })
                    recyclerview.adapter=adapter


                }

                override fun onFailure(call: Call<List<Hero>>, t: Throwable) {

                }
            })

    }

}
