package com.example.nemu

import java.sql.Time
import java.util.Dictionary

data class PlaceItem(
     val name:String,
     val address:String,
     val crowdiness : Enum<Crowdiness>,
     val photos:ArrayList<kotlin.Int>,
     val timeScheduleOpen: Time,
     val timeScheduleClose: Time,
     val description:String,
     val facilities:ArrayList<String>,
     val ticketPrices:MutableMap<Visitor, Double>,
     val giftPricesStart:Double,
     val giftPricesEnd: Double

)
