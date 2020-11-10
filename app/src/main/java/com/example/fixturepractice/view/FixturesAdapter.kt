package com.example.fixturepractice.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.fixturepractice.R
import com.example.fixturepractice.databinding.LeagueInfoBinding
import com.example.fixturepractice.model.MyFixtures
import java.util.*
import java.util.Collections.addAll

class FixturesAdapter(private val listener : (MyFixtures) -> Unit
) : RecyclerView.Adapter<FixturesAdapter.FixturesViewHolder>(){

    private val items: MutableList<MyFixtures> = mutableListOf()

    fun setFixtures(fixtures: List<MyFixtures>){
        this.items.clear()
        this.items.addAll(fixtures)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LeagueInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).let {
            FixturesViewHolder(it)
        }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        holder.loadFixtures(items[position])
    }

    override fun getItemCount(): Int = items.size

    class FixturesViewHolder(private val binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun loadFixtures(fixtures: MyFixtures){
            when (binding){
                is LeagueInfoBinding -> binding.apply {
                    championLeague.text = fixtures.competitionStage?.competition?.name
                }
            }
        }
    }
}
