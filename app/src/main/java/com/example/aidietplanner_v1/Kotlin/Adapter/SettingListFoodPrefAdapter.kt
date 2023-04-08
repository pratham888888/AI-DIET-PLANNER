package com.example.aidietplanner_v1.Kotlin.Adapter

import androidx.fragment.app.FragmentActivity
import com.example.aidietplanner_v1.Kotlin.Binders.SettingListFoodPrefBinder
import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class SettingListFoodPrefAdapter(activity: FragmentActivity, list: ArrayList<BaseModel>): GenericAdapter(list) {
    init {
        addBinder(Constants.USER_FOOD_PREFERENCES_OPTIONS, SettingListFoodPrefBinder(activity, this))
    }
}