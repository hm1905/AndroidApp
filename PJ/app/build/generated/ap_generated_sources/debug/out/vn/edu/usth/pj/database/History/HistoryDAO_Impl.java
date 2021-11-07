package vn.edu.usth.pj.database.History;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import vn.edu.usth.pj.History.History;

@SuppressWarnings({"unchecked", "deprecation"})
public final class HistoryDAO_Impl implements HistoryDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<History> __insertionAdapterOfHistory;

  private final EntityDeletionOrUpdateAdapter<History> __deletionAdapterOfHistory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public HistoryDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHistory = new EntityInsertionAdapter<History>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `History` (`pageid`,`title`,`thumbnail`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, History value) {
        if (value.getPageid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getPageid());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getThumbnail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThumbnail());
        }
      }
    };
    this.__deletionAdapterOfHistory = new EntityDeletionOrUpdateAdapter<History>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `History` WHERE `pageid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, History value) {
        if (value.getPageid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getPageid());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM History";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final History history) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfHistory.insert(history);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final History history) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfHistory.handle(history);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<History> getAll() {
    final String _sql = "SELECT * FROM History";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPageid = CursorUtil.getColumnIndexOrThrow(_cursor, "pageid");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail");
      final List<History> _result = new ArrayList<History>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final History _item;
        final Integer _tmpPageid;
        if (_cursor.isNull(_cursorIndexOfPageid)) {
          _tmpPageid = null;
        } else {
          _tmpPageid = _cursor.getInt(_cursorIndexOfPageid);
        }
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpThumbnail;
        _tmpThumbnail = _cursor.getString(_cursorIndexOfThumbnail);
        _item = new History(_tmpPageid,_tmpTitle,_tmpThumbnail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<History> loadAllByIds(final int[] History_int) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("*");
    _stringBuilder.append(" FROM History WHERE pageid IN (");
    final int _inputSize = History_int.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : History_int) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPageid = CursorUtil.getColumnIndexOrThrow(_cursor, "pageid");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail");
      final List<History> _result = new ArrayList<History>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final History _item_1;
        final Integer _tmpPageid;
        if (_cursor.isNull(_cursorIndexOfPageid)) {
          _tmpPageid = null;
        } else {
          _tmpPageid = _cursor.getInt(_cursorIndexOfPageid);
        }
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpThumbnail;
        _tmpThumbnail = _cursor.getString(_cursorIndexOfThumbnail);
        _item_1 = new History(_tmpPageid,_tmpTitle,_tmpThumbnail);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
