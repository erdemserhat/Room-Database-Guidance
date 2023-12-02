package com.erdemserhat.room_database_guidance.ui.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erdemserhat.room_database_guidance.data.User
import com.erdemserhat.room_database_guidance.databinding.RecyclerRowBinding
import java.util.zip.Inflater

class UserRecyclerView():RecyclerView.Adapter<UserRecyclerView.UserHolder>() {

    class UserHolder(val binding:RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding : RecyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return UserHolder(binding)
    }

    override fun getItemCount(): Int {
        return 0

    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {

        //holder.binding.


    }
}