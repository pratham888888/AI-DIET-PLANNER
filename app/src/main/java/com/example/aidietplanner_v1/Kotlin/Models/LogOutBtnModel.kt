package com.example.aidietplanner_v1.Kotlin.Models

import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class LogOutBtnModel(val btnName: String="Sign Out"): BaseModel() {
    override fun getModel(): Int {
        return Constants.USER_SIGN_OUT_BTN
    }
}