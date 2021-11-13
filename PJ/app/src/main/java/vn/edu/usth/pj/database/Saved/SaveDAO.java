package vn.edu.usth.pj.Database.Saved;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SaveDAO {
    @Query("SELECT * FROM Saved")
    List<Saved> getAll();

    @Query("SELECT * FROM Saved WHERE pageid IN (:Saved_int)")
    List<Saved> loadAllByIds(int[] Saved_int);

    @Insert(onConflict = IGNORE)
    void insertAll(Saved save_page);

    @Delete
    void delete(Saved save_page);

    @Query("DELETE FROM Saved")
    void deleteAll();

}
