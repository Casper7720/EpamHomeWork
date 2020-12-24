package com.example.epam3.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.epam3.ArgumentManager
import com.example.epam3.R
import kotlinx.android.synthetic.main.second_fragment.*
import kotlinx.android.synthetic.main.second_fragment.textView

class SecondFragment : Fragment(R.layout.second_fragment) {
    private var counterValue: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val argumentManager = ArgumentManager()
        counterValue = argumentManager.getCounter(arguments)


        textView.text = "$counterValue"

        fragment_container_view_tag2.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {


                setReorderingAllowed(true)
                add(
                    R.id.fragment_container_view_tag2,
                    SecondFragment::class.java,
                    argumentManager.createArguments(counterValue + 1)
                )
                addToBackStack(null)

                commit()

            }
        }

    }

}