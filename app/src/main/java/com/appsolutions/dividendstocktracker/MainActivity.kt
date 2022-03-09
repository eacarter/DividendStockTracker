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
import com.appsolutions.dividendstocktracker.util.DollarFormatter
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

        var dollarFormatter = DollarFormatter()

        var total = 0.0;

        viewModel.getTickerList().observe(this) {
            binding.mainRecyclerView.apply {
                adapter = MainActivityAdapter(it)
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            for(i in it){
                total += (i.tickerCashAmt * i.tickerNumShares) * i.tickerFrequency
            }
            binding.annualTotal.text = "$"+dollarFormatter.DecimalFormatter(total)

            total = 0.0
        }

        binding.fab.setOnClickListener { view ->

            AddTickerDialog().show(supportFragmentManager, "Ticker Dialog")

        }
    }
}