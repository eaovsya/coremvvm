package com.github.eaovsya.coremvvm.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Base [ListAdapter] for items with ViewBinding
 * Items of [ViewDataListAdapter] need to extend [ListAdapterItem]
 */
open class ViewDataListAdapter :
    ListAdapter<ListAdapterItem, ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false).rootView)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).bindToHolder(holder)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).layoutId()
    }

    private class DiffCallback : DiffUtil.ItemCallback<ListAdapterItem>() {
        override fun areItemsTheSame(
            oldItem: ListAdapterItem,
            newItem: ListAdapterItem
        ): Boolean {
            return oldItem.isSame(newItem)
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: ListAdapterItem,
            newItem: ListAdapterItem
        ): Boolean {
            return oldItem.isContentSame(newItem)
        }
    }
}