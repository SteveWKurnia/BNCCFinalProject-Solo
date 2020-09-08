package com.example.firstclassbnccacademy.app.info

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.firstclassbnccacademy.R
import kotlinx.android.synthetic.main.information_dialog.*

class InformationDialog: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.information_dialog, container, false)
        dialog?.setTitle("")
        return view
    }

    override fun onStart() {
        super.onStart()
        setupCloseButton()
        setupDialogSize()
    }

    private fun setupCloseButton() {
        btn_close?.setOnClickListener {
            dialog?.dismiss()
        }
    }

    private fun setupDialogSize() {
        dialog?.window?.setLayout(Resources.getSystem().displayMetrics.widthPixels-100, Resources.getSystem().displayMetrics.heightPixels/3*2)
        dialog?.window?.setBackgroundDrawable(this.context?.let { ContextCompat.getDrawable(it, R.drawable.shape_rounded_25dp) })
    }

}