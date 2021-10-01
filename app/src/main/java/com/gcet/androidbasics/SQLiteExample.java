package com.gcet.androidbasics;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SQLiteExample extends AppCompatActivity {

    private Button addBtn;
    private Button loadBtn;
    private EditText enroll;
    private EditText name;

    DBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_example);

        dbHelper=new DBHelper(getApplicationContext());
        db=dbHelper.getWritableDatabase();

        addBtn=findViewById(R.id.addStdBtn);
        loadBtn=findViewById(R.id.loadStdBtn);

        enroll=findViewById(R.id.enrollStudent);
        name=findViewById(R.id.nameStudent);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values=new ContentValues();
                values.put(DBHelper.COLUMN_ENROLL,Integer.parseInt(enroll.getText().toString()));
                values.put(DBHelper.COLUMN_NAME,name.getText().toString());

                db.insert(DBHelper.TABLE_STUDENT,null,values);

                Toast.makeText(getApplicationContext(), "New Student Added", Toast.LENGTH_SHORT).show();
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor=db.rawQuery("SELECT * FROM "+DBHelper.TABLE_STUDENT,null);
                while(cursor.moveToNext()){
                    System.out.println("Enroll: "+cursor.getInt(0)+" Name: "+cursor.getString(1));
                }

                Toast.makeText(getApplicationContext(), "Check logcat for output", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }
}