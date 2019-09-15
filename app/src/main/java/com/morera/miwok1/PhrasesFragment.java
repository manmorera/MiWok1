package com.morera.miwok1;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mDone = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            release();
        }
    };


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.word_list, container, false);

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
                new WordAdapter(getActivity(), wordsArray, R.color.category_phrases);
        ListView listview = rootview.findViewById(R.id.list);
        listview.setAdapter(itemAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                release();
                Wordcustomclass word = wordsArray.get(position);

                Toast.makeText(getActivity(), "Position: " + position, Toast.LENGTH_SHORT).show();
                mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudio());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mDone);
            }
        });
        return rootview;
    }

    private void release() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        release();
    }
}
