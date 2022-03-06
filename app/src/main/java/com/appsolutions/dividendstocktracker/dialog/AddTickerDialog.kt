package com.appsolutions.dividendstocktracker.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.appsolutions.dividendstocktracker.R
import com.appsolutions.dividendstocktracker.viewmodels.AddTickerViewModel
import com.appsolutions.dividendstocktracker.viewmodels.MainViewModel

class AddTickerDialog : DialogFragment() {

    private val viewModel: AddTickerViewModel by viewModels()


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            builder.setView(inflater.inflate(R.layout.dialog_add_ticker, null))
                // Add action buttons
                .setPositiveButton("Add",
                    DialogInterface.OnClickListener { dialog, id ->

                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()!!.cancel()
                    })
            builder.create()




        }?: throw IllegalStateException("Activity cannot be null")

    }
}