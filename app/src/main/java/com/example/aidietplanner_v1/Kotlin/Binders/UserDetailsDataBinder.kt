package com.example.aidietplanner_v1.Kotlin.Binders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.aidietplanner_v1.Kotlin.Adapter.GenericAdapter
import com.example.aidietplanner_v1.Kotlin.Models.UserDetailsModel
import com.example.aidietplanner_v1.databinding.CardLayoutSettingsUserDetailsBinding

class UserDetailsDataBinder(val activity: FragmentActivity, val adapter: GenericAdapter): DataBinder<UserDetailsDataBinder.UserDetailsViewHolder>() {

    class UserDetailsViewHolder(val binding: CardLayoutSettingsUserDetailsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: UserDetailsModel){
            binding.apply {
                userName.text = data.userName
                userEmail.text = data.userEmail
            }
        }
    }

    override fun newViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CardLayoutSettingsUserDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserDetailsViewHolder(binding)
    }

    override fun bindViewHolder(holder: UserDetailsViewHolder, position: Int) {
        val data = adapter.getData(position) as UserDetailsModel
        holder.bind(data)
    }
}