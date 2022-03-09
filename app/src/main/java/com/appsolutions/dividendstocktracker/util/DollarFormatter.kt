package com.appsolutions.dividendstocktracker.util

import java.math.RoundingMode
import java.text.DecimalFormat

class DollarFormatter () {

    fun DecimalFormatter(dollar: Double): String{
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING

        return df.format(dollar).toString()
    }

}