package com.example.TrackYourSleep

import android.widget.RatingBar

/**
 * This callback handles the rating of an individual sleep.
 */
class SleepRateCallback(
    private val viewModel: SleepViewModel,
    private val sleep: Sleep
) : RatingBar.OnRatingBarChangeListener {
    override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
        if (sleep.rating != rating.toLong()) {
            sleep.rating = rating.toLong()
            viewModel.updateSleep(sleep)
        }
    }
}
