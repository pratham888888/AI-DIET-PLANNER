package com.example.aidietplanner_v1.Kotlin.Models

import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class UserDetailsModel(val userName: String, val userEmail: String): BaseModel() {
    override fun getModel(): Int {
        return Constants.USER_DETAILS
    }
}