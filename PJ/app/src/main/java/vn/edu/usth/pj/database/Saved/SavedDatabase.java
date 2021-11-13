package vn.edu.usth.pj.Database.Saved;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Saved.class}, version = 3)
public abstract class SavedDatabase extends RoomDatabase {
    private static final String DATABASE_NAME ="saved.db";
    private static SavedDatabase instance;

    public static synchronized SavedDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), SavedDatabase.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract SaveDAO saveDAO();
}
