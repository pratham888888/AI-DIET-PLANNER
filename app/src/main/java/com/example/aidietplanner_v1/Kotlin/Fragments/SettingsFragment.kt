package com.example.aidietplanner_v1.Kotlin.Fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aidietplanner_v1.Java.Activities.MainActivity
import com.example.aidietplanner_v1.Kotlin.Adapter.SettingsAdapter
import com.example.aidietplanner_v1.Kotlin.Models.*
import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel
import com.example.aidietplanner_v1.R
import com.example.aidietplanner_v1.databinding.FragmentSettingsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.settingsList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = SettingsAdapter(requireActivity(), getMockList())
        }

        return binding.root
    }
}

private fun getMockList(): ArrayList<BaseModel>{
    val foodOptions = arrayListOf<BaseModel>(
        FoodPreferencesOptionsModel("Veg","https://cdn-icons-png.flaticon.com/512/2329/2329865.png","https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Indian-vegetarian-mark.svg/2048px-Indian-vegetarian-mark.svg.png"),
        FoodPreferencesOptionsModel("Non-Veg", "https://cdn.iconscout.com/icon/free/png-256/non-veg-food-1851554-1569279.png","https://www.nabeeats.com/assets/images/non-veg.png"),
        FoodPreferencesOptionsModel("Eggiterian", "https://icons.veryicon.com/png/o/food--drinks/fresh-vegetables-with-excellent-fruits/egg-18.png")
    )

    val allergiesOptions = arrayListOf<BaseModel>(
        AllergiesOptionsModel("Peanuts", "https://aliciaadorada.files.wordpress.com/2010/04/peanut-ban.gif"),
        AllergiesOptionsModel("Lactose", "https://cdn-icons-png.flaticon.com/512/4703/4703130.png"),
        AllergiesOptionsModel("Shellfish", "https://cdn-icons-png.flaticon.com/512/2328/2328254.png"),
        AllergiesOptionsModel("Eggs", "https://cdn-icons-png.flaticon.com/512/2754/2754045.png"),
        AllergiesOptionsModel("Soy", "https://cdn-icons-png.flaticon.com/512/2224/2224268.png"),
        AllergiesOptionsModel("Tree nuts", "https://cdn-icons-png.flaticon.com/512/2435/2435673.png"),
        AllergiesOptionsModel("Wheat", "https://icons.iconarchive.com/icons/erudus/allergy/512/wheat-allergy-amber-icon.png")
    )

    val genderOptions = arrayListOf<BaseModel>(
        GenderOptionsModel("Male", "https://cdn-icons-png.flaticon.com/512/163/163801.png"),
        GenderOptionsModel("Female", "https://cdn-icons-png.flaticon.com/512/921/921009.png")
    )

    return arrayListOf(
        UserDetailsModel("User Name", "xxx@gmail.com"),
        BMIDetailsModel("182cm", "80kg"),
        UserGenderSelectionModel("Gender", genderOptions),
        UserFoodPreferencesModel("Food Preferences", foodOptions),
        UserAllergiesSelectionModel("Allergies", allergiesOptions),
        LogOutBtnModel()
    )
}
