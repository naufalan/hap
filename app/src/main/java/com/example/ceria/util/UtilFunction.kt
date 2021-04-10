package com.example.ceria.util

import android.app.DatePickerDialog
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

abstract class UtilFunction {
    companion object {
        fun stateViewVisible(view: View) {
            view.visibility = View.VISIBLE
        }

        fun stateViewGone(view: View) {
            view.visibility = View.GONE
        }

        fun datePickerListener(
                calendarPicker: Calendar,
                text: View
        ): DatePickerDialog.OnDateSetListener {
            return DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                calendarPicker.set(Calendar.YEAR, year)
                calendarPicker.set(Calendar.MONTH, month)
                calendarPicker.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val myFormat = "MM/dd/yy" //In which you need put here
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                if (text is EditText) {
                    text.setText(sdf.format(calendarPicker.time))
                } else if (text is TextView)
                    text.text = sdf.format(calendarPicker.time)
            }
        }
    }
}