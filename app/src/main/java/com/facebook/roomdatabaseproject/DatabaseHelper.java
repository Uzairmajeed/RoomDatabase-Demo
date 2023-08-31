package com.facebook.roomdatabaseproject;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.database.sqlite.SQLiteDatabase;

@Database(entities = {Expense.class},version = 1,exportSchema = false)
public abstract class DatabaseHelper extends RoomDatabase {
    public abstract ExpenseDao expenseDao();

    private static final String DB_NAME="expense";
    private static DatabaseHelper instance;

    public  static synchronized DatabaseHelper getDB(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context,DatabaseHelper.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
