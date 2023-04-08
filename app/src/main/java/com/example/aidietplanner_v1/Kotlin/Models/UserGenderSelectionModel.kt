package com.example.aidietplanner_v1.Kotlin.Models

import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class UserGenderSelectionModel(val heading: String="", val recyclerViewList: ArrayList<BaseModel>): BaseModel() {
    override fun getModel(): Int {
        return Constants.USER_GENDER_SELECTION_LIST
    }

}