package com.facebook.roomdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1= findViewById(R.id.edittext1);
        editText2= findViewById(R.id.edittext2);
        button1= findViewById(R.id.button1);
        DatabaseHelper dataBaseHelper=DatabaseHelper.getDB(this);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=editText1.getText().toString();
                String amount=editText2.getText().toString();
                dataBaseHelper.expenseDao().addTx(new Expense(title,amount));
                fetchdetails();
            }
        });
    }
    public void fetchdetails(){
        DatabaseHelper dataBaseHelper=DatabaseHelper.getDB(this);
        ArrayList<Expense> arrayList=(ArrayList<Expense>) dataBaseHelper.expenseDao().getALlExpense();
        for (int i=0;i<arrayList.size();i++){
            Log. d(  "Data",  " Title: "+arrayList.get(i).getTitle() + " Amount:"+arrayList.get(i).getAmount());
        }
    }
}