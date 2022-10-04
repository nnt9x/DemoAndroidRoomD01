package com.example.demoandroidroomd01;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo(name = "contact")
    public String contact;

    @Override
    public String toString() {
        return contact;
    }
}
