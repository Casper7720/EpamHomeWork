package com.example.homework2

import android.icu.text.SimpleDateFormat
import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var titleText : TextView
    private lateinit var editorText : EditText
    private lateinit var buttonCreator: Button
    private lateinit var time : TextClock
    private lateinit var imgKakasgi : ImageView
    private lateinit var imgItachi : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleText = findViewById(R.id.textTitle)
        editorText = findViewById(R.id.editTextTitle)
        buttonCreator = findViewById(R.id.buttonCreator)
        time = findViewById(R.id.textClock)
        imgKakasgi = findViewById(R.id.imageView1)
        imgItachi = findViewById(R.id.imageView2)

        imgKakasgi.setOnClickListener {
            imgItachi.visibility = View.VISIBLE
            imgKakasgi.visibility = View.GONE
        }

        imgItachi.setOnClickListener {
            imgItachi.visibility = View.GONE
            imgKakasgi.visibility = View.VISIBLE
        }


        buttonCreator.setOnClickListener {
            if(editorText.text.isNotEmpty()){
                titleText.text = editorText.text
                editorText.text = null
            }
            else{
                Toast.makeText(applicationContext, "Вы забыли ввести текст", Toast.LENGTH_LONG).show()
            }
        }

    }


    override fun onSaveInstanceState(outState: Bundle) {

        outState.run {
            putString("Title", titleText.text.toString())
            if(imgItachi.isVisible){
                putString("Image", "Itachi")
            }

        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        titleText.text = savedInstanceState.getString("Title")
        if(savedInstanceState.get("Image") == "Itachi"){
            imgItachi.visibility = View.VISIBLE
            imgKakasgi.visibility = View.GONE
        }
    }

    override fun onStart() {
        super.onStart()
    }

}





