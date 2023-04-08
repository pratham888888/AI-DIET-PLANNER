package com.example.aidietplanner_v1.Kotlin.Models

import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class AllergiesOptionsModel(val heading: String="", val img: String=""): BaseModel() {
    override fun getModel(): Int {
        return Constants.USER_ALLERGIES_SELECTION_OPTIONS
    }

}