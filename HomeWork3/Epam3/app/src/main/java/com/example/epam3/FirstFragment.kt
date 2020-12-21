package com.example.epam3

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.first_fragment.*


class FirstFragment : Fragment(R.layout.first_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val argumentManager = ArgumentManager()
        val counterValue = argumentManager.getCounter(arguments)


        textView.text = "$counterValue"

        fragment_container_view_tag1.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {

                
                setReorderingAllowed(true)
                add(
                    R.id.fragment_container_view_tag1,
                    FirstFragment::class.java,
                    argumentManager.createArguments(counterValue + 1)
                )
                addToBackStack(null)

                commit()
            }
        }

    }
}