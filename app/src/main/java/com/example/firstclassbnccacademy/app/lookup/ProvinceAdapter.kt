package com.example.firstclassbnccacademy.app.lookup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.firstclassbnccacademy.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.province_recycler_item.view.*
import java.util.*

class ProvinceAdapter: RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>(), Filterable {

    private val provinceData = mutableListOf<ProvinceData>()

    private val filteredProvinceData = mutableListOf<ProvinceData>()

    fun setData(newData: List<ProvinceData>) {
        provinceData.apply {
            clear()
            addAll(newData)
        }
        filteredProvinceData.addAll(newData)
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

    override fun getFilter() = filter

    private val filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filtered = mutableListOf<ProvinceData>()
            if (constraint.isNullOrBlank()) {
                filtered.addAll(filteredProvinceData)
            } else {
                val filterPattern = constraint.toString().toLowerCase(Locale.ROOT).trim()
                for (i in provinceData.indices) {
                    if (provinceData.get(i).name.toLowerCase(Locale.ROOT).contains(filterPattern)){
                        filtered.add(provinceData.get(i))
                    }
                }
            }
            val filterResults = FilterResults()
            filterResults.values = filtered
            return filterResults
        }

        override fun publishResults(p0: CharSequence?, result: FilterResults?) {
            provinceData.apply {
                clear()
                addAll(result?.values as List<ProvinceData>)
            }
            notifyDataSetChanged()
        }
    }
}