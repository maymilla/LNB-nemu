package com.example.nemu

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.nemu.ScheduleFragment.GridAdapter
import java.sql.Time

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookingAddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookingAddFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_booking_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridView = view.findViewById<GridView>(R.id.add_booking_grid)

        // Sample data
        val photos1 = arrayListOf(R.drawable.place_1, R.drawable.place_2)
        val photos2 = arrayListOf(R.drawable.place_1, R.drawable.place_1)
        val photos3 = arrayListOf(R.drawable.place_1, R.drawable.place_2)

        val facilities1 = arrayListOf("lorem", "ipsum")
        val facilities2 = arrayListOf("lorem", "lorem")
        val facilities3 = arrayListOf("ipsum", "ipsum")

        val price1 = mutableMapOf(Visitor.Adult to 10000.0, Visitor.Teen to 5000.0, Visitor.Child to 1000.0)
        val price2 = mutableMapOf(Visitor.Adult to 100.0, Visitor.Teen to 50.0, Visitor.Child to 10.0)
        val price3 = mutableMapOf(Visitor.Adult to 1000.0, Visitor.Teen to 500.0, Visitor.Child to 100.0)

        val sampleItems = listOf(
            PlaceItem("Birmingham Museum", "Jl. Melati No. 5", Crowdiness.Crowded, photos1,
                Time(12, 0, 0), Time(22, 0, 0), "Lorem", facilities1, price1, 0.0, 1000.0),
            PlaceItem("Birm", "Jl. Melati No. 3", Crowdiness.Crowded, photos2,
                Time(12, 0, 0), Time(0, 0, 0), "Lorem", facilities2, price2, 0.0, 5000.0),
            PlaceItem("Birmingham", "Jl. Melati No. 5", Crowdiness.Crowded, photos3,
                Time(5, 0, 0), Time(22, 0, 0), "Lorem", facilities3, price3, 0.0, 100.0)
        )

        // Adapter with click handling
        val adapter = GridAdapter(requireContext(), sampleItems) { clickedItem ->
            val bundle = Bundle().apply {
                putSerializable("placeItem", clickedItem)
            }

            val destinationFragment = BookingAddPlaceFragment().apply {
                arguments = bundle
            }

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, destinationFragment)
                .addToBackStack(null)
                .commit()
        }

        gridView.adapter = adapter

        // Back button
        val backButton = view.findViewById<ImageView>(R.id.back_button)
        backButton?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookingAddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookingAddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    class GridAdapter(
        private val context: Context,
        private val data: List<PlaceItem>,
        private val onItemClick: (PlaceItem) -> Unit
    ) : BaseAdapter() {

        override fun getCount() = data.size
        override fun getItem(position: Int) = data[position]
        override fun getItemId(position: Int) = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context)
                .inflate(R.layout.booking_grid_item_place, parent, false)

            val item = data[position]

            val imageView = view.findViewById<ImageView>(R.id.place_image)
            val nameView = view.findViewById<TextView>(R.id.place_name)
            val addressView = view.findViewById<TextView>(R.id.place_address)

            // Use first photo or fallback
            imageView.setImageResource(item.photos.firstOrNull() ?: R.drawable.place_1)
            nameView.text = item.name
            addressView.text = item.address

            view.setOnClickListener {
                onItemClick(item)
            }

            return view
        }
    }


}