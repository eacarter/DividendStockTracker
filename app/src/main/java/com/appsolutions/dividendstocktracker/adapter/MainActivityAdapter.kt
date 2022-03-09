package com.appsolutions.dividendstocktracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.appsolutions.dividendstocktracker.R
import com.appsolutions.dividendstocktracker.data.Ticker
import com.appsolutions.dividendstocktracker.util.DollarFormatter
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivityAdapter(private val tickers: List<Ticker>) :
    Adapter<MainActivityAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainActivityAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_dividend, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainActivityAdapter.ViewHolder, position: Int) {
        val dollarFormatter = DollarFormatter()
        val item = tickers[position]

        holder.symbolItem.text = item.tickerSymbol

        holder.nosItem.text= "$"+ dollarFormatter.DecimalFormatter(item.tickerCashAmt)
        holder.annual.text = "$"+ dollarFormatter.DecimalFormatter((item.tickerCashAmt * item.tickerNumShares) * item.tickerFrequency)
    }

    override fun getItemCount(): Int {
        return tickers.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val symbolItem = v.findViewById<TextView>(R.id.symbol_text)!!
        val nosItem = v.findViewById<TextView>(R.id.nos_text)!!
        val annual = v.findViewById<TextView>(R.id.annual_text)!!
    }
}