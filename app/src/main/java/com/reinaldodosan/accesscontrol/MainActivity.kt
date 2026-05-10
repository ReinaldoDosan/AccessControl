package com.reinaldodosan.accesscontrol

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


//Bloco 1
class MainActivity : AppCompatActivity() {

    // Bloco 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val editAge =
            findViewById<EditText>(R.id.editAge) /*Procure o EditText que possui o ID editAge e guarde ele na variável editAge.*/

        val checkDocuments = findViewById<CheckBox>(R.id.checkDocuments)
        val checkAccompanied = findViewById<CheckBox>(R.id.checkAccompanied)
        val checkBlock = findViewById<CheckBox>(R.id.checkBlocked)
        val btnVerify = findViewById<Button>(R.id.btnVerify)
        val textResult = findViewById<TextView>(R.id.textResult)

        //bloco 3
        btnVerify.setOnClickListener {
            val age = editAge.text.toString().toIntOrNull()

            //Bloco 4
            if (age == null) {
                textResult.text = "❌ Enter a valid age"
                textResult.setTextColor(getColor(android.R.color.holo_red_dark))
                return@setOnClickListener
            }

            //Bloco 5
            if (age < 18) {
                textResult.text = "❌ Minor, access denied"
                textResult.setTextColor(getColor(android.R.color.holo_red_dark))
                return@setOnClickListener
            }

            val checkDocuments = checkDocuments.isChecked
            val checkAccompanied = checkAccompanied.isChecked
            val checkBlock = checkBlock.isChecked
            val access = (age >= 18) && (checkDocuments || checkAccompanied) && !checkBlock

            //Bloco 6
            if (access) {
                textResult.text = "✅ Authorized access "
                textResult.setTextColor(getColor(android.R.color.holo_green_dark))
                Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()


                //Bloco 7
            } else {
                textResult.text = "❌ Access denied"
                textResult.setTextColor(getColor(android.R.color.holo_red_dark))
                Toast.makeText(this, "Access denied", Toast.LENGTH_SHORT).show()

            }


        }


    }
}