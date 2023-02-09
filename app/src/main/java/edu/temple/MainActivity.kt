package edu.temple

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val programs = arrayOf(
            "Please select your program",
            "Information Science",
            "Computer Science",
            "Math and CS",
            "Data Science",
            "Other"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, programs)
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.adapter = adapter//spinner setup

        val textName = findViewById<EditText>(R.id.editTextTextName)
        val textEmailAddress = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val textPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val textConfirmPassword = findViewById<EditText>(R.id.editTextTextConfirmPassword)
        val topText = findViewById<TextView>(R.id.displays)//other variables setup


        findViewById<Button>(R.id.saveButton).setOnClickListener {
            var error = false
            val errorText = findViewById<TextView>(R.id.errorMessage)
            //error Messages setup
            if (spinner.selectedItem == "Please select your program") {
                errorText.error = "No program selected"
                error = true
            } else {
                errorText.error = null
            }



            if (textName.text.toString() == "")//if it's empty string
            {
                textName.error = "Name not entered"
                error = true
            } else {
                textName.error = null
            }

            if (textEmailAddress.text.toString() == "") {
                textEmailAddress.error = "Email address not entered"
                error = true
            } else {
                textEmailAddress.error = null
            }

            if (textPassword.text.toString() == "") {
                textPassword.error = "Password not entered"
                error = true
            } else {
                textPassword.error = null
            }

            if (textPassword.text.toString() != textConfirmPassword.text.toString())//if password doesn't match
            {
                textConfirmPassword.error = "Password doesn't match"
                error = true
            } else {
                textConfirmPassword.error = null
            }

            if (!error)//if everything is fine
            {
                topText.text = "Welcome to the app, " + textName.text.toString()
            } else {
                topText.text = "Please fix the errors"
            }
        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }
    }

}