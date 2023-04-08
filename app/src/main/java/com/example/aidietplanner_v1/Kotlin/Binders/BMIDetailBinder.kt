package com.example.aidietplanner_v1.Kotlin.Binders

import android.app.Activity
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.aidietplanner_v1.Kotlin.Adapter.GenericAdapter
import com.example.aidietplanner_v1.Kotlin.Models.BMIDetailsModel
import com.example.aidietplanner_v1.R
import com.example.aidietplanner_v1.databinding.ActivityHomeBinding.inflate
import com.example.aidietplanner_v1.databinding.CardLayoutBmiDetailsBinding
import kotlin.math.acos
import com.example.aidietplanner_v1.Kotlin.Activities.HomeActivity as HomeActivity

class BMIDetailBinder(val activity: FragmentActivity, private val adapter: GenericAdapter): DataBinder<BMIDetailBinder.BMIDetailViewHolder>() {

    class BMIDetailViewHolder(private val binding: CardLayoutBmiDetailsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: BMIDetailsModel){
            binding.apply {
                userHeight.text = data.height
                userWeight.text = data.weight
            }
//         binding.heightWeightConstraintLayout.setOnClickListener {
//             var dialog = Dialog()
//             dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//             dialog.setCancelable(true)
//                     dialog.setContentView(R.layout.dialog_box_height_and_weight_input)
//                 val btn: Button = dialog.findViewById<Button>(R.id.btn_height_weight_dialog)
//             btn.setOnClickListener {
//
//                 dialog.cancel()
//
//             }
//         }
             }
        }
    public fun showDialog() {

    }
        override fun newViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CardLayoutBmiDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BMIDetailViewHolder(binding)
    }

    override fun bindViewHolder(holder: BMIDetailViewHolder, position: Int) {
        val data = adapter.getData(position) as BMIDetailsModel
        holder.bind(data)
    }
}