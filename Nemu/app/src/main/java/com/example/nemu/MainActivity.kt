package com.example.nemu

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.compose.ui.text.style.TextIndent


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()

        findViewById<LinearLayout>(R.id.bottom_nav_home).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
            onClickNav("home")
        }

        findViewById<LinearLayout>(R.id.bottom_nav_maps).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MapsFragment())
                .commit()
            onClickNav("maps")
        }

        findViewById<LinearLayout>(R.id.bottom_nav_personal).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PersonalFragment())
                .commit()
            onClickNav("personal")
        }

//        personal page navigation
//        schedule
        findViewById<LinearLayout>(R.id.schedule_option).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ScheduleFragment())
                .commit()
            onClickNav("personal")
        }

//    profile
        findViewById<LinearLayout>(R.id.bottom_nav_personal).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PersonalFragment())
                .commit()
            onClickNav("personal")
        }

//        bookmark
        findViewById<LinearLayout>(R.id.bottom_nav_personal).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PersonalFragment())
                .commit()
            onClickNav("personal")
        }

//        booking
        findViewById<LinearLayout>(R.id.bottom_nav_personal).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PersonalFragment())
                .commit()
            onClickNav("personal")
        }

//        settings
        findViewById<LinearLayout>(R.id.bottom_nav_personal).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PersonalFragment())
                .commit()
            onClickNav("personal")
        }


    }

    fun onClickNav(selected : String){
        val homeIcon = findViewById<ImageView>(R.id.icon_nav_home)
        val homeNavText = findViewById<TextView>(R.id.nav_home)

        val mapsIcon = findViewById<ImageView>(R.id.icon_nav_maps)
        val mapsNavText = findViewById<TextView>(R.id.nav_maps)

        val personalIcon = findViewById<ImageView>(R.id.icon_nav_personal)
        val personalNavText = findViewById<TextView>(R.id.nav_personal)

//        set all into disable
        homeIcon.setImageDrawable(getResources().getDrawable(R.drawable.filter_light))
        homeNavText.setTextColor(getResources().getColor(R.color.date_typography_light_green) )

        mapsIcon.setImageDrawable(getResources().getDrawable(R.drawable.explore_light))
        mapsNavText.setTextColor(getResources().getColor(R.color.date_typography_light_green) )

        personalIcon.setImageDrawable(getResources().getDrawable(R.drawable.personal_light))
        personalNavText.setTextColor(getResources().getColor(R.color.date_typography_light_green) )

//      set the current page color
        when (selected){
            ("home") -> {
                homeIcon.setImageDrawable(getResources().getDrawable(R.drawable.filter_dark))
                homeNavText.setTextColor(getResources().getColor(R.color.main_dark_green) )
            }
            ("maps") -> {
                mapsIcon.setImageDrawable(getResources().getDrawable(R.drawable.explore_dark))
                mapsNavText.setTextColor(getResources().getColor(R.color.main_dark_green) )
            }
            ("personal") -> {
                personalIcon.setImageDrawable(getResources().getDrawable(R.drawable.personal_dark))
                personalNavText.setTextColor(getResources().getColor(R.color.main_dark_green) )
            }
        }
    }
}
