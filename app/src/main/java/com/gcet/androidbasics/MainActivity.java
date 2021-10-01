package com.gcet.androidbasics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       Intent intent;
        switch (item.getItemId()){
            case R.id.menuOrientation:intent=new Intent(getApplicationContext(),Orientation.class);break;
            case R.id.menuMediaPlayer:intent=new Intent(getApplicationContext(),MediaPlayer.class);break;
            case R.id.menuLocalization:intent=new Intent(getApplicationContext(),Localization.class);break;
            case R.id.menuSQLite:intent=new Intent(getApplicationContext(),SQLiteExample.class);break;
            case R.id.menuFileManagement:intent=new Intent(getApplicationContext(), FileManagement.class);break;
            case R.id.menuTts:intent=new Intent(getApplicationContext(),TextToSpeech.class);break;
            default:
                intent=new Intent(getApplicationContext(),MainActivity.class);
        }
        startActivity(intent);
        return true;
    }
}
