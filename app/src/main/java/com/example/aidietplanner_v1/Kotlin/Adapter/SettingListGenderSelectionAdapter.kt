package com.example.aidietplanner_v1.Kotlin.Adapter

import androidx.fragment.app.FragmentActivity
import com.example.aidietplanner_v1.Kotlin.Binders.SettingListGenderSelectionBinder
import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class SettingListGenderSelectionAdapter(activity: FragmentActivity, data: ArrayList<BaseModel>): GenericAdapter(data){
    init {
        addBinder(Constants.USER_GENDER_OPTIONS, SettingListGenderSelectionBinder(activity, this))
    }
}