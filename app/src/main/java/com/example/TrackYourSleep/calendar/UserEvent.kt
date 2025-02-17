package com.example.TrackYourSleep.calendar

import android.database.Cursor

/**
 * Represents a single event record, as found in a user's calendar
 */
class UserEvent(cursor: Cursor) {

    val id: String = cursor.getString(CalendarImport.EVENT_PROJECTION_ID)
    val calendarId: String = cursor.getString(CalendarImport.EVENT_PROJECTION_CAL_ID)
    val title: String = cursor.getString(CalendarImport.EVENT_PROJECTION_TITLE)
    val start: Long = cursor.getLong(CalendarImport.EVENT_PROJECTION_START)
    val end: Long = cursor.getLong(CalendarImport.EVENT_PROJECTION_END)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserEvent

        if (id != other.id) return false
        if (calendarId != other.calendarId) return false
        if (title != other.title) return false
        if (start != other.start) return false
        if (end != other.end) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + calendarId.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + start.hashCode()
        result = 31 * result + end.hashCode()
        return result
    }

    override fun toString(): String {
        return """
        UserEvent(id='$id', calendarId='$calendarId', title='$title', start='$start', end='$end')
        """.trimIndent()
    }
}

/* vim:set shiftwidth=4 softtabstop=4 expandtab: */
