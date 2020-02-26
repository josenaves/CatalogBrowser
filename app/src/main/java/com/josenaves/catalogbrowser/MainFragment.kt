package com.josenaves.catalogbrowser

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*

class MainFragment : BrowseSupportFragment() {

    companion object {
        const val TAG = "MainFragment"
    }

    private val movies = listOf(
        Movie(1, "drama", "Chernobyl"),
        Movie(2, "comedy", "Superbad"),
        Movie(3, "western", "The Quick and the Dead"),
        Movie(4, "action", "Spiderman Homecoming"),
        Movie(5, "action", "Avengers: Infinity Wars"),
        Movie(6, "horror", "Evil Dead")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        buildRowsAdapter()
    }

    private fun buildRowsAdapter() {
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        var i = 0
        val categories = getCategories()
        Log.d(TAG, "Categories: $categories")

        categories.forEach { category ->
            val listRowAdapter = ArrayObjectAdapter(CardPresenter()).apply {
                val moviesFromCategory = getMoviesByCategory(category)
                Log.d(TAG, "moviesFromCategory: $moviesFromCategory")

                addAll(0, moviesFromCategory)
            }

            HeaderItem(i.toLong(), category).also { header ->
                rowsAdapter.add(ListRow(header, listRowAdapter))
            }
            i++
        }
        adapter = rowsAdapter
    }

    private fun setupUi() {
        val ctx = requireContext()
        brandColor = ContextCompat.getColor(ctx, R.color.primary)
        title = "Catalog Browser"
    }

    private fun getCategories() = movies.distinctBy { it.category }.map { it.category }

    private fun getMoviesByCategory(category: String) = movies.filter { it.category == category }
}