@file:Suppress("unused")

package com.example.TrackYourSleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Shows stats, counting sleeps after a certain point in the past.
 */
class StatsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }
}

/* vim:set shiftwidth=4 softtabstop=4 expandtab: */
