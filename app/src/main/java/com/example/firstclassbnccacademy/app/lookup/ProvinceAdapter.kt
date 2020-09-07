package com.example.firstclassbnccacademy.app.lookup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstclassbnccacademy.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.province_recycler_item.view.*

class ProvinceAdapter: RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {

    private val provinceData = mutableListOf<ProvinceData>()

    fun setData(newData: List<ProvinceData>) {
        provinceData.apply {
            clear()
            addAll(newData)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder
            = ProvinceViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.province_recycler_item, parent, false))

    override fun getItemCount() = provinceData.size

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) = holder.bind(provinceData.get(position))

    class ProvinceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(provinceData: ProvinceData?) {
            itemView.apply {
                tv_province_name?.text = provinceData?.name.orEmpty()
                tv_province_death?.text = provinceData?.deathCase?.toString()
                tv_province_pos?.text = provinceData?.positiveCase?.toString()
                tv_province_rec?.text = provinceData?.recoveredCase?.toString()
            }
        }
    }
}