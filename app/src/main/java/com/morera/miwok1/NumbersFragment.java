package com.morera.miwok1;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mDone = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            release();
        }
    };


    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Wordcustomclass> wordsArray = new ArrayList<>();

        wordsArray.add(new Wordcustomclass("one", "lutti", R.drawable.number_one, R.raw.number_one));
        wordsArray.add(new Wordcustomclass("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        wordsArray.add(new Wordcustomclass("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        wordsArray.add(new Wordcustomclass("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        wordsArray.add(new Wordcustomclass("five", "massokka", R.drawable.number_five, R.raw.number_five));
        wordsArray.add(new Wordcustomclass("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        wordsArray.add(new Wordcustomclass("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        wordsArray.add(new Wordcustomclass("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        wordsArray.add(new Wordcustomclass("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        wordsArray.add(new Wordcustomclass("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), wordsArray, R.color.category_numbers);
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
