package com.example.epam3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager as FragmentManager1

class MainActivity : AppCompatActivity() {

    private lateinit var buttonLeft: Button
    private lateinit var buttonRight: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttonLeft = findViewById(R.id.buttonLeft)
        buttonRight = findViewById(R.id.buttonRight)


        val fragment1 = FirstFragment()
        val fragment2 = SecondFragment()

        if (savedInstanceState == null) {


            supportFragmentManager.beginTransaction().apply {

                setReorderingAllowed(true)
                add(R.id.fragment_container_view_tag_first, fragment1)
                add(R.id.fragment_container_view_tag_second, fragment2)
                show(fragment1)
                hide(fragment2)
                addToBackStack(null)
                setPrimaryNavigationFragment(fragment1)

                commit()
            }
        }



        buttonLeft.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                setPrimaryNavigationFragment(fragment1)
                show(fragment1)
                hide(fragment2)
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


