package com.gcet.androidbasics;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MediaPlayer extends AppCompatActivity {

    private Button audioBtn;
    private Button videoBtn;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        audioBtn=findViewById(R.id.audioBtn);
        videoBtn=findViewById(R.id.videoBtn);
        videoView=findViewById(R.id.videoView);


        int a=0;
        videoView.setVideoURI(Uri.parse("android.resource://com.gcet.androidbasics/"+R.raw.video));
        android.media.MediaPlayer mediaPlayer= android.media.MediaPlayer.create(getApplicationContext(),R.raw.audio);
        mediaPlayer.setLooping(true);

        Toast.makeText(getApplicationContext(), ""+ videoView.canPause(), Toast.LENGTH_SHORT).show();

        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!videoView.isPlaying()){
                    videoView.start();
                    videoBtn.setText("Pause Video");
                    videoView.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(android.media.MediaPlayer mediaPlayer) {
                            videoView.start();
                        }
                    });
                }else{
                    videoView.pause();
                    videoBtn.setText("Play Video");
                }
            }
        });

        audioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    audioBtn.setText("Pause Audio");
                }else{
                    mediaPlayer.pause();
                    audioBtn.setText("Play Audio");
                }
            }
        });
    }
}