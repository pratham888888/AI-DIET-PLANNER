package com.example.aidietplanner_v1.Kotlin.Models

import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class UserAllergiesSelectionModel(val heading: String="", val recyclerViewList: ArrayList<BaseModel> = arrayListOf()): BaseModel() {
    override fun getModel(): Int {
        return Constants.USER_ALLERGIES_SELECTION_LIST
    }
}