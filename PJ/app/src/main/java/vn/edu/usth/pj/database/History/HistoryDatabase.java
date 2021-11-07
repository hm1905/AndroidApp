package vn.edu.usth.pj.database.History;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import vn.edu.usth.pj.History.History;


@Database(entities = {History.class}, version = 1)
public abstract class HistoryDatabase extends RoomDatabase {
    private static final String DATABASE_NAME ="History.db";
    private static HistoryDatabase instance;

    public static synchronized HistoryDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), HistoryDatabase.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract HistoryDAO historyDAO();
}

