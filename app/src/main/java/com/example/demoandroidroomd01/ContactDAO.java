package com.example.demoandroidroomd01;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {
    // CRUD
    @Query("SELECT * FROM contacts")
    public List<Contact> getAll();

    @Query("SELECT * FROM contacts WHERE id=(:id)")
    public Contact getById(long id);

    @Insert
    public void insert(Contact...contacts);

    @Delete
    public void delete(Contact...contacts);

    @Update
    public void update(Contact...contacts);
}
