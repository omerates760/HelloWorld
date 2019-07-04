package com.example.helloworld.Listener

import com.example.helloworld.DTO.Hero

interface CustomItemListener {
    fun onItemClick(hero:Hero,position:Int)
}