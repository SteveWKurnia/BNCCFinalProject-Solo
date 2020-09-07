package com.example.firstclassbnccacademy.app.lookup

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstclassbnccacademy.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_look_up.*

@AndroidEntryPoint
class LookUpActivity: AppCompatActivity() {

    private val viewModel: LookUpViewModel by viewModels()

    private lateinit var adapter: ProvinceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_look_up)
        setupDynamicStatusBarColor()
        setupRecycler()
        viewModel.getAllProvinceData()
    }

    override fun onStart() {
        super.onStart()
        setupBackButton()
        setupSearchView()
        viewModel.provinceData.observe(this, observer)
    }

    private fun setupDynamicStatusBarColor() {
        val view = this.window.decorView
        view.systemUiVisibility = view.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = ContextCompat.getColor(this,
            R.color.off_white
        )
    }

    private fun setupBackButton() {
        iv_back?.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun setupSearchView() {
        setupClearButton()
        setupLiveSearch()
        disableSearchViewClear()
    }

    private fun setupClearButton() {
        iv_clear?.setOnClickListener {
            sv_search.apply {
                setQuery("",false)
                clearFocus()
            }
        }
    }

    private fun setupLiveSearch() {
        sv_search?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun disableSearchViewClear() {
        val closeBtn = sv_search?.findViewById<ImageView>(R.id.search_close_btn)
        closeBtn?.isEnabled = false
        closeBtn?.setImageDrawable(null)
    }

    private fun setupRecycler() {
        adapter = ProvinceAdapter()
        rv_province?.apply {
            adapter = this@LookUpActivity.adapter
            this.layoutManager = LinearLayoutManager(this@LookUpActivity.baseContext, LinearLayoutManager.VERTICAL, false)
        }
    }

    private var observer: Observer<List<ProvinceData>> = Observer {
        pb_province?.visibility = View.GONE
        rv_province?.visibility = View.VISIBLE
        adapter.setData(it)
    }

}