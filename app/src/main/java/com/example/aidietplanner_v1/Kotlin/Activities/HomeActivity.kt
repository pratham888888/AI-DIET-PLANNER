package com.example.aidietplanner_v1.Kotlin.Activities

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.aidietplanner_v1.R
import com.example.aidietplanner_v1.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shawnlin.numberpicker.NumberPicker

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
   private lateinit var numberPicker: NumberPicker
   private lateinit var textView: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        numberPicker= findViewById(R.id.number_picker)
        textView= findViewById(R.id.age_text)

        numberPicker.setOnValueChangedListener( NumberPicker.OnValueChangeListener { picker, oldVal, newVal ->
            @Override
            fun onValueChanged(){
                 textView.text = "Selected age is:$newVal"
        }

        })

//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_diet_chart, R.id.navigation_progress, R.id.navigation_settings
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }



    }
