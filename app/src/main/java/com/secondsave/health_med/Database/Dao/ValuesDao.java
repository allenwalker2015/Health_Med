package com.secondsave.health_med.Database.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.secondsave.health_med.Database.Entities.IMCEntry;

import java.util.List;

@Dao
public interface ValuesDao {
    @Insert
    void insert(IMCEntry imcEntry);

    @Query("DELETE FROM imc_entry")
    void deleteAll();

    @Query("DELETE FROM imc_entry WHERE id_values=:id")
    void deleteById(int id);

    @Query("DELETE FROM imc_entry WHERE username LIKE :username")
    void deleteAllValuesByUsername(String username);

    @Query("SELECT * FROM imc_entry ORDER BY username ASC")
    LiveData<List<IMCEntry>> getAllValues();

    @Query("SELECT * FROM imc_entry WHERE username LIKE :username ORDER BY create_date ASC ")
    LiveData<List<IMCEntry>> getAllValuesByUsername(String username);


    @Query("SELECT COUNT(*)  FROM imc_entry WHERE username LIKE :username")
    int countValuesByUsername(String username);
//
//    @Query("UPDATE imc_entry set initial=1 (SELECT id_values FROM imc_entry ORDER BY create_date DESC LIMIT 1)")
//    int countValuesByUsername(String username);


}
