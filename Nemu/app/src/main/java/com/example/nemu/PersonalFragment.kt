package com.example.nemu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PersonalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonalFragment : Fragment(R.layout.fragment_personal) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scheduleOption = view.findViewById<LinearLayout>(R.id.schedule_option)
        val profileOption = view.findViewById<LinearLayout>(R.id.profile_option)
        val settingsOption = view.findViewById<LinearLayout>(R.id.settings_option)
        val bookmarkOption = view.findViewById<LinearLayout>(R.id.bookmark_option)
        val bookingOption = view.findViewById<LinearLayout>(R.id.booking_option)

//        schedule container
        scheduleOption.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ScheduleFragment()) // Replace with your container ID
                .addToBackStack(null) // Optional
                .commit()
        }

//        profile container

        profileOption.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment()) // Replace with your container ID
                .addToBackStack(null) // Optional
                .commit()

        }


        //        settings container
        settingsOption.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SettingsFragment()) // Replace with your container ID
                .addToBackStack(null) // Optional
                .commit()

        }


        //        bookmark containers
        bookmarkOption.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, BookmarkFragment()) // Replace with your container ID
                .addToBackStack(null) // Optional
                .commit()

        }


        //        bookings container
        bookingOption.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, BookingFragment()) // Replace with your container ID
                .addToBackStack(null) // Optional
                .commit()

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PersonalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PersonalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}