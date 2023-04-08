package com.example.aidietplanner_v1.Kotlin.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aidietplanner_v1.Kotlin.Binders.DataBinder
import com.example.aidietplanner_v1.Kotlin.Utils.BaseModel

open abstract class GenericAdapter(private val list: ArrayList<BaseModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewMapping = mutableMapOf<Int, DataBinder<*>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getBinder<DataBinder<*>>(viewType).newViewHolder(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].getModel()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getBinder<DataBinder<RecyclerView.ViewHolder>>(getItemViewType(position)).bindViewHolder(holder, position)
    }

    fun addBinder(viewType: Int, binder: DataBinder<*>){
        viewMapping[viewType] = binder
    }

    private fun <D: DataBinder<*>>getBinder(viewType: Int): D{
        return viewMapping[viewType]!! as D
    }

    fun getData(position: Int): BaseModel{
        return list[position]
    }
}

