package com.example.epam3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import com.example.epam3.Hosts.HostFragment1
import com.example.epam3.Hosts.HostFragment2

class MainActivity : AppCompatActivity() {

    private lateinit var buttonLeft: Button
    private lateinit var buttonRight: Button
    private lateinit var fragment1: HostFragment1
    private lateinit var fragment2: HostFragment2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonLeft = findViewById(R.id.buttonLeft)
        buttonRight = findViewById(R.id.buttonRight)


        if (savedInstanceState == null) {

            fragment1 = HostFragment1()
            fragment2 = HostFragment2()

            supportFragmentManager.beginTransaction().apply {

                setReorderingAllowed(true)
                add(R.id.fragment_container_view_tag_first, fragment2, "SECOND")
                add(R.id.fragment_container_view_tag_first, fragment1, "FIRST")
                setPrimaryNavigationFragment(fragment1)
                hide(fragment2)
                show(fragment1)

                commit()
            }
        }
        else{
            fragment1 = supportFragmentManager.findFragmentByTag("FIRST") as HostFragment1
            fragment2 = supportFragmentManager.findFragmentByTag("SECOND") as HostFragment2

        }


        buttonLeft.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {

                setPrimaryNavigationFragment(fragment1)
                hide(fragment2)
                show(fragment1)
                commit()
            }

        }


        buttonRight.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                setPrimaryNavigationFragment(fragment2)
                hide(fragment1)
                show(fragment2)
                commit()
            }

        }

    }

   


}


