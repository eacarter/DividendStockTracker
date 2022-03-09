package com.appsolutions.dividendstocktracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.appsolutions.dividendstocktracker.databinding.ActivityStockInfoBinding
import com.appsolutions.dividendstocktracker.viewmodels.StockInfoViewModel

class StockInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStockInfoBinding

    private val viewModel: StockInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityStockInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}