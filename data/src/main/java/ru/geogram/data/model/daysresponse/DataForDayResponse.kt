package ru.geogram.data.model.daysresponse

import com.google.gson.annotations.SerializedName

data class DataForDayResponse(
    @SerializedName("days")
    val days: List<Day>
)