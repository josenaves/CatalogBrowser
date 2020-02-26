package com.josenaves.catalogbrowser

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter

class CardPresenter : Presenter() {

    private companion object {
        private const val TAG = "CardPresenter"
        private const val CARD_WIDTH = 313
        private const val CARD_HEIGHT = 176
    }

    private lateinit var ctx: Context
    private lateinit var defaultCardImage: Drawable

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        ctx = parent.context
        defaultCardImage = ctx.resources.getDrawable(R.drawable.lb_ic_hq, null)

        val imageCardView = ImageCardView(ctx)
        return ViewHolder(imageCardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val movie = item as Movie
        val cardView = viewHolder.view as ImageCardView

        cardView.mainImage = defaultCardImage
        cardView.titleText = movie.title
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        Log.d(TAG, "onUnbindViewHolder")
        val cardView = viewHolder.view as ImageCardView

        // Remove references to images so that the garbage collector can free up memory
        cardView.badgeImage = null
        cardView.mainImage = null
    }
}