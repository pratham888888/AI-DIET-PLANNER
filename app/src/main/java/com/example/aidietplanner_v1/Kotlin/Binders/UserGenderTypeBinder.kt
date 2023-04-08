package com.example.aidietplanner_v1.Kotlin.Binders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aidietplanner_v1.Kotlin.Adapter.GenericAdapter
import com.example.aidietplanner_v1.Kotlin.Adapter.SettingListGenderSelectionAdapter
import com.example.aidietplanner_v1.Kotlin.Models.UserGenderSelectionModel
import com.example.aidietplanner_v1.databinding.CardLayoutSettingsListBinding

class UserGenderTypeBinder(val activity: FragmentActivity, val adapter: GenericAdapter):DataBinder<UserGenderTypeBinder.UserGenderTypeViewHolder>() {

    inner class UserGenderTypeViewHolder(val binding: CardLayoutSettingsListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: UserGenderSelectionModel){
            binding.apply {
                cardHeading.text = data.heading
                cardList.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                cardList.adapter = SettingListGenderSelectionAdapter(activity, data.recyclerViewList)
            }
        }
    }

    override fun newViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CardLayoutSettingsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserGenderTypeViewHolder(binding)
    }

    override fun bindViewHolder(holder: UserGenderTypeViewHolder, position: Int) {
        val data = adapter.getData(position) as UserGenderSelectionModel
        holder.bind(data)
    }
}