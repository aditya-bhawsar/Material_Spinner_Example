package com.aditya.materialspinnerexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val priorityEt = findViewById<AutoCompleteTextView>(R.id.priority_et)

        val options: Array<String> = resources.getStringArray(R.array.priorities)
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, R.layout.dropdown_item, options)
        priorityEt.setAdapter(adapter)

        priorityEt.isCursorVisible = false
        priorityEt.showSoftInputOnFocus = false
        priorityEt.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v.windowToken, 0)
            }
        }
    }

    fun getSpinnerValue(spinner: AutoCompleteTextView):String = spinner.text.toString()
}