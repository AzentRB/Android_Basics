package com.gcet.androidbasics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Orientation extends AppCompatActivity {

    private Button incBtn;
    private Button dcrBtn;
    private int value=0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);

        textView=findViewById(R.id.valueText);
        incBtn=findViewById(R.id.incBtn);
        dcrBtn=findViewById(R.id.dcrBtn);

        incBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value++;
                textView.setText(Integer.toString(value));
            }
        });

        dcrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value--;
                textView.setText(Integer.toString(value));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("value",value);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        value=savedInstanceState.getInt("value");
        textView.setText(Integer.toString(value));
    }
}