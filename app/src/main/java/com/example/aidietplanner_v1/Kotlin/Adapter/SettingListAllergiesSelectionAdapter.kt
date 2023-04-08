package com.example.aidietplanner_v1.Kotlin.Adapter

import androidx.fragment.app.FragmentActivity
import com.example.aidietplanner_v1.Kotlin.Binders.SettingListAllergiesSelectionBinder
import com.example.aidietplanner_v1.Kotlin.Binders.UserAllergiesSelectionBinder
import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class SettingListAllergiesSelectionAdapter(activity: FragmentActivity, list: ArrayList<BaseModel>): GenericAdapter(list) {
    init {
        addBinder(Constants.USER_ALLERGIES_SELECTION_OPTIONS, SettingListAllergiesSelectionBinder(activity, this))
    }
}