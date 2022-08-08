package com.top100.data.remote.api.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.top100.data.remote.api.adapter.DateJsonAdapter.Companion.DEFAULT_FORMAT
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Converts a [String] into a [Date] using [DEFAULT_FORMAT].
 * It also converts a [Date] into a [String] using [DEFAULT_FORMAT].
 */
class DateJsonAdapter {

    @FromJson
    fun fromJson(date: String): Date? {
        try {
            return SimpleDateFormat(DEFAULT_FORMAT, Locale.US).parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    @ToJson
    fun toJson(date: Date): String {
        return SimpleDateFormat(DEFAULT_FORMAT, Locale.US).format(date)
    }

    companion object {
        const val DEFAULT_FORMAT = "yyyy-MM-dd"
    }
}
