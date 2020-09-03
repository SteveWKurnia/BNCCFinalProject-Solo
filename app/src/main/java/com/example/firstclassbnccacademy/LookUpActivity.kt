package com.example.firstclassbnccacademy

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_look_up.*


class LookUpActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_look_up)
        setupDynamicStatusBarColor()
        val str = intent?.getStringExtra("key").orEmpty()
        tv_main?.text = str
    }

    override fun onStart() {
        super.onStart()
        setupBackButton()
    }

    private fun setupDynamicStatusBarColor() {
        val view = this.window.decorView
        view.systemUiVisibility = view.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        this.window.statusBarColor = ContextCompat.getColor(this, R.color.off_white)
    }

    private fun setupBackButton() {
        iv_back?.setOnClickListener {
            super.onBackPressed()
        }
    }

}