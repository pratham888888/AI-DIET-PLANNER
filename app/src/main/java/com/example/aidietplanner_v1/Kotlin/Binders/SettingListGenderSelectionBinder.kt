package com.example.aidietplanner_v1.Kotlin.Binders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.aidietplanner_v1.Kotlin.Adapter.GenericAdapter
import com.example.aidietplanner_v1.Kotlin.Helper.ImageHelper
import com.example.aidietplanner_v1.Kotlin.Models.GenderOptionsModel
import com.example.aidietplanner_v1.databinding.CardLayoutGenderOptionsBinding

class SettingListGenderSelectionBinder(val activity: FragmentActivity, val adapter: GenericAdapter): DataBinder<SettingListGenderSelectionBinder.SettingListGenderSelectionViewHolder>() {

    inner class SettingListGenderSelectionViewHolder(val binding: CardLayoutGenderOptionsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: GenderOptionsModel){
            binding.apply {
                genderName.text = data.genderTitle
                ImageHelper.loadImage(activity, genderImg, data.imgUrl)
            }
        }
    }

    override fun newViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CardLayoutGenderOptionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SettingListGenderSelectionViewHolder(binding)
    }

    override fun bindViewHolder(holder: SettingListGenderSelectionViewHolder, position: Int) {
        val data = adapter.getData(position) as GenderOptionsModel
        holder.bind(data)
    }
}