package com.example.TrackYourSleep

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.preference.PreferenceManager
import java.util.Calendar
import java.util.Date
import kotlinx.coroutines.launch

/**
 * This is the view model of MainActivity, providing coroutine scopes.
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val preferences = PreferenceManager.getDefaultSharedPreferences(application)

    val durationSleepsLive: LiveData<List<Sleep>> =
        preferences.liveData("dashboard_duration", "0").switchMap { durationStr ->
            val duration = durationStr?.toInt() ?: 0
            val date = if (duration == 0) {
                Date(0)
            } else {
                val cal = Calendar.getInstance()
                cal.add(Calendar.DATE, duration)
                cal.time
            }
            DataModel.getSleepsAfterLive(date)
        }

    fun stopSleep(context: Context, cr: ContentResolver) {
        viewModelScope.launch {
            DataModel.storeSleep()
            DataModel.backupSleeps(context, cr)
        }
    }

    fun exportDataToFile(context: Context, cr: ContentResolver, uri: Uri, showToast: Boolean) {
        viewModelScope.launch {
            DataModel.exportDataToFile(context, cr, uri, showToast)
        }
    }

    fun importDataFromCalendar(context: Context, calendarId: String) {
        viewModelScope.launch {
            DataModel.importDataFromCalendar(context, calendarId)
        }
    }

    fun exportDataToCalendar(context: Context, calendarId: String) {
        viewModelScope.launch {
            DataModel.exportDataToCalendar(context, calendarId)
        }
    }

    fun importData(context: Context, cr: ContentResolver, uri: Uri) {
        viewModelScope.launch {
            DataModel.importData(context, cr, uri)
        }
    }

    fun insertSleep(sleep: Sleep) {
        viewModelScope.launch {
            DataModel.insertSleep(sleep)
        }
    }

    fun deleteSleep(sleep: Sleep, context: Context, cr: ContentResolver) {
        viewModelScope.launch {
            DataModel.deleteSleep(sleep)
            DataModel.backupSleeps(context, cr)
        }
    }

    fun deleteAllSleep() {
        viewModelScope.launch {
            DataModel.deleteAllSleep()
        }
    }
}

/* vim:set shiftwidth=4 softtabstop=4 expandtab: */
