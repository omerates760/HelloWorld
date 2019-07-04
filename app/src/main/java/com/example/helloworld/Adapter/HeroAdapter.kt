package com.example.helloworld.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.DTO.Hero
import com.example.helloworld.Listener.CustomItemListener
import com.example.helloworld.R
import com.squareup.picasso.Picasso



class HeroAdapter(
    val ctx: Context,
    val list: List<Hero>,
    val customItemListener: CustomItemListener ):
    RecyclerView.Adapter<HeroAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.
            context).inflate(R.layout.item_row,parent,false)
        val myViewHolder=MyViewHolder(v)
        v.setOnClickListener {
            customItemListener.onItemClick(list[myViewHolder.adapterPosition],myViewHolder.adapterPosition)


        }
        return myViewHolder

    }

    override fun getItemCount(): Int=list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.movieName.text=list[position].name
        holder.movieRealname.text=list[position].realname
        holder.movieTeam.text=list[position].team
        holder.movieAppearance.text=list[position].firstappearance
        holder.movieCreatedby.text=list[position].createdby
        holder.moviePublisher.text=list[position].publisher
        Picasso.with(ctx).load(list[position].imageurl).resize(200,250).into(holder.movieImage)
        holder.movieBio.text=list[position].bio


    }

    class MyViewHolder(itemview: View) :RecyclerView.ViewHolder(itemview){
        val movieName:TextView=itemview.findViewById(R.id.MovieName)
        val movieRealname:TextView=itemview.findViewById(R.id.MovieRealname)
        val movieTeam:TextView=itemview.findViewById(R.id.MovieTeam)
        val movieAppearance:TextView=itemview.findViewById(R.id.MovieFirstappearance)
        val movieCreatedby:TextView=itemview.findViewById(R.id.MovieCreatedby)
        val moviePublisher:TextView=itemview.findViewById(R.id.MoviePublisher)
        val movieImage:ImageView=itemview.findViewById(R.id.MovieImage)
        val movieBio:TextView=itemview.findViewById(R.id.MovieBio)



    }

    }
