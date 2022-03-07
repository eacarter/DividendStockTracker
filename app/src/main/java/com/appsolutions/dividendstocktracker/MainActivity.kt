package com.appsolutions.dividendstocktracker

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.appsolutions.dividendstocktracker.adapter.MainActivityAdapter
import com.appsolutions.dividendstocktracker.databinding.ActivityMainBinding
import com.appsolutions.dividendstocktracker.dialog.AddTickerDialog
import com.appsolutions.dividendstocktracker.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.getTickerList().observe(this, {
            binding.mainRecyclerView.apply{
                adapter = MainActivityAdapter(it)
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        })

        binding.fab.setOnClickListener { view ->

            AddTickerDialog().show(supportFragmentManager, "Ticker Dialog")

            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}