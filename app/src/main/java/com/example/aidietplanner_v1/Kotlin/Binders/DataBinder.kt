package com.example.aidietplanner_v1.Kotlin.Binders

import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView

abstract class DataBinder<V> where V: RecyclerView.ViewHolder {

    abstract fun newViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    abstract fun bindViewHolder(holder: V, position: Int)
}