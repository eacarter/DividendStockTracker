package com.appsolutions.dividendstocktracker.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.appsolutions.dividendstocktracker.R
import com.appsolutions.dividendstocktracker.viewmodels.AddTickerViewModel
import com.appsolutions.dividendstocktracker.viewmodels.MainViewModel
import com.google.android.material.snackbar.Snackbar

class AddTickerDialog : DialogFragment() {

    private val viewModel: AddTickerViewModel by activityViewModels()


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.dialog_add_ticker, null)

            var symbol = view.findViewById<EditText>(R.id.ticker_edittext)
            var numOS = view.findViewById<EditText>(R.id.num_shares_edittext)
            var costPS = view.findViewById<EditText>(R.id.cps_edittext)

            builder.setView(view)
                // Add action buttons
                .setPositiveButton("Add",
                    DialogInterface.OnClickListener { dialog, id ->
                        if(symbol.text.isEmpty() || numOS.text.isEmpty() || costPS.text.isEmpty()){
//                            Snackbar.make(view, "One or More Fields aren't full ", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show()
                        }
                        else{
                            var num = numOS.text.toString()
                            var cost = costPS.text.toString()
                            viewModel.getDividend(symbol.text.toString(), num.toDouble(), cost.toDouble()).observe(this) {
                                if (it != null) {
                                    Snackbar.make(view, "Ticker Added ", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show()
                                }
                            }
                        }
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()!!.dismiss()
                    })
            builder.create()




        }?: throw IllegalStateException("Activity cannot be null")

    }
}