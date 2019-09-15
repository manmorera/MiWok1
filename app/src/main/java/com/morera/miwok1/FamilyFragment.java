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
public class FamilyFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mDone = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            release();
        }
    };


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.word_list, container, false);

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
                new WordAdapter(getActivity(), wordsArray, R.color.category_family);
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
