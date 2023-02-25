package com.lnavmon.practica1.iu.favourites

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

open class DeleteAllDialogFragment(private val listener: DeleteAllDialogListener) : DialogFragment() {

    interface DeleteAllDialogListener {
        fun onPositiveClick()
        fun onNegativeClick()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Delete all favourite quotations")
            .setMessage("Do you really want to delete all quotations?")
            .setPositiveButton("Yes") { _, _ ->
                listener.onPositiveClick()
            }
            .setNegativeButton("No") { _, _ ->
                listener.onNegativeClick()
            }
            .create()
    }
}