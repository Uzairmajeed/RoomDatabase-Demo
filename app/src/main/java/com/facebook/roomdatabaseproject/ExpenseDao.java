package com.facebook.roomdatabaseproject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenseDao {
    @Query("Select * from Tb_Exp")
    public List<Expense>getALlExpense();

    @Insert
    public void addTx(Expense expense);
    @Update
    public void updateTx(Expense expense);
    @Delete
    public void deleteTx(Expense expense);
}
