package com.example.travelapp.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.travelapp.R
import com.example.travelapp.data.Attraction
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    val attractionList: List<Attraction> by lazy {
        parseAttraction()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
       navController = navHostFragment.navController

        }
    private fun parseAttraction():ArrayList<Attraction> {
        val textFromFile = resources.openRawResource(R.raw.attraction).bufferedReader().use { it.readText() }
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

        val type = Types.newParameterizedType(
            List::class.java,
            Attraction::class.java
        )
        val adapter = moshi.adapter<List<Attraction>>(type)
        return adapter.fromJson(textFromFile) as ArrayList<Attraction>

    }
    }
