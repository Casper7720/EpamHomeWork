package com.example.epam3

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.first_fragment.*

class HostFragment1 : Fragment(R.layout.activity_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment1 = FirstFragment()

        parentFragmentManager.beginTransaction().apply {

            setReorderingAllowed(true)
            add(R.id.fragment_container_view_tag_first, fragment1)
            addToBackStack(null)

            commit()
        }


    }
}