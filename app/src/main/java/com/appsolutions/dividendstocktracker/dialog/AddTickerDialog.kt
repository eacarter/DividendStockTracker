package com.appsolutions.dividendstocktracker.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.appsolutions.dividendstocktracker.R

class AddTickerDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            builder.setView(inflater.inflate(R.layout.dialog_add_ticker, null))
                // Add action buttons
                .setPositiveButton("Add",
                    DialogInterface.OnClickListener { dialog, id ->
                        // sign in the user ...
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()!!.cancel()
                    })
            builder.create()




        }?: throw IllegalStateException("Activity cannot be null")

    }
}