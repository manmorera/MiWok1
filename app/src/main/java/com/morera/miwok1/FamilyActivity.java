package com.morera.miwok1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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

        wordsArray.add(new Wordcustomclass("father", "weṭeṭṭi",R.drawable.family_father,R.raw.family_father));
        wordsArray.add(new Wordcustomclass("mother", "chokokki",R.drawable.family_mother,R.raw.family_mother));
        wordsArray.add(new Wordcustomclass("son", "ṭakaakki",R.drawable.family_son,R.raw.family_son));
        wordsArray.add(new Wordcustomclass("daughter", "ṭopoppi",R.drawable.family_daughter,R.raw.family_daughter));
        wordsArray.add(new Wordcustomclass("older brother", "kululli",R.drawable.family_older_brother,R.raw.family_older_brother));
        wordsArray.add(new Wordcustomclass("younger brother", "kelelli",R.drawable.family_younger_sister,R.raw.family_younger_brother));
        wordsArray.add(new Wordcustomclass("older sister", "ṭopiisә",R.drawable.family_older_sister,R.raw.family_older_sister));
        wordsArray.add(new Wordcustomclass("younger sister", "chiwiiṭә",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        wordsArray.add(new Wordcustomclass("grandmother", "ṭopiisә",R.drawable.family_grandmother,R.raw.family_grandmother));
        wordsArray.add(new Wordcustomclass("grandfather", "chiwiiṭә",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter itemAdapter =
                new WordAdapter(this,wordsArray,R.color.category_family);
        rootview.setAdapter(itemAdapter);

        rootview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mMediaPlayer.release();
                Wordcustomclass word = wordsArray.get(position);

                Toast.makeText(FamilyActivity.this,"Position: " + position,Toast.LENGTH_SHORT).show();
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudio());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mDone);            }
        });
    }
    private void release() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
