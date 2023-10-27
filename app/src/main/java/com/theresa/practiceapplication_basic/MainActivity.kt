package com.theresa.practiceapplication_basic

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import com.theresa.practiceapplication_basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ViewBinding enabled in build.gradle file
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Call the superclass onCreate to complete the creation of
        // the activity, like the view hierarchy.
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        // Set the user interface layout for this activity.
        // setContentView(R.layout.activity_main)
        setContentView(binding.root)

        // command + b to go to corresponding element in xml file
        binding.button.setOnClickListener {
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
        }

        binding.buttonSample.setOnClickListener {
            startActivity(Intent(this@MainActivity, AlbumActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        d("MainActivity onStart", "MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        d("MainActivity onResume","MainActivity onResume")
    }


    override fun onPause() {
        super.onPause()
        d("MainActivity onPause", "MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        d("MainActivity onStop", "MainActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        d("MainActivity onDestroy", "MainActivity onDestroy")
    }


}