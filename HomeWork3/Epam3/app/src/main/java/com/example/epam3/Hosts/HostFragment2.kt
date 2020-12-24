package com.example.epam3.Hosts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.epam3.R
import com.example.epam3.Fragments.SecondFragment

class HostFragment2 : Fragment(R.layout.fragment_host) {
    private lateinit var fragment2: SecondFragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            fragment2 = SecondFragment()

            childFragmentManager.beginTransaction().apply {

                setReorderingAllowed(true)
                add(R.id.fragment_container_view_host, fragment2, "FIRST_SECOND")
                addToBackStack(null)

                commit()
            }
        } else {
            fragment2 = childFragmentManager.findFragmentByTag("FIRST_SECOND") as SecondFragment
        }

    }
}