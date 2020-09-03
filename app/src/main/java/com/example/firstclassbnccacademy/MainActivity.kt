package com.example.firstclassbnccacademy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        cl_lookup?.setOnClickListener {
            it.context?.let { context ->
                val intent = Intent(context, LookUpActivity::class.java).apply {
                    putExtra("key", "Print something")
                }
                context.startActivity(intent)
            }
        }
    }

}