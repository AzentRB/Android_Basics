package com.gcet.androidbasics;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManagement extends AppCompatActivity implements View.OnClickListener{

    private Button saveBtn;
    private Button loadBtn;
    private EditText editText;
    private TextView textView;
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_management);

        saveBtn=findViewById(R.id.fileSaveBtn);
        loadBtn=findViewById(R.id.fileLoadBtn);
        editText=findViewById(R.id.fileEdit);
        textView=findViewById(R.id.fileTextView);

        saveBtn.setOnClickListener(this);
        loadBtn.setOnClickListener(this);

        file =new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath()+"/text.txt");

        }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.fileSaveBtn){
            String text=editText.getText().toString();
            try {
                FileWriter fw=new FileWriter(file);
                fw.write(text);
                fw.close();
                Toast.makeText(getApplicationContext(), "Saved to file", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                FileReader fr=new FileReader(file);
                int i;
                StringBuilder stringBuilder=new StringBuilder();
                while((i=fr.read())!=-1){
                    stringBuilder.append((char)i);
                }
                fr.close();
                String text=stringBuilder.toString();
                textView.setText(text);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}