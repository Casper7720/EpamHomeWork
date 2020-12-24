package com.example.epam3.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.epam3.ArgumentManager
import com.example.epam3.R
import kotlinx.android.synthetic.main.first_fragment.*


class FirstFragment : Fragment(R.layout.first_fragment) {
    private var counterValue = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val argumentManager = ArgumentManager()
        counterValue = argumentManager.getCounter(arguments)

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