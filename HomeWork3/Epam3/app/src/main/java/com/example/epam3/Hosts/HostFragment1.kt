package com.example.epam3.Hosts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.epam3.Fragments.FirstFragment
import com.example.epam3.R

class HostFragment1 : Fragment(R.layout.fragment_host) {
    private lateinit var fragment1: FirstFragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (savedInstanceState == null) {
            fragment1 = FirstFragment()

            childFragmentManager.beginTransaction().apply {

                setReorderingAllowed(true)
                add(R.id.fragment_container_view_host, fragment1, "FIRST_FRAGMENT")
                addToBackStack(null)

                commit()
            }
        } else {
            fragment1 = childFragmentManager.findFragmentByTag("FIRST_FRAGMENT") as FirstFragment
        }

    }

}