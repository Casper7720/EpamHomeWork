package com.example.homework2

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var titleText : TextView
    private lateinit var editorText : EditText
    private lateinit var buttonCreator: Button
    private lateinit var time : TextClock


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleText = findViewById(R.id.textViewTitle)
        editorText = findViewById(R.id.editTextTitle)
        buttonCreator = findViewById(R.id.buttonCreator)
        time = findViewById(R.id.textClock)




        buttonCreator.setOnClickListener {
            if(!editorText.text.isEmpty()){
                titleText.text = editorText.text
                editorText.text = null
            }
            else{
                Toast.makeText(applicationContext, "Вы забыли ввести текст", Toast.LENGTH_LONG).show()
            }
        }

    }


    override fun onSaveInstanceState(outState: Bundle) {

        outState?.run {
            putString("Title", titleText.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        titleText.text = savedInstanceState?.getString("Title")
    }

}



