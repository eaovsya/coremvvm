package com.github.eaovsya.coremvvm.presentation.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ViewDataBinding = DataBindingUtil.bind(view)!!

    fun onBind(variableBindingId: Int, model: Any) {
        if (variableBindingId == 0) return
        binding.setVariable(variableBindingId, model)
    }
}