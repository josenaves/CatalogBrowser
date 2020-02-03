package com.josenaves.catalogbrowser

import android.view.ViewGroup
import android.widget.TextView
import androidx.leanback.widget.Presenter

class StringPresenter : Presenter() {

    companion object {
        const val TAG = "StringPresenter"
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val textView = TextView(parent.context).apply {
            isFocusable = true
            isFocusableInTouchMode = true
            background = parent.resources.getDrawable(R.drawable.lb_text_dot_one_small, null)
        }
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        (viewHolder.view as TextView).text = item.toString()
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
    }
}