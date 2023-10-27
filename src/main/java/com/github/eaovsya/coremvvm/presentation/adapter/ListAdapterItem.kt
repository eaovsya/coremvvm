package com.github.eaovsya.coremvvm.presentation.adapter

abstract class ListAdapterItem (
    private val id: Long,
    private val layoutId: Int,
    private val content: Any,
    private val variableBindingId: Int
) {

    fun layoutId() = layoutId

    fun isSame(otherItem: ListAdapterItem) = id == otherItem.id && layoutId == otherItem.layoutId

    fun isContentSame(otherItem: ListAdapterItem) = content == otherItem.content

    fun bindToHolder(viewHolder: ViewHolder) = viewHolder.onBind(variableBindingId, content)
}