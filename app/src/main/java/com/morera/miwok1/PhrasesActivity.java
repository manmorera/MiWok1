package com.morera.miwok1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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

        wordsArray.add(new Wordcustomclass("Where are you going?", "weṭeṭṭi",R.raw.phrase_where_are_you_going));
        wordsArray.add(new Wordcustomclass("What is your name?", "chokokki",R.raw.phrase_what_is_your_name));
        wordsArray.add(new Wordcustomclass("My name is...", "ṭakaakki",R.raw.phrase_my_name_is));
        wordsArray.add(new Wordcustomclass("How are you feeling?", "ṭopoppi",R.raw.phrase_how_are_you_feeling));
        wordsArray.add(new Wordcustomclass("I’m feeling good.", "kululli",R.raw.phrase_im_feeling_good));
        wordsArray.add(new Wordcustomclass("Are you coming?", "kelelli",R.raw.phrase_are_you_coming));
        wordsArray.add(new Wordcustomclass("Yes, I’m coming.", "ṭopiisә",R.raw.phrase_yes_im_coming));
        wordsArray.add(new Wordcustomclass("I’m coming.", "chiwiiṭә",R.raw.phrase_im_coming));
        wordsArray.add(new Wordcustomclass("Let’s go.", "chiwiiṭә",R.raw.phrase_lets_go));
        wordsArray.add(new Wordcustomclass("Come here.", "chiwiiṭә",R.raw.phrase_come_here));

        WordAdapter itemAdapter =
                new WordAdapter(this, wordsArray, R.color.category_phrases);
        rootview.setAdapter(itemAdapter);

        rootview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                release();
                Wordcustomclass word = wordsArray.get(position);

                Toast.makeText(PhrasesActivity.this, "Position: " + position, Toast.LENGTH_SHORT).show();
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudio());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mDone);
            }
        });
    }
        private void release() {
            if (mMediaPlayer != null) {
                mMediaPlayer.release();
                mMediaPlayer = null;
            }
        }
    }