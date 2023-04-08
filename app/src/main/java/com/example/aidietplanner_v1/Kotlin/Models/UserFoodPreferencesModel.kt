package com.example.aidietplanner_v1.Kotlin.Models

import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class UserFoodPreferencesModel(val heading: String="", val recyclerViewList: ArrayList<BaseModel> = arrayListOf()): BaseModel() {
    override fun getModel(): Int {
        return Constants.USER_FOOD_PREFERENCES_LIST
    }

}