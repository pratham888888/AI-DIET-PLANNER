package com.example.aidietplanner_v1.Kotlin.Binders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aidietplanner_v1.Kotlin.Adapter.GenericAdapter
import com.example.aidietplanner_v1.Kotlin.Adapter.SettingListAllergiesSelectionAdapter
import com.example.aidietplanner_v1.Kotlin.Models.UserAllergiesSelectionModel
import com.example.aidietplanner_v1.databinding.CardLayoutSettingsListBinding

class UserAllergiesSelectionBinder(val activity: FragmentActivity, private val adapter: GenericAdapter): DataBinder<UserAllergiesSelectionBinder.UserAllergiesSelectionViewHolder>() {

    inner class UserAllergiesSelectionViewHolder(private val binding: CardLayoutSettingsListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind (data: UserAllergiesSelectionModel){
            binding.apply {
                cardHeading.text = data.heading
                cardList.apply {
                    layoutManager = GridLayoutManager(context, 3)
                    adapter = SettingListAllergiesSelectionAdapter(activity, data.recyclerViewList)
                }
            }
        }
    }

    override fun newViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CardLayoutSettingsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserAllergiesSelectionViewHolder(binding)
    }

    override fun bindViewHolder(holder: UserAllergiesSelectionViewHolder, position: Int) {
        val data = adapter.getData(position) as UserAllergiesSelectionModel
        holder.bind(data)
    }
}
