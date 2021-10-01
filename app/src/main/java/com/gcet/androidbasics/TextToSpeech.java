package com.gcet.androidbasics;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class TextToSpeech extends AppCompatActivity {

    private android.speech.tts.TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

        EditText ttsEdit=findViewById(R.id.ttsEdit);
        Button ttsBtn=findViewById(R.id.ttsBtn);

        tts=new android.speech.tts.TextToSpeech(getApplicationContext(), i -> {
            if(i== android.speech.tts.TextToSpeech.SUCCESS){
                tts.setLanguage(Locale.ENGLISH);
            }
        });

        ttsBtn.setOnClickListener(view -> {
            String text = ttsEdit.getText().toString();

            tts.speak(text, android.speech.tts.TextToSpeech.QUEUE_ADD,null);
        });
    }
}