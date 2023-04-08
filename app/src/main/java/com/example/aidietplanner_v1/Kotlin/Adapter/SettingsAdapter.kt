package com.example.aidietplanner_v1.Kotlin.Adapter

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import com.example.aidietplanner_v1.Kotlin.Binders.*
import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.Kotlin.Utils.Constants

class SettingsAdapter(activity: FragmentActivity, list: ArrayList<BaseModel>): GenericAdapter(list) {
    init {
        addBinder(Constants.USER_DETAILS, UserDetailsDataBinder(activity, this))
        addBinder(Constants.USER_BMI_DETAILS, BMIDetailBinder(activity, this))
        addBinder(Constants.USER_GENDER_SELECTION_LIST, UserGenderTypeBinder(activity, this))
        addBinder(Constants.USER_FOOD_PREFERENCES_LIST, UserFoodPreferencesBinder(activity, this))
        addBinder(Constants.USER_ALLERGIES_SELECTION_LIST, UserAllergiesSelectionBinder(activity, this))
        addBinder(Constants.USER_SIGN_OUT_BTN, LogOutBtnBinder( activity, this))
    }
}