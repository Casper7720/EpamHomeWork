package com.example.epam3

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class HostFragment2 : Fragment(R.layout.activity_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment2 = SecondFragment()

        childFragmentManager.beginTransaction().apply {

            setReorderingAllowed(true)
            add(R.id.fragment_container_view_tag_first, fragment2)
            addToBackStack(null)

            commit()
        }



    }
}