package vn.edu.usth.pj.database;

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
import vn.edu.usth.pj.Save_Page;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SaveDAO_Impl implements SaveDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Save_Page> __insertionAdapterOfSave_Page;

  private final EntityDeletionOrUpdateAdapter<Save_Page> __deletionAdapterOfSave_Page;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SaveDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSave_Page = new EntityInsertionAdapter<Save_Page>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Saved` (`pageid`,`title`,`desc`,`thumbnail`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Save_Page value) {
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
        if (value.getDesc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDesc());
        }
        if (value.getThumbnail() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getThumbnail());
        }
      }
    };
    this.__deletionAdapterOfSave_Page = new EntityDeletionOrUpdateAdapter<Save_Page>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Saved` WHERE `pageid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Save_Page value) {
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
        final String _query = "DELETE FROM Saved";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final Save_Page save_page) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSave_Page.insert(save_page);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Save_Page save_page) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSave_Page.handle(save_page);
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
  public List<Save_Page> getAll() {
    final String _sql = "SELECT * FROM Saved";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPageid = CursorUtil.getColumnIndexOrThrow(_cursor, "pageid");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "desc");
      final int _cursorIndexOfThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail");
      final List<Save_Page> _result = new ArrayList<Save_Page>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Save_Page _item;
        final Integer _tmpPageid;
        if (_cursor.isNull(_cursorIndexOfPageid)) {
          _tmpPageid = null;
        } else {
          _tmpPageid = _cursor.getInt(_cursorIndexOfPageid);
        }
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpDesc;
        _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
        final String _tmpThumbnail;
        _tmpThumbnail = _cursor.getString(_cursorIndexOfThumbnail);
        _item = new Save_Page(_tmpTitle,_tmpDesc,_tmpPageid,_tmpThumbnail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Save_Page> loadAllByIds(final int[] Saved_int) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("*");
    _stringBuilder.append(" FROM Saved WHERE pageid IN (");
    final int _inputSize = Saved_int.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : Saved_int) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPageid = CursorUtil.getColumnIndexOrThrow(_cursor, "pageid");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "desc");
      final int _cursorIndexOfThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail");
      final List<Save_Page> _result = new ArrayList<Save_Page>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Save_Page _item_1;
        final Integer _tmpPageid;
        if (_cursor.isNull(_cursorIndexOfPageid)) {
          _tmpPageid = null;
        } else {
          _tmpPageid = _cursor.getInt(_cursorIndexOfPageid);
        }
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpDesc;
        _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
        final String _tmpThumbnail;
        _tmpThumbnail = _cursor.getString(_cursorIndexOfThumbnail);
        _item_1 = new Save_Page(_tmpTitle,_tmpDesc,_tmpPageid,_tmpThumbnail);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
