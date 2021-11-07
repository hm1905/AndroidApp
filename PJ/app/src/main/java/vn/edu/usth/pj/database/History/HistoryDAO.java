package vn.edu.usth.pj.database.History;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import vn.edu.usth.pj.History.History;

@Dao
public interface HistoryDAO {
    @Query("SELECT * FROM History")
    List<History> getAll();

    @Query("SELECT * FROM History WHERE pageid IN (:History_int)")
    List<History> loadAllByIds(int[] History_int);

    @Insert(onConflict = IGNORE)
    void insertAll(History history);

    @Delete
    void delete(History history);

    @Query("DELETE FROM History")
    void deleteAll();
}
