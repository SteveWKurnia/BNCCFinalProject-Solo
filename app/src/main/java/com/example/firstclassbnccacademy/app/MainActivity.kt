package com.example.firstclassbnccacademy.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.firstclassbnccacademy.R
import com.example.firstclassbnccacademy.data.UtilityHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getIndonesiaTotalCases()
        viewModel.getIndonesiaPositiveCases()
    }

    override fun onStart() {
        super.onStart()
        setupIntentToLookUp()
        viewModel.totalCase.observe(this, getTotalCaseObserver)
        viewModel.positiveCases.observe(this, getPositiveCaseObserver)
    }

    private fun setupIntentToLookUp() {
        cl_lookup?.setOnClickListener {
            it.context?.let { context ->
                val intent = Intent(context, LookUpActivity::class.java).apply {
                    putExtra(EXTRA, "Print something")
                }
                context.startActivity(intent)
            }
        }
    }

    private var getTotalCaseObserver: Observer<String> = Observer {
        pb_load_total_case?.visibility = View.GONE
        group_total_case?.visibility = View.VISIBLE
        tv_total_case?.text = it.orEmpty()
    }

    private var getPositiveCaseObserver: Observer<String> = Observer {
        pb_positive_case?.visibility = View.GONE
        ll_positive_case?.visibility = View.VISIBLE
        tv_positive_case?.text = it.orEmpty()
    }

    companion object {
        const val EXTRA = "key"
    }

}