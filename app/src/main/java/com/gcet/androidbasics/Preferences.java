package com.gcet.androidbasics;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class Preferences extends AppCompatActivity {

    private Button prefBtn;
    private EditText prefEdit;
    private SwitchCompat prefSwitch;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        prefBtn=findViewById(R.id.prefBtn);
        prefEdit=findViewById(R.id.prefEdit);
        prefSwitch=findViewById(R.id.prefSwitch);

        sharedPreferences=getSharedPreferences("prefs",MODE_PRIVATE);
        prefEdit.setText(sharedPreferences.getString("prefString",""));
        prefSwitch.setChecked(sharedPreferences.getBoolean("prefSwitch",false));

        prefBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                String prefString=prefEdit.getText().toString();
                boolean prefBoolean=prefSwitch.isChecked();

                editor.putBoolean("prefSwitch",prefBoolean);
                editor.putString("prefString",prefString);
                editor.apply();

                Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}