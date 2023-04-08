package com.example.aidietplanner_v1.Kotlin.Binders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aidietplanner_v1.Kotlin.Adapter.GenericAdapter
import com.example.aidietplanner_v1.Kotlin.Adapter.SettingListFoodPrefAdapter
import com.example.aidietplanner_v1.Kotlin.Models.UserFoodPreferencesModel
import com.example.aidietplanner_v1.databinding.CardLayoutSettingsListBinding

class UserFoodPreferencesBinder(val activity: FragmentActivity, private val adapter: GenericAdapter): DataBinder<UserFoodPreferencesBinder.UserFoodPreferencesViewHolder>() {

    inner class UserFoodPreferencesViewHolder(private val binding: CardLayoutSettingsListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data: UserFoodPreferencesModel){
            binding.apply {
                cardHeading.text = data.heading
                cardList.apply {
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    adapter = SettingListFoodPrefAdapter(activity, data.recyclerViewList)
                }
            }
        }
    }

    override fun newViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CardLayoutSettingsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserFoodPreferencesViewHolder(binding)
    }

    override fun bindViewHolder(holder: UserFoodPreferencesViewHolder, position: Int) {
        val data = adapter.getData(position) as UserFoodPreferencesModel
        holder.bind(data)
    }
}
