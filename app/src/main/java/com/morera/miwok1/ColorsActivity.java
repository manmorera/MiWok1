package com.morera.miwok1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mDone = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            release();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ListView rootview = findViewById(R.id.list);

        final ArrayList<Wordcustomclass> wordsArray = new ArrayList<>();

        wordsArray.add(new Wordcustomclass("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        wordsArray.add(new Wordcustomclass("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        wordsArray.add(new Wordcustomclass("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        wordsArray.add(new Wordcustomclass("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        wordsArray.add(new Wordcustomclass("black", "kululli", R.drawable.color_black, R.raw.color_black));
        wordsArray.add(new Wordcustomclass("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        wordsArray.add(new Wordcustomclass("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        wordsArray.add(new Wordcustomclass("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter itemAdapter =
                new WordAdapter(this, wordsArray, R.color.category_colors);
        rootview.setAdapter(itemAdapter);

        rootview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                release();
                Wordcustomclass word = wordsArray.get(position);

                Toast.makeText(ColorsActivity.this, "Position: " + position, Toast.LENGTH_SHORT).show();
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudio());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mDone);
            }
        });
    }
        private void release () {
            if (mMediaPlayer != null) {
                mMediaPlayer.release();
                mMediaPlayer = null;
            }
        }
    }

