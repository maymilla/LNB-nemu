package com.example.nemu

import java.io.Serializable
import java.sql.Time

data class PlaceItem(
     val name: String,
     val address: String,
     val crowdiness: Crowdiness,
     val photos: ArrayList<Int>,
     val timeScheduleOpen: Time,
     val timeScheduleClose: Time,
     val description: String,
     val facilities: ArrayList<String>,
     val ticketPrices: MutableMap<Visitor, Double>,
     val giftPricesStart: Double,
     val giftPricesEnd: Double
) : Serializable
