package com.example.TrackYourSleep;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SleepDao_Impl implements SleepDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Sleep> __insertionAdapterOfSleep;

  private final EntityDeletionOrUpdateAdapter<Sleep> __deletionAdapterOfSleep;

  private final EntityDeletionOrUpdateAdapter<Sleep> __updateAdapterOfSleep;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SleepDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSleep = new EntityInsertionAdapter<Sleep>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Sleep` (`sid`,`start_date`,`stop_date`,`rating`,`comment`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Sleep entity) {
        statement.bindLong(1, entity.getSid());
        statement.bindLong(2, entity.getStart());
        statement.bindLong(3, entity.getStop());
        statement.bindLong(4, entity.getRating());
        statement.bindString(5, entity.getComment());
      }
    };
    this.__deletionAdapterOfSleep = new EntityDeletionOrUpdateAdapter<Sleep>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Sleep` WHERE `sid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Sleep entity) {
        statement.bindLong(1, entity.getSid());
      }
    };
    this.__updateAdapterOfSleep = new EntityDeletionOrUpdateAdapter<Sleep>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Sleep` SET `sid` = ?,`start_date` = ?,`stop_date` = ?,`rating` = ?,`comment` = ? WHERE `sid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Sleep entity) {
        statement.bindLong(1, entity.getSid());
        statement.bindLong(2, entity.getStart());
        statement.bindLong(3, entity.getStop());
        statement.bindLong(4, entity.getRating());
        statement.bindString(5, entity.getComment());
        statement.bindLong(6, entity.getSid());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "delete from sleep";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final List<Sleep> sleepList, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSleep.insert(sleepList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insert(final Sleep sleep, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSleep.insert(sleep);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Sleep sleep, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSleep.handle(sleep);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Sleep sleep, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfSleep.handle(sleep);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<Sleep>> $completion) {
    final String _sql = "SELECT * FROM sleep ORDER BY sid ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Sleep>>() {
      @Override
      @NonNull
      public List<Sleep> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSid = CursorUtil.getColumnIndexOrThrow(_cursor, "sid");
          final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
          final int _cursorIndexOfStop = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_date");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final List<Sleep> _result = new ArrayList<Sleep>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Sleep _item;
            _item = new Sleep();
            final int _tmpSid;
            _tmpSid = _cursor.getInt(_cursorIndexOfSid);
            _item.setSid(_tmpSid);
            final long _tmpStart;
            _tmpStart = _cursor.getLong(_cursorIndexOfStart);
            _item.setStart(_tmpStart);
            final long _tmpStop;
            _tmpStop = _cursor.getLong(_cursorIndexOfStop);
            _item.setStop(_tmpStop);
            final long _tmpRating;
            _tmpRating = _cursor.getLong(_cursorIndexOfRating);
            _item.setRating(_tmpRating);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _item.setComment(_tmpComment);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Sleep>> getAllLive() {
    final String _sql = "SELECT * FROM sleep ORDER BY start_date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"sleep"}, false, new Callable<List<Sleep>>() {
      @Override
      @Nullable
      public List<Sleep> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSid = CursorUtil.getColumnIndexOrThrow(_cursor, "sid");
          final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
          final int _cursorIndexOfStop = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_date");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final List<Sleep> _result = new ArrayList<Sleep>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Sleep _item;
            _item = new Sleep();
            final int _tmpSid;
            _tmpSid = _cursor.getInt(_cursorIndexOfSid);
            _item.setSid(_tmpSid);
            final long _tmpStart;
            _tmpStart = _cursor.getLong(_cursorIndexOfStart);
            _item.setStart(_tmpStart);
            final long _tmpStop;
            _tmpStop = _cursor.getLong(_cursorIndexOfStop);
            _item.setStop(_tmpStop);
            final long _tmpRating;
            _tmpRating = _cursor.getLong(_cursorIndexOfRating);
            _item.setRating(_tmpRating);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _item.setComment(_tmpComment);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getById(final int id, final Continuation<? super Sleep> $completion) {
    final String _sql = "SELECT * from sleep where sid = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Sleep>() {
      @Override
      @NonNull
      public Sleep call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSid = CursorUtil.getColumnIndexOrThrow(_cursor, "sid");
          final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
          final int _cursorIndexOfStop = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_date");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final Sleep _result;
          if (_cursor.moveToFirst()) {
            _result = new Sleep();
            final int _tmpSid;
            _tmpSid = _cursor.getInt(_cursorIndexOfSid);
            _result.setSid(_tmpSid);
            final long _tmpStart;
            _tmpStart = _cursor.getLong(_cursorIndexOfStart);
            _result.setStart(_tmpStart);
            final long _tmpStop;
            _tmpStop = _cursor.getLong(_cursorIndexOfStop);
            _result.setStop(_tmpStop);
            final long _tmpRating;
            _tmpRating = _cursor.getLong(_cursorIndexOfRating);
            _result.setRating(_tmpRating);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _result.setComment(_tmpComment);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Sleep>> getAfterLive(final long after) {
    final String _sql = "SELECT * FROM sleep WHERE stop_date > ? ORDER BY start_date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, after);
    return __db.getInvalidationTracker().createLiveData(new String[] {"sleep"}, false, new Callable<List<Sleep>>() {
      @Override
      @Nullable
      public List<Sleep> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSid = CursorUtil.getColumnIndexOrThrow(_cursor, "sid");
          final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
          final int _cursorIndexOfStop = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_date");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final List<Sleep> _result = new ArrayList<Sleep>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Sleep _item;
            _item = new Sleep();
            final int _tmpSid;
            _tmpSid = _cursor.getInt(_cursorIndexOfSid);
            _item.setSid(_tmpSid);
            final long _tmpStart;
            _tmpStart = _cursor.getLong(_cursorIndexOfStart);
            _item.setStart(_tmpStart);
            final long _tmpStop;
            _tmpStop = _cursor.getLong(_cursorIndexOfStop);
            _item.setStop(_tmpStop);
            final long _tmpRating;
            _tmpRating = _cursor.getLong(_cursorIndexOfRating);
            _item.setRating(_tmpRating);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _item.setComment(_tmpComment);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
