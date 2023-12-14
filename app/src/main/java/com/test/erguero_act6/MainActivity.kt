package com.test.erguero_act6

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {

    private lateinit var btnAlertDialog: Button
    private lateinit var btnDatePicker: Button
    private lateinit var btnTimePicker: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAlertDialog = findViewById(R.id.btnAlertDialog)
        btnDatePicker = findViewById(R.id.btnDatePicker)
        btnTimePicker = findViewById(R.id.btnTimePicker)
        textViewResult = findViewById(R.id.textViewResult)

        btnAlertDialog.setOnClickListener {
            showAlertDialog()
        }

        btnDatePicker.setOnClickListener {
            showDatePickerDialog()
        }

        btnTimePicker.setOnClickListener {
            showTimePickerDialog()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setMessage("This is an AlertDialog")
            .setPositiveButton("OK") { _, _ ->
                textViewResult.text = "AlertDialog: OK clicked"
                Toast.makeText(applicationContext, "OK clicked", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel") { _, _ ->
                textViewResult.text = "AlertDialog: Cancel clicked"
                Toast.makeText(applicationContext, "Cancel clicked", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    @SuppressLint("SetTextI18n")
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                textViewResult.text = "Date selected: $year-${month + 1}-$dayOfMonth"
                Toast.makeText(applicationContext, "Date selected: $year-${month + 1}-$dayOfMonth", Toast.LENGTH_SHORT).show()
            },
            year, month, dayOfMonth
        )

        datePickerDialog.show()
    }

    @SuppressLint("SetTextI18n")
    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                textViewResult.text = "Time selected: $hourOfDay:$minute"
                Toast.makeText(applicationContext, "Time selected: $hourOfDay:$minute", Toast.LENGTH_SHORT).show()
            },
            hour, minute, true
        )

        timePickerDialog.show()
    }
}