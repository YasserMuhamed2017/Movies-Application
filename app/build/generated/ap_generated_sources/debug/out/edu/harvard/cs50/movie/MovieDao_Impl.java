package edu.harvard.cs50.movie;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfInsert;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public MovieDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfInsert = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO movies (movie_id, poster_path, backdrop_path , vote_average, overview, release_date, popularity, vote_count, original_language, title) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return _query;
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM movies WHERE movie_id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final String movie_id, final String poster_path, final String backdrop_path,
      final String vote_average, final String overview, final String release_date,
      final String popularity, final String vote_count, final String original_language,
      final String title) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInsert.acquire();
    int _argIndex = 1;
    if (movie_id == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, movie_id);
    }
    _argIndex = 2;
    if (poster_path == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, poster_path);
    }
    _argIndex = 3;
    if (backdrop_path == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, backdrop_path);
    }
    _argIndex = 4;
    if (vote_average == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, vote_average);
    }
    _argIndex = 5;
    if (overview == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, overview);
    }
    _argIndex = 6;
    if (release_date == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, release_date);
    }
    _argIndex = 7;
    if (popularity == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, popularity);
    }
    _argIndex = 8;
    if (vote_count == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, vote_count);
    }
    _argIndex = 9;
    if (original_language == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, original_language);
    }
    _argIndex = 10;
    if (title == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, title);
    }
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInsert.release(_stmt);
    }
  }

  @Override
  public void delete(final String movie_id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    if (movie_id == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, movie_id);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public List<Movies> selectAll() {
    final String _sql = "SELECT movie_id, poster_path, backdrop_path , vote_average, overview, release_date, popularity, vote_count, original_language, title FROM movies";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false);
    try {
      final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
      final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdrop_path");
      final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_average");
      final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
      final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
      final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
      final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_count");
      final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "original_language");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final List<Movies> _result = new ArrayList<Movies>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Movies _item;
        final String _tmpPoster_path;
        _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
        final String _tmpBackdrop_path;
        _tmpBackdrop_path = _cursor.getString(_cursorIndexOfBackdropPath);
        final String _tmpVote_average;
        _tmpVote_average = _cursor.getString(_cursorIndexOfVoteAverage);
        final String _tmpOverview;
        _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
        final String _tmpRelease_date;
        _tmpRelease_date = _cursor.getString(_cursorIndexOfReleaseDate);
        final String _tmpPopularity;
        _tmpPopularity = _cursor.getString(_cursorIndexOfPopularity);
        final String _tmpVote_count;
        _tmpVote_count = _cursor.getString(_cursorIndexOfVoteCount);
        final String _tmpOriginal_language;
        _tmpOriginal_language = _cursor.getString(_cursorIndexOfOriginalLanguage);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _item = new Movies(null,_tmpPoster_path,_tmpBackdrop_path,_tmpVote_average,_tmpOverview,_tmpRelease_date,_tmpPopularity,_tmpVote_count,_tmpOriginal_language,_tmpTitle);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
