package com.example.aidietplanner_v1.Kotlin.Binders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.aidietplanner_v1.Kotlin.Adapter.GenericAdapter
import com.example.aidietplanner_v1.Kotlin.Helper.ImageHelper
import com.example.aidietplanner_v1.Kotlin.Models.FoodPreferencesOptionsModel
import com.example.aidietplanner_v1.databinding.CardLayoutFoodPrefOptionsBinding

class SettingListFoodPrefBinder(val activity: FragmentActivity, private val adapter: GenericAdapter): DataBinder<SettingListFoodPrefBinder.SettingListFoodPrefViewHolder>() {

    inner class SettingListFoodPrefViewHolder(private val binding: CardLayoutFoodPrefOptionsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: FoodPreferencesOptionsModel){
            binding.apply {
                foodPrefTypeName.text = data.heading
                ImageHelper.loadImage(activity, foodPrefTypeImg, data.img)
                ImageHelper.loadImageFit(activity, foodPrefTypeLogo, data.logo)
            }
        }
    }

    override fun newViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CardLayoutFoodPrefOptionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SettingListFoodPrefViewHolder(binding)
    }

    override fun bindViewHolder(holder: SettingListFoodPrefViewHolder, position: Int) {
        val data = adapter.getData(position) as FoodPreferencesOptionsModel
        holder.bind(data)
    }


}