package com.example.aidietplanner_v1.Kotlin.Binders

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.aidietplanner_v1.Java.Activities.MainActivity
import com.example.aidietplanner_v1.Kotlin.Adapter.GenericAdapter
import com.example.aidietplanner_v1.Kotlin.Models.LogOutBtnModel
import com.example.aidietplanner_v1.databinding.CardLayoutSignOutBtnBinding
import com.google.firebase.auth.FirebaseAuth

class LogOutBtnBinder(val activity: FragmentActivity, val adapter: GenericAdapter): DataBinder<LogOutBtnBinder.LogOutBtnViewHolder>() {

    inner class LogOutBtnViewHolder(val binding: CardLayoutSignOutBtnBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: LogOutBtnModel){
            binding.apply {
                signOutBtn.text = data.btnName
            }
            addSetOnClickListeners(binding)
        }
    }

    override fun newViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CardLayoutSignOutBtnBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LogOutBtnViewHolder(binding)
    }

    override fun bindViewHolder(holder: LogOutBtnViewHolder, position: Int) {
        val data = adapter.getData(position) as LogOutBtnModel
        holder.bind(data)
    }

    private fun addSetOnClickListeners(binding: CardLayoutSignOutBtnBinding){
        binding.apply {
            signOutBtn.setOnClickListener {
//                signOutUser(activity)
            }
        }
    }

    private fun signOutUser(activity: FragmentActivity){
        FirebaseAuth.getInstance().signOut()
        val i = Intent(activity, MainActivity::class.java)
        activity.startActivity(i)
    }
}