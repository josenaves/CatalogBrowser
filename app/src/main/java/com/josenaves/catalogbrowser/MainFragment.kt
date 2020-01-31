package com.josenaves.catalogbrowser


import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.ListRowPresenter

class MainFragment : BrowseSupportFragment() {

    private lateinit var rowsAdapter: ArrayObjectAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        adapter = rowsAdapter

        val ctx = requireContext()
        brandColor = ContextCompat.getColor(ctx, R.color.primary)
        badgeDrawable = ContextCompat.getDrawable(ctx, R.mipmap.ic_launcher)
        title = "Catalog Browser"

    }

}