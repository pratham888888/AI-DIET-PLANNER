package com.example.aidietplanner_v1.Kotlin.Models

import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class GenderOptionsModel(val genderTitle: String, val imgUrl: String=""):BaseModel() {
    override fun getModel(): Int {
        return Constants.USER_GENDER_OPTIONS
    }

}