package com.example.bnccfinalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstclassbnccacademy.R
import com.example.firstclassbnccacademy.app.hotline.Hotline
import com.example.firstclassbnccacademy.app.hotline.HotlineAdapter
import com.example.firstclassbnccacademy.app.hotline.HotlineViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.modal_hotline_bottom_sheet.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException
import java.lang.Exception

@AndroidEntryPoint
class HotlineDialogFragment: BottomSheetDialogFragment() {

    private lateinit var adapter: HotlineAdapter

//    private val okHttp = OkHttpClient()

    private val viewModel: HotlineViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getHotlineDatas()
//        val request = Request.Builder()
//            .url("https://bncc-corona-versus.firebaseio.com/v1/hotlines.json")
//            .build()
//
//        okHttp
//            .newCall(request)
//            .enqueue(object: Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    this@HotlineDialogFragment.activity?.runOnUiThread{
//                        Toast.makeText(this@HotlineDialogFragment.context, e.message, Toast.LENGTH_SHORT).show()
//                        adapter.setItems(listOf())
//                    }
//                }
//
//                override fun onResponse(call: Call, response: Response) {
//                    try {
//                        val jsonString = response.body?.string()
//                        val jsonArr = JSONArray(jsonString)
//                        val hotlineListFromNetwork = mutableListOf<Hotline>()
//
//                        for (i in 0 until jsonArr.length()) {
//                            hotlineListFromNetwork.add(
//                                Hotline(
//                                    jsonArr.getJSONObject(i).getString("img_icon"),
//                                    jsonArr.getJSONObject(i).getString("phone"),
//                                    jsonArr.getJSONObject(i).getString("name")
//                                )
//                            )
//                        }
//
//                        this@HotlineDialogFragment.activity?.runOnUiThread {
//                            pb_hotline?.visibility = View.GONE
//                            rv_hotline?.visibility = View.VISIBLE
//                            adapter.setItems(hotlineListFromNetwork)
//                        }
//                    } catch (e: Exception) {
//                        this@HotlineDialogFragment.activity?.runOnUiThread{
//                            Toast.makeText(this@HotlineDialogFragment.context, e.message, Toast.LENGTH_SHORT).show()
//                            adapter.setItems(listOf())
//                        }
//                    }
//
//                }
//
//            })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =  inflater.inflate(R.layout.modal_hotline_bottom_sheet, container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecycler()
        setupCloseButton()
        viewModel.hotlineDatas.observe(this, observer)
    }

    private fun setupCloseButton() {
        iv_close?.setOnClickListener{
            dismiss()
        }
    }

    private fun setupRecycler() {
        setupAdapter()
        rv_hotline?.apply {
            adapter = this@HotlineDialogFragment.adapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setupAdapter() {
        adapter = HotlineAdapter()
    }

    private val observer: Observer<List<Hotline>> = Observer {
        pb_hotline?.visibility = View.GONE
        rv_hotline?.visibility = View.VISIBLE
        adapter.setItems(it)
    }

    private fun mockData(): List<Hotline> =
        listOf<Hotline>(
            Hotline("","021-5210-411","Kementrian Kesehatan"),
            Hotline("","0812-1212-3119","Kementrian Kesehatan"),
            Hotline("","112","Pemprov DKI Jakarta"),
            Hotline("","0813-8837-6955","Pemprov DKI Jakarta"),
            Hotline("","024-358-0713","Pemprov Jawa Tengah"),
            Hotline("","0823-1360-0560","Pemprov Jawa Tengah"),
            Hotline("","031-843-0313","Pemprov Jawa Timur"),
            Hotline("","0813-3436-7800","Pemprov Jawa Timur"),
            Hotline("","119","Pemprov Jawa Barat"),
            Hotline("","0811-209-3306","Pemprov Jawa Barat"),
            Hotline("","0274-555-585","Pemprov D.I Yogyakarta"),
            Hotline("","0811-2764-800","Pemprov D.I Yogyakarta")
        )

    companion object {

        fun show(fragmentManager: FragmentManager) {
            val dialogFragment = HotlineDialogFragment()
            dialogFragment.show(fragmentManager, dialogFragment.tag)
        }

    }
}