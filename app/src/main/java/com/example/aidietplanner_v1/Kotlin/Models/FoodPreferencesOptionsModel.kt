package com.example.aidietplanner_v1.Kotlin.Models

import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class FoodPreferencesOptionsModel(val heading: String="", val img: String="", val logo: String=""): BaseModel() {
    override fun getModel(): Int {
        return Constants.USER_FOOD_PREFERENCES_OPTIONS
    }

}